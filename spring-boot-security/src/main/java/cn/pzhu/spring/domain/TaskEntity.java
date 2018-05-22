package cn.pzhu.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String stopTime;
    private String description;
    @ManyToOne
    @JoinColumn(name="USER_EMAIL")
    private UserEntity userEntity;

    public TaskEntity() {
    }

    public TaskEntity(@NotEmpty String date, @NotEmpty String startTime, @NotEmpty String stopTime) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public TaskEntity(@NotEmpty String date, @NotEmpty String startTime, @NotEmpty String stopTime, String description, UserEntity userEntity) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.userEntity = userEntity;
    }

    public TaskEntity(@NotEmpty String date, @NotEmpty String startTime, @NotEmpty String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
