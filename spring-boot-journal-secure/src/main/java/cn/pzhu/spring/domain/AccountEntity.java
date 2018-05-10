package cn.pzhu.spring.domain;

import cn.pzhu.spring.domain.enumerate.RoleEnum;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name = "account")
public class AccountEntity extends AbstractEntity {

    private String accountName;
    private String password;
    private Boolean enabled;
    private String userEntityId;
    private String userName;
    private RoleEnum userRole;

    @Formula("(select o.role from user_role_entity o where o.user_entity_id = user_entity_id)")
    public RoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
    }

    @Formula("(select o.name from user_entity o where o.id = user_entity_id)")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
