package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

import java.util.Date;

public class Request extends AbstractEntity {
    private User user;
    private Date startAt;
    private Date endAt;
    private snippets.jee.base.RequestStatus requestStatus;
    private java.util.Set<Pet> pets;
    private String details;
    private java.util.Set<Response> responses;
}
