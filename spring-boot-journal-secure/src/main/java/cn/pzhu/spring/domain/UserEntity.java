package cn.pzhu.spring.domain;

import cn.pzhu.spring.domain.enumerate.RoleEnum;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "UserEntity")
public class UserEntity extends AbstractEntity {

    private String password;
    //用户名
    private String name;
    // 显示的用户真实名字
    private String displayName;
    //邮箱
    private String email;
    //出生年月
    private Date birthday;

    private String confirmationToken;

    private Date outDate;

    private String cellphone;
    private String profilePicture;
    // 表中没有role
    private RoleEnum role;
    private String studentId;

    @Formula("(select o.role from user_role_entity o where o.user_entity_id = id)")
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Email(message = "请提供有效的电子邮件")
    public String getEmail() {
        return email;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
