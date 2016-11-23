package daosTest;

import com.idg.narf.admin.daos.ImageFileDao;
import com.idg.narf.admin.pojos.ImageFileEntity;
import com.idg.narf.admin.pojos.ImageFileKey;
import com.idg.narf.admin.services.ImageFileService;
import com.idg.narf.admin.utils.WriteFiler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by agermenos on 9/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/beanlocations.xml")
public class ImageFileDaoTest {
    @Autowired
    ImageFileDao imageFileDao;
    @Autowired
    ImageFileService imageFileService;

    public static String PNG_TO_JPG_SQL="UPDATE image_file SET path='$1', url='$2' WHERE image_id=$3 AND image_type_id=$4;\n";
    public static String REMOVE_PNG="rm $1\n";
    public static String PNG_TO_JPG_PATH="conversion.sql";
    public static String BIOS_PATH="bio_png.txt";
    public static String REMOVE_PNG_PATH="remove_png.sh";
    public static String BIOS_SQL_PATH="bio_png.sql";
    public static Integer HEADSHOT=6;
    public static Integer BYLINE=31;
    public int jpgFiles=0;
    public int nullReferences=0;

    /*
    First script. Creates the UPDATES IN THE DATABASE for PNGs to JPG
     */
    @Test
    public void getImageAboveIdTest() {
        List<ImageFileEntity> imageFiles =  imageFileDao.getAll();
        imageFiles.parallelStream().forEach(imageFile -> {
            if ((imageFile.getPath() != null && imageFile.getPath().contains(".png")) || imageFile.getUrl() != null && imageFile.getUrl().contains(".png")) {
                WriteFiler.writeCommand(imageFile, PNG_TO_JPG_PATH, PNG_TO_JPG_SQL, ".png", ".jpg");
            }
        });
    }

    /*
    Fifth Script. Correct images in media resources to make them back into png files.
     */


    /*
    Fourth Script. Remove png files that are not bylines
     */
    @Test
    public void getRemovePngList(){
        int[] imageTypes = {53,1,55,62,4,5,59,28,2,23,10,33,22,8,58,54,25,12,64,66,68,14,24,65,67,60,19,18,52,51,50,17,56,34,30,37,13,21,15,11,9,20,38,36,16,7,39,40,32,35,26,29,61,27,3,0,63};
        for (int imageType:imageTypes) {
            imageFileService.findByImageTypeId(imageType).parallelStream().forEach(imageFile -> {
                String command;
                if (imageFile.getPath()!=null && imageFile.getPath().contains(".png")){
                    command = REMOVE_PNG.replace("$1", imageFile.getPath());
                    try {
                        Files.write(Paths.get(REMOVE_PNG_PATH), command.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               }
            });
        }
    }

    /*
    Second Script. Stores png image ids that are byline or headshot images (portraits of authors)
     */
    @Test
    public void getPortraitImagesList(){
        int[] imageTypes = {HEADSHOT, BYLINE};
        for (int imageType:imageTypes) {
            imageFileService.findByImageTypeId(imageType).parallelStream().forEach(imageFile -> {
                String command="";
                if (imageFile.getPath()!=null) {
                    command = getIdsFrom(imageFile.getPath());
                }
                else if (imageFile.getUrl()!=null) {
                    command = getIdsFrom(imageFile.getUrl());
                }
                else command="*** SEARCH FOR " + imageFile.getImageFileKey().getImage_id();
                try {
                    Files.write(Paths.get(BIOS_PATH), command.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /*
    Third script. Same as the first script, but returns pngs to jpgs
     */
    @Test
    public void createEditorRetainSQL(){
        BufferedReader br = null;
        String currentId = null;
        try {
            br = new BufferedReader(new FileReader(BIOS_PATH));
            int lines=0;
            while ((currentId = br.readLine()) != null) {
                int imageId = Integer.valueOf(currentId);
                List<ImageFileEntity> imageFiles = imageFileDao.findByImageId(imageId);
                if (imageFiles==null) {
                    System.out.println("Missing images on " + imageId + " line " + lines + " of " + BIOS_PATH);
                }
                imageFiles.parallelStream().forEach(imageFile -> {
                    if ((imageFile.getPath() != null && imageFile.getPath().contains(".png")) || imageFile.getUrl() != null && imageFile.getUrl().contains(".png")) {
                        WriteFiler.writeCommand(imageFile, BIOS_SQL_PATH, PNG_TO_JPG_SQL, ".jpg", ".png");
                    }
                    else if (imageFile.getUrl()==null && imageFile.getPath()==null)
                        incrementNullReferences();
                    else if (imageFile.getPath().contains(".jpg") || imageFile.getUrl().contains(".jpg"))
                        incrementJPGCount();

                });
                lines++;
            }
            System.out.println("Processed " + lines + " ids");
            System.out.println("Found " + jpgFiles +" files were already jpgs");
            System.out.println("Found " + nullReferences + " had empty references");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void incrementJPGCount() {
        jpgFiles++;
    }

    private void incrementNullReferences() {
        nullReferences++;
    }

    private String getIdsFrom(String path) {
        StringBuffer returnString = new StringBuffer();
        String candidates[]=path.split("-");
        String patternString = "\\d{6,9}";

        Pattern pattern = Pattern.compile(patternString);

        for (String cadidate:candidates){
            Matcher matcher = pattern.matcher(cadidate);
            if (matcher.matches()) {
                returnString.append(cadidate).append("\n");
            }
        }
        return returnString.toString();
    }

    @Test
    public void findById() {
        ImageFileKey imageFileKey = new ImageFileKey(100635664, 16);
        System.out.println("Image 100635664, 16 is " + imageFileService.getImageFileByKey(imageFileKey));
    }
}
