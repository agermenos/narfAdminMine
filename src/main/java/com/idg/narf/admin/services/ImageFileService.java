package com.idg.narf.admin.services;

import com.idg.narf.admin.daos.ImageFileDao;
import com.idg.narf.admin.pojos.ImageFileEntity;
import com.idg.narf.admin.pojos.ImageFileKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by agermenos on 9/28/16.
 */
@Component("imageFileService")
public class ImageFileService {
    @Autowired
    ImageFileDao imageFileDao;
    public List<ImageFileEntity> getImageFilesAboveId(int imageId) {
        ImageFileKey ifk = new ImageFileKey();
        ifk.setImage_id(imageId);
        ImageFileEntity imageFileEntity = new ImageFileEntity();
        imageFileEntity.setImageFileKey(ifk);
        return imageFileDao.findAboveKey(imageId);
    }

    public ImageFileEntity getImageFileByKey(ImageFileKey key){
        ImageFileEntity imageFileEntity=new ImageFileEntity();
        imageFileEntity.setImageFileKey(key);
        return imageFileDao.read(imageFileEntity).get(0);
    }

    public void updatePathYear(ImageFileEntity imageFile, String fromYear, String toYear) {
        if (imageFile.getPath()!=null) imageFile.setPath(imageFile.getPath().replace(fromYear, toYear));
        if (imageFile.getUrl()!=null) imageFile.setUrl(imageFile.getUrl().replace(fromYear, toYear));
    }

    public void updateExtension(ImageFileEntity imageFile, String fromExtension, String toExtension) {
        if (imageFile.getPath()!=null) imageFile.setPath(imageFile.getPath().replace(fromExtension, toExtension));
        if (imageFile.getUrl()!=null) imageFile.setUrl(imageFile.getUrl().replace(fromExtension, toExtension));
    }

    public void updateImageFile(ImageFileEntity imageFile) {
        imageFileDao.update(imageFile);
    }
}
