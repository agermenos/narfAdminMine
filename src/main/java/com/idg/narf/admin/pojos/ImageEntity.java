package com.idg.narf.admin.pojos;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by agermenos on 10/12/16.
 */
@Entity
@Table(name = "image", schema = "narf", catalog = "narf")
public class ImageEntity {
    private Integer id;
    private String altText;
    private String description;
    private Integer weight;
    private String credit;
    private String defaultCaption;
    private String idgnsResourceId;
    private Integer brandId;
    private Timestamp uploadedOn;
    private Boolean isReuters;
    private Boolean isSingleUse;
    private Integer usage;
    private String creditUrl;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "alt_text", nullable = true, length = 100)
    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "credit", nullable = true, length = 500)
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "default_caption", nullable = true, length = 2000)
    public String getDefaultCaption() {
        return defaultCaption;
    }

    public void setDefaultCaption(String defaultCaption) {
        this.defaultCaption = defaultCaption;
    }

    @Basic
    @Column(name = "idgns_resource_id", nullable = true, length = 512)
    public String getIdgnsResourceId() {
        return idgnsResourceId;
    }

    public void setIdgnsResourceId(String idgnsResourceId) {
        this.idgnsResourceId = idgnsResourceId;
    }

    @Basic
    @Column(name = "brand_id", nullable = true)
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "uploaded_on", nullable = true)
    public Timestamp getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Timestamp uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    @Basic
    @Column(name = "is_reuters", nullable = true)
    public Boolean getReuters() {
        return isReuters;
    }

    public void setReuters(Boolean reuters) {
        isReuters = reuters;
    }

    @Basic
    @Column(name = "is_single_use", nullable = true)
    public Boolean getSingleUse() {
        return isSingleUse;
    }

    public void setSingleUse(Boolean singleUse) {
        isSingleUse = singleUse;
    }

    @Basic
    @Column(name = "usage", nullable = true)
    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    @Basic
    @Column(name = "credit_url", nullable = true, length = 100)
    public String getCreditUrl() {
        return creditUrl;
    }

    public void setCreditUrl(String creditUrl) {
        this.creditUrl = creditUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity that = (ImageEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (altText != null ? !altText.equals(that.altText) : that.altText != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (credit != null ? !credit.equals(that.credit) : that.credit != null) return false;
        if (defaultCaption != null ? !defaultCaption.equals(that.defaultCaption) : that.defaultCaption != null)
            return false;
        if (idgnsResourceId != null ? !idgnsResourceId.equals(that.idgnsResourceId) : that.idgnsResourceId != null)
            return false;
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        if (uploadedOn != null ? !uploadedOn.equals(that.uploadedOn) : that.uploadedOn != null) return false;
        if (isReuters != null ? !isReuters.equals(that.isReuters) : that.isReuters != null) return false;
        if (isSingleUse != null ? !isSingleUse.equals(that.isSingleUse) : that.isSingleUse != null) return false;
        if (usage != null ? !usage.equals(that.usage) : that.usage != null) return false;
        if (creditUrl != null ? !creditUrl.equals(that.creditUrl) : that.creditUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (altText != null ? altText.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        result = 31 * result + (defaultCaption != null ? defaultCaption.hashCode() : 0);
        result = 31 * result + (idgnsResourceId != null ? idgnsResourceId.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (uploadedOn != null ? uploadedOn.hashCode() : 0);
        result = 31 * result + (isReuters != null ? isReuters.hashCode() : 0);
        result = 31 * result + (isSingleUse != null ? isSingleUse.hashCode() : 0);
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        result = 31 * result + (creditUrl != null ? creditUrl.hashCode() : 0);
        return result;
    }
}
