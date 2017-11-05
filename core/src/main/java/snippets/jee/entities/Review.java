package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

public class Review extends AbstractEntity {
    private Request request;
    private Response response;
    private snippets.jee.base.ReviewGrade grade;
    private String details;
}
