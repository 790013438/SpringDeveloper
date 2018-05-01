package cn.pzhu.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "UserEntity")
public class UserEntity extends AbstractEntity {

    private String loginName;
    private String password;
    //用户名
    private String name;//
    //邮箱
    private String email;
    //出生年月
    private Date birthday;
    //最高学历
    private Integer eduQuali;
    //性别
    private Integer sex;

    //2激活 1未激活 0不可用
    private Integer status=1;// 账号状态
    private Date createTime = new Date();
    private Date lastModifyTime;
    private String createBy = "";
    private Date lastLoginTime;
    private String cellphone;
    private String profilePicture;

    //激活账号CODE
    private String activationCode;
    //找回密码code   ""或null表示没有激活找回密码功能
    private String findPwdCode;
    //找回密码最后期限  默认设置一天之内
    private Date findPwdLastDate;

    @Column(nullable = false, unique = true)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getEduQuali() {
        return eduQuali;
    }

    public void setEduQuali(Integer eduQuali) {
        this.eduQuali = eduQuali;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getFindPwdCode() {
        return findPwdCode;
    }

    public void setFindPwdCode(String findPwdCode) {
        this.findPwdCode = findPwdCode;
    }

    public Date getFindPwdLastDate() {
        return findPwdLastDate;
    }

    public void setFindPwdLastDate(Date findPwdLastDate) {
        this.findPwdLastDate = findPwdLastDate;
    }


    private String plainPassword;
    @Transient
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    private String pwd;

    @Transient
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String roleId;

    private String findPwdUrl="";
    @Transient
    public String getFindPwdUrl() {
        return findPwdUrl;
    }

    public void setFindPwdUrl(String findPwdUrl) {
        this.findPwdUrl = findPwdUrl;
    }

}
