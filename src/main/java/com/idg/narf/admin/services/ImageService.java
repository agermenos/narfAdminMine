package com.idg.narf.admin.services;

import com.idg.narf.admin.daos.ImageEntityDao;
import com.idg.narf.admin.pojos.ImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by agermenos on 10/12/16.
 */
@Component ("imageService")
public class ImageService {
    @Autowired
    ImageEntityDao imageEntityDao;
    public void preserveOriginalByType (ImageEntity image, int imageType){
        // update path of imageFile to the png version
        //if (image)
        // add to the delete files the current image (we should create the delete command, actually

    }
}
