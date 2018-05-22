package cn.pzhu.spring.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class RoleEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private RoleEnumerated name;
    @ManyToMany(mappedBy="roles")
    private List<UserEntity> userEntity;

    public RoleEntity() {
    }

    public RoleEntity(RoleEnumerated name) {
        this.name = name;
    }

    public RoleEntity(RoleEnumerated name, List<UserEntity> userEntity) {
        this.name = name;
        this.userEntity = userEntity;
    }

    public RoleEnumerated getName() {
        return name;
    }

    public void setName(RoleEnumerated name) {
        this.name = name;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }
}
