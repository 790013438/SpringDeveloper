package cn.pzhu.spring.domain;

import cn.pzhu.spring.domain.enumerate.RoleEnum;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

@Entity(name = "account")
public class AccountEntity extends AbstractEntity {

    private String accountName;
    private String password;
    private Boolean enabled;
    private String userEntityId;
    private String displayName;
    private String studentId;
    private RoleEnum userRole;
    private String teacherDisplayName;
    private String teacherId;

    @Transient
    public String getTeacherDirectory() {
        return getTeacherDisplayName() + getTeacherId();
    }

    /* 取名是student_id 对于教师用户存的是工号 */
    @Formula("(select o.student_id from user_entity o where o.id = " +
            "(select p.teacher_entity_id from lesson_entity p where p.student_entity_id = user_entity_id))")
    private String getTeacherId() {
        return teacherId;
    }

    @Formula("(select o.display_name from user_entity o where o.id =" +
            "(select p.teacher_entity_id from lesson_entity p where p.student_entity_id = user_entity_id))")
    private String getTeacherDisplayName() {
        return teacherDisplayName;
    }

    public void setTeacherDisplayName(String teacherDisplayName) {
        this.teacherDisplayName = teacherDisplayName;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Transient
    public String getPersonalDirectory() {
        return getDisplayName() + getStudentId();
    }

    @Formula("(select o.display_name from user_entity o where o.id = user_entity_id)")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Formula("(select o.student_id from user_entity o where o.id = user_entity_id)")
    private String getStudentId() {
        return studentId;
    }

    private void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Formula("(select o.role from user_role_entity o " +
            " where o.user_entity_id = user_entity_id)")
    @Enumerated(EnumType.STRING)
    public RoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
    }

    @Formula("(select o.name from user_entity o where o.id = user_entity_id)")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(String userEntityId) {
        this.userEntityId = userEntityId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccountName() {

        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
