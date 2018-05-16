package cn.pzhu.spring.domain;

import cn.pzhu.spring.utils.Commons;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class CommentEntity extends AbstractEntity {

    private String content;
    private String userEntityId;
    private String userName;
    private String mail;

    @Formula("(select o.email from user_entity o where o.id = user_entity_id)")
    public String getMail() {
        return mail == null ? "" : mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Transient
    public String getImgUrl() {
        return Commons.gravatar(getMail());
    }

    @Formula("(select o.display_name from user_entity o where o.id = user_entity_id)")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(String userEntityId) {
        this.userEntityId = userEntityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
