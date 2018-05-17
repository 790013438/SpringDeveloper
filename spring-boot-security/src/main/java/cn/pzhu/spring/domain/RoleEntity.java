package cn.pzhu.spring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class RoleEntity {

    @Id
    private String name;
    @ManyToMany(mappedBy="roles")
    private List<UserEntity> userEntity;

    public RoleEntity() {
    }

    public RoleEntity(String name, List<UserEntity> userEntity) {
        this.name = name;
        this.userEntity = userEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(List<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }
}
