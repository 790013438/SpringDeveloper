package com.snippets.spring.commons.entity;

import com.snippets.spring.commons.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PostEntity extends AbstractEntity {

    private String title;
    private String body;

    public PostEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
