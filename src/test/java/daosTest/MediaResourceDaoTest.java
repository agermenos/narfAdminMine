package daosTest;

import com.idg.narf.admin.daos.ImageFileDao;
import com.idg.narf.admin.daos.MediaResourceDao;
import com.idg.narf.admin.pojos.MediaResourceEntity;
import com.idg.narf.admin.utils.WriteFiler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by agermenos on 11/22/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/beanlocations.xml")
public class MediaResourceDaoTest {
    private static final String SCRIPT_PATH = "jpg_to_png.sql";
    @Autowired
    MediaResourceDao mediaResourceDao;
    @Autowired
    ImageFileDao imageFileDao;

    public static String PNG_TO_JPG_SQL="UPDATE image_file SET path='$1', url='$2' WHERE image_id=$3 AND image_type_id=$4;\n";
    /*
    Script 1: Transform all media resource files back to png
     */
    @Test
    public void test1() {
        List<MediaResourceEntity> mediaResourceEntityList = mediaResourceDao.getAll();
        mediaResourceEntityList.stream().forEach(mediaResource -> {
            System.out.println("Working on media_resource id: " + mediaResource.getId());
            if (mediaResource.getImageId()!=null) {
                imageFileDao.findByImageId(mediaResource.getImageId()).parallelStream().forEach(imageFile -> {
                    if (imageFile!=null && imageFile.getPath()!=null && imageFile.getPath().contains("imageapi/2016") && imageFile.getPath().contains(".jpg")) {
                        WriteFiler.writeCommand(imageFile, SCRIPT_PATH, PNG_TO_JPG_SQL, "jpg", "png");
                    }
                });
            }
        });
    }
    /*
    Rengineering the first solution
     */
    @Test
    public void test2(){
        imageFileDao.findMediaResourceImageFiles().parallelStream().forEach(imageFile -> {
            if (imageFile!=null && imageFile.getPath()!=null && imageFile.getPath().contains(".jpg")) {
                WriteFiler.writeCommand(imageFile, SCRIPT_PATH, PNG_TO_JPG_SQL, "jpg", "png");
            }
        });

    }



}
