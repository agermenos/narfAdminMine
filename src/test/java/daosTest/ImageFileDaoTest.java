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

    @Test
    public void getImageAboveIdTest() {
        List<ImageFileEntity> imageFiles =  imageFileDao.findAboveKey(100665980);
        int k=0;
        for (ImageFileEntity imageFile:imageFiles) {
           imageFileService.updatePathYear(imageFile, "2016", "2018");
           imageFileService.updateExtension(imageFile, "png", "jpg");
           imageFileService.updateImageFile(imageFile);
           System.out.println ("\tLeft " + (imageFiles.size()-k));
            k++;
        }
        System.out.println("Updated " + k + " instances");
    }

    @Test
    public void findById() {
        ImageFileKey imageFileKey = new ImageFileKey(100635664, 16);
        System.out.println("Image 100635664, 16 is " + imageFileService.getImageFileByKey(imageFileKey));
    }
}
