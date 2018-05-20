package cn.pzhu.spring.domain;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class VideoEntity extends AbstractEntity {

    private String name;
    private String uuid = UUID.randomUUID().toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
