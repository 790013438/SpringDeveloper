package cn.pzhu.spring.domain;

import cn.pzhu.spring.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;
import java.util.UUID;

/**
 * 统一定义id的entity基类.
 * <p>
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 */
//JPA Entity基类的标识
@MappedSuperclass
@EnableJpaAuditing
public abstract class AbstractEntity {

    private String id = UUID.randomUUID().toString();

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 55)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Date createdDate = new Date();

    @LastModifiedDate
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date lastModifiedDate;
    @Version
    private Long version = null;

    @JsonSerialize(using = JsonDateSerializer.class)
    @CreatedDate
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
