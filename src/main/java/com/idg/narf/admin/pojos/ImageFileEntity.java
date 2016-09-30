package com.idg.narf.admin.pojos;

import javax.persistence.*;

/**
 * Created by agermenos on 9/28/16.
 */
@Entity
@Table(name = "image_file", schema = "narf", catalog = "narf")
public class ImageFileEntity {
    private String path;
    private Integer height;
    private Integer width;
    private String url;
    private Integer retyped;
    private ImageFileKey imageFileKey;

    @EmbeddedId
    public ImageFileKey getImageFileKey() {
        return imageFileKey;
    }

    public void setImageFileKey(ImageFileKey imageFileKey) {
        this.imageFileKey = imageFileKey;
    }

    @Basic
    @Column(name = "path", nullable = true, length = 400)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "height", nullable = true)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "width", nullable = true)
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 400)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "retyped", nullable = true)
    public Integer getRetyped() {
        return retyped;
    }

    public void setRetyped(Integer retyped) {
        this.retyped = retyped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageFileEntity that = (ImageFileEntity) o;

        if (!path.equals(that.path)) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (!url.equals(that.url)) return false;
        if (retyped != null ? !retyped.equals(that.retyped) : that.retyped != null) return false;
        return imageFileKey.equals(that.imageFileKey);
    }

    @Override
    public int hashCode() {
        int result = path.hashCode();
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + url.hashCode();
        result = 31 * result + (retyped != null ? retyped.hashCode() : 0);
        result = 31 * result + imageFileKey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImageFileEntity{" +
                "path='" + path + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", url='" + url + '\'' +
                ", retyped=" + retyped +
                ", imageFileKey=" + imageFileKey +
                '}';
    }
}
