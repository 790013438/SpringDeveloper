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
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private Long favoritesId;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true, length = 65535, columnDefinition = "Text")
    private String description;
    @Column(nullable = true)
    private String logoUrl;
    @Column(nullable = true)
    private String charset;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private CollectType type;
    @Column(nullable = true)
    private String remark;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IsDelete isDelete = IsDelete.NO;
    @Column(nullable = false)
    private Long createTime;
    @Column(nullable = false)
    private Long lastModifyTime;
    @Column(nullable = true)
    private String category;
    @Transient
    private String collectTime;
    @Transient
    private String newFavorites;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Long favoritesId) {
        this.favoritesId = favoritesId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public CollectType getType() {
        return type;
    }

    public void setType(CollectType type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public IsDelete getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(IsDelete isDelete) {
        this.isDelete = isDelete;
    }

    public Long getCreateTime() {
        return createTime;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

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