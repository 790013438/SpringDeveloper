package snippets.jee.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    protected Long id;

    /**
     * This field is used for auditory and logging purposes. It is populated by the system when an entity instance is created.
     */
    @JsonIgnore
    @Column(name = "CREATE_AT", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date createAt;

    /**
     * This field is used for auditory and logging purposes. It is populated by the system when an entity instance is modified.
     */
    @JsonIgnore
    @Column(name = "MODIFIED_AT", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date modifiedAt;

    @JsonIgnore
    @Version
    public int version;

    /**
     * This constructor is required by JPA. All subclasses of this class will inherit this constructor.
     */
    protected AbstractEntity() {
        createAt = new Date();
        modifiedAt = new Date();
    }

    /**
     * Returns the entity identifier. This identifier is unique per entity. It is used by persistence frameworks used in a project,
     * and although is public, it should not be used by application code.
     * This identifier is mapped by ORM (Object Relation Mapper) to the database primary key of the Person record to which 
     * the entity instance is mapped.
     * 
     * @return the unique entity identifier
     */
}
