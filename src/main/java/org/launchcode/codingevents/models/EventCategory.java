package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min = 3, max = 20, message = "Name must be between 3 and 50 characters.")
    private String name;

    public EventCategory () {}

    public EventCategory (@Size(min = 3, max = 20, message = "Name must be between 3 and 50 characters.") String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}