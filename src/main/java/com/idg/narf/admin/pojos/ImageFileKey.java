package com.idg.narf.admin.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by agermenos on 9/28/16.
 */
@Embeddable
public class ImageFileKey implements Serializable {

    @Column(name = "image_id")
    private Integer image_id;

    @Column(name = "image_type_id")
    private Integer image_type_id;

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Integer getImage_type_id() {
        return image_type_id;
    }

    public void setImage_type_id(Integer image_type_id) {
        this.image_type_id = image_type_id;
    }

    public ImageFileKey(Integer image_id, Integer image_type_id) {
        this.image_id = image_id;
        this.image_type_id = image_type_id;
    }

    public ImageFileKey() {
        super();
    }

    @Override
    public String toString() {
        return "ImageFileKey{" +
                "imageId=" + image_id +
                ", imageTypeId=" + image_type_id +
                '}';
    }
}
