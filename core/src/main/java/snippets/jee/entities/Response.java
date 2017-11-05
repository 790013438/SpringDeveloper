package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

public class Response extends AbstractEntity {
    private User user;
    private Request request;
    private snippets.jee.base.ResponseStatus responseStatus;
    private String details;
}
