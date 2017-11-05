package snippets.jee.entities;

import snippets.jee.base.AbstractEntity;

public class Pet extends AbstractEntity {
    private User owner;
    private snippets.jee.base.PetType petType;
    private String name;
    private Integer age;
    private String details;
    private String rfid;
}
