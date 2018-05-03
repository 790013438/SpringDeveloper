package cn.pzhu.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class FavoritesEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String name;
    private Long count;
    private Long createTime;
    private Long lastModifyTime;
    private Long publicCount;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Column(nullable = false)
    public Long getCreateTime() {
        return createTime;
    }

    @Column(nullable = false)
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

    public Long getPublicCount() {
        return publicCount;
    }

    public void setPublicCount(Long publicCount) {
        this.publicCount = publicCount;
    }
}