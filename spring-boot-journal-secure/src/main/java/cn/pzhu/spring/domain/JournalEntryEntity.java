package cn.pzhu.spring.domain;

import cn.pzhu.spring.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "entry")
public class JournalEntryEntity {

    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public JournalEntryEntity(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = simpleDateFormat.parse(date);
    }

    JournalEntryEntity(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonIgnore
    @Transient
    public String getCreatedAsShort() {
        return simpleDateFormat.format(created);
    }

    @Override
    public String toString() {
        return "JournalEntryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", summary='" + summary + '\'' +
                '}';
    }
}
