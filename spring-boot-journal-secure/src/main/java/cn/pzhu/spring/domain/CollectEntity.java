package cn.pzhu.spring.domain;

import cn.pzhu.spring.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
public class CollectEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private Long favoritesId;
    private String url;
    private String title;
    private String description;
    private String logoUrl;
    private String charset;
    private CollectType type;
    private String remark;
    private IsDelete isDelete = IsDelete.NO;
    private Long createTime;
    private Long lastModifyTime;
    private String category;
    @Transient
    private String collectTime;
    @Transient
    private String newFavorites;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Column(nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(nullable = false)
    public Long getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Long favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Column(nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = true, length = 65535, columnDefinition = "Text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = true)
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Column(nullable = true)
    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    public CollectType getType() {
        return type;
    }

    public void setType(CollectType type) {
        this.type = type;
    }

    @Column(nullable = true)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public IsDelete getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(IsDelete isDelete) {
        this.isDelete = isDelete;
    }

    @Column(nullable = false)
    @JsonSerialize(using=JsonDateSerializer.class)
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Column(nullable = false)
    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Column(nullable = true)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getNewFavorites() {
        return newFavorites;
    }

    public void setNewFavorites(String newFavorites) {
        this.newFavorites = newFavorites;
    }
}