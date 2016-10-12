package com.idg.narf.admin.services;

import com.idg.narf.admin.daos.ImageFileDao;
import com.idg.narf.admin.pojos.ImageFileEntity;
import com.idg.narf.admin.pojos.ImageFileKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by agermenos on 9/28/16.
 */
@Component("imageFileService")
public class ImageFileService {
    @Autowired
    ImageFileDao imageFileDao;
    public static String PATH="/agermenos/image_tests/shell.out";

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

    public List<ImageFileEntity> findByImageTypeId (int imageTypeId) {
        return imageFileDao.findByImageTypeId(imageTypeId);
    }

    private void addToDelete(String path) {
        // add to the delete files the current image (we should create the delete command, actually
        StringBuilder strLine = new StringBuilder();
        strLine.append("delete " + path);
        try {
            Files.write(Paths.get(PATH), strLine.toString().getBytes());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateImageFile(ImageFileEntity imageFile) {
        imageFileDao.update(imageFile);
    }
}
