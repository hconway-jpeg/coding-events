package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name field required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 50 characters.")
    private String name;

    public EventCategory () {}

    public EventCategory (String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
