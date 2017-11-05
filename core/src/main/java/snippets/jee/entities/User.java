package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

public class User extends AbstractEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private snippets.jee.base.UserType userType;
    private String address;
    private Double rating;
    private java.util.Set<Pet> pets;
    private java.util.Set<Request> requests;
    private java.util.Set<Response> responses;
    private boolean active;
}
