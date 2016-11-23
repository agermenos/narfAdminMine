package com.idg.narf.admin.pojos;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by agermenos on 11/22/16.
 */
@Entity
@Table(name = "media_resource", schema = "narf", catalog = "narf")
public class MediaResourceEntity {
    private Integer id;
    private Integer resourceTypeId;
    private String slug;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private String title;
    private String shortBlurb;
    private String sponsor;
    private String source;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp resourceDate;
    private Integer pageCount;
    private String language;
    private Integer brandOwner;
    private Integer brandDisplayPerms;
    private Integer brandListPerms;
    private Integer statusId;
    private Integer imageId;
    private Integer featured;
    private Integer sortOrder;
    private String trackingToken;
    private String blurb;
    private Integer formId;
    private String regUrl;
    private Integer originId;
    private String originUrl;
    private Timestamp sponsorshipStartDate;
    private Timestamp sponsorshipEndDate;
    private String categorySlug;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resource_type_id", nullable = true)
    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    @Basic
    @Column(name = "slug", nullable = true, length = 50)
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "meta_title", nullable = true, length = 255)
    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @Basic
    @Column(name = "meta_description", nullable = true, length = 400)
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Basic
    @Column(name = "meta_keywords", nullable = true, length = 200)
    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "short_blurb", nullable = true, length = 800)
    public String getShortBlurb() {
        return shortBlurb;
    }

    public void setShortBlurb(String shortBlurb) {
        this.shortBlurb = shortBlurb;
    }

    @Basic
    @Column(name = "sponsor", nullable = true, length = 255)
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    @Basic
    @Column(name = "source", nullable = true, length = 50)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "resource_date", nullable = true)
    public Timestamp getResourceDate() {
        return resourceDate;
    }

    public void setResourceDate(Timestamp resourceDate) {
        this.resourceDate = resourceDate;
    }

    @Basic
    @Column(name = "page_count", nullable = true)
    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 50)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "brand_owner", nullable = true)
    public Integer getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(Integer brandOwner) {
        this.brandOwner = brandOwner;
    }

    @Basic
    @Column(name = "brand_display_perms", nullable = true)
    public Integer getBrandDisplayPerms() {
        return brandDisplayPerms;
    }

    public void setBrandDisplayPerms(Integer brandDisplayPerms) {
        this.brandDisplayPerms = brandDisplayPerms;
    }

    @Basic
    @Column(name = "brand_list_perms", nullable = true)
    public Integer getBrandListPerms() {
        return brandListPerms;
    }

    public void setBrandListPerms(Integer brandListPerms) {
        this.brandListPerms = brandListPerms;
    }

    @Basic
    @Column(name = "status_id", nullable = true)
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "image_id", nullable = true)
    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "featured", nullable = true)
    public Integer getFeatured() {
        return featured;
    }

    public void setFeatured(Integer featured) {
        this.featured = featured;
    }

    @Basic
    @Column(name = "sort_order", nullable = true)
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "tracking_token", nullable = true, length = 20)
    public String getTrackingToken() {
        return trackingToken;
    }

    public void setTrackingToken(String trackingToken) {
        this.trackingToken = trackingToken;
    }

    @Basic
    @Column(name = "blurb", nullable = true)
    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    @Basic
    @Column(name = "form_id", nullable = true)
    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    @Basic
    @Column(name = "reg_url", nullable = true, length = 100)
    public String getRegUrl() {
        return regUrl;
    }

    public void setRegUrl(String regUrl) {
        this.regUrl = regUrl;
    }

    @Basic
    @Column(name = "origin_id", nullable = true)
    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    @Basic
    @Column(name = "origin_url", nullable = true, length = 255)
    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    @Basic
    @Column(name = "sponsorship_start_date", nullable = true)
    public Timestamp getSponsorshipStartDate() {
        return sponsorshipStartDate;
    }

    public void setSponsorshipStartDate(Timestamp sponsorshipStartDate) {
        this.sponsorshipStartDate = sponsorshipStartDate;
    }

    @Basic
    @Column(name = "sponsorship_end_date", nullable = true)
    public Timestamp getSponsorshipEndDate() {
        return sponsorshipEndDate;
    }

    public void setSponsorshipEndDate(Timestamp sponsorshipEndDate) {
        this.sponsorshipEndDate = sponsorshipEndDate;
    }

    @Basic
    @Column(name = "category_slug", nullable = true, length = 50)
    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaResourceEntity that = (MediaResourceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resourceTypeId != null ? !resourceTypeId.equals(that.resourceTypeId) : that.resourceTypeId != null)
            return false;
        if (slug != null ? !slug.equals(that.slug) : that.slug != null) return false;
        if (metaTitle != null ? !metaTitle.equals(that.metaTitle) : that.metaTitle != null) return false;
        if (metaDescription != null ? !metaDescription.equals(that.metaDescription) : that.metaDescription != null)
            return false;
        if (metaKeywords != null ? !metaKeywords.equals(that.metaKeywords) : that.metaKeywords != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (shortBlurb != null ? !shortBlurb.equals(that.shortBlurb) : that.shortBlurb != null) return false;
        if (sponsor != null ? !sponsor.equals(that.sponsor) : that.sponsor != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (resourceDate != null ? !resourceDate.equals(that.resourceDate) : that.resourceDate != null) return false;
        if (pageCount != null ? !pageCount.equals(that.pageCount) : that.pageCount != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (brandOwner != null ? !brandOwner.equals(that.brandOwner) : that.brandOwner != null) return false;
        if (brandDisplayPerms != null ? !brandDisplayPerms.equals(that.brandDisplayPerms) : that.brandDisplayPerms != null)
            return false;
        if (brandListPerms != null ? !brandListPerms.equals(that.brandListPerms) : that.brandListPerms != null)
            return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (imageId != null ? !imageId.equals(that.imageId) : that.imageId != null) return false;
        if (featured != null ? !featured.equals(that.featured) : that.featured != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (trackingToken != null ? !trackingToken.equals(that.trackingToken) : that.trackingToken != null)
            return false;
        if (blurb != null ? !blurb.equals(that.blurb) : that.blurb != null) return false;
        if (formId != null ? !formId.equals(that.formId) : that.formId != null) return false;
        if (regUrl != null ? !regUrl.equals(that.regUrl) : that.regUrl != null) return false;
        if (originId != null ? !originId.equals(that.originId) : that.originId != null) return false;
        if (originUrl != null ? !originUrl.equals(that.originUrl) : that.originUrl != null) return false;
        if (sponsorshipStartDate != null ? !sponsorshipStartDate.equals(that.sponsorshipStartDate) : that.sponsorshipStartDate != null)
            return false;
        if (sponsorshipEndDate != null ? !sponsorshipEndDate.equals(that.sponsorshipEndDate) : that.sponsorshipEndDate != null)
            return false;
        if (categorySlug != null ? !categorySlug.equals(that.categorySlug) : that.categorySlug != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resourceTypeId != null ? resourceTypeId.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (metaTitle != null ? metaTitle.hashCode() : 0);
        result = 31 * result + (metaDescription != null ? metaDescription.hashCode() : 0);
        result = 31 * result + (metaKeywords != null ? metaKeywords.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (shortBlurb != null ? shortBlurb.hashCode() : 0);
        result = 31 * result + (sponsor != null ? sponsor.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (resourceDate != null ? resourceDate.hashCode() : 0);
        result = 31 * result + (pageCount != null ? pageCount.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (brandOwner != null ? brandOwner.hashCode() : 0);
        result = 31 * result + (brandDisplayPerms != null ? brandDisplayPerms.hashCode() : 0);
        result = 31 * result + (brandListPerms != null ? brandListPerms.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        result = 31 * result + (featured != null ? featured.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (trackingToken != null ? trackingToken.hashCode() : 0);
        result = 31 * result + (blurb != null ? blurb.hashCode() : 0);
        result = 31 * result + (formId != null ? formId.hashCode() : 0);
        result = 31 * result + (regUrl != null ? regUrl.hashCode() : 0);
        result = 31 * result + (originId != null ? originId.hashCode() : 0);
        result = 31 * result + (originUrl != null ? originUrl.hashCode() : 0);
        result = 31 * result + (sponsorshipStartDate != null ? sponsorshipStartDate.hashCode() : 0);
        result = 31 * result + (sponsorshipEndDate != null ? sponsorshipEndDate.hashCode() : 0);
        result = 31 * result + (categorySlug != null ? categorySlug.hashCode() : 0);
        return result;
    }
}
