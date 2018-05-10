package cn.pzhu.spring.domain;

import cn.pzhu.spring.domain.enumerate.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class UserRoleEntity extends AbstractEntity{

    private String UserEntityId;

    private RoleEnum role;

    public String getUserEntityId() {
        return UserEntityId;
    }

    public void setUserEntityId(String userEntityId) {
        UserEntityId = userEntityId;
    }

    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
