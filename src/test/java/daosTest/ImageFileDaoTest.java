package daosTest;

import com.idg.narf.admin.daos.ImageFileDao;
import com.idg.narf.admin.pojos.ImageFileEntity;
import com.idg.narf.admin.pojos.ImageFileKey;
import com.idg.narf.admin.services.ImageFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

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

    public static String PATH="portraits.txt";
    public static String COPY_INSTR="\ncp --parents $1 $2";
    public static Integer HEADSHOT=6;
    public static Integer BYLINE=31;

    @Test
    public void getImageAboveIdTest() {
        List<ImageFileEntity> imageFiles =  imageFileDao.findAboveKey(100665980);
        int k=0;
        for (ImageFileEntity imageFile:imageFiles) {
           imageFileService.updatePathYear(imageFile, "2016", "2018");
           //imageFileService.preserveOriginalByType(imageFile, new int[]{31,6}, "jpg", "png");
           imageFileService.updateImageFile(imageFile);
           System.out.println ("\tLeft " + (imageFiles.size()-k));
            k++;
        }
        System.out.println("Updated " + k + " instances");
    }

    @Test
    public void getPortraitImages(){
        int[] imageTypes = {HEADSHOT, BYLINE};
        for (int imageType:imageTypes) {
            imageFileService.findByImageTypeId(imageType).parallelStream().forEach(imageFile -> {
                String command="";
                if (imageFile.getPath()!=null) {
                    command = COPY_INSTR.replace("$1", imageFile.getPath().
                            replace(".jpg", ".png").
                            replace(".jpeg", ".png")).
                            replace("$2", imageFile.getPath().
                                    replace(".jpg", ".png").
                                    replace(".jpeg", ".png").
                                    replace("/article", "/article/pngs"));
                }
                else if (imageFile.getUrl()!=null) {
                    command = COPY_INSTR.replace("$1", imageFile.getUrl().
                            replace(".jpg", ".png").
                            replace(".jpeg", ".png")).
                            replace("$2", imageFile.getUrl().
                                    replace(".jpg", ".png").
                                    replace(".jpeg", ".png").
                                    replace("/article", "/article/pngs"));
                }
                else command="*** SEARCH FOR " + imageFile.getImageFileKey().getImage_id();
                try {
                    Files.write(Paths.get(PATH), command.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void findById() {
        ImageFileKey imageFileKey = new ImageFileKey(100635664, 16);
        System.out.println("Image 100635664, 16 is " + imageFileService.getImageFileByKey(imageFileKey));
    }
}
