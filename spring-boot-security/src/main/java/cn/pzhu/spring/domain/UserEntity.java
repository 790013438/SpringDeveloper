package cn.pzhu.spring.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min = 4)
    private String password;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")

    })
    private List<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
