package cn.pzhu.spring.domain;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;

@EnableJpaAuditing
@Entity
public class LessonEntity extends AbstractEntity {

    String studentEntityId;
    String teacherEntityId;

    public String getStudentEntityId() {
        return studentEntityId;
    }

    public void setStudentEntityId(String studentEntityId) {
        this.studentEntityId = studentEntityId;
    }

    public String getTeacherEntityId() {
        return teacherEntityId;
    }

    public void setTeacherEntityId(String teacherEntityId) {
        this.teacherEntityId = teacherEntityId;
    }
}
