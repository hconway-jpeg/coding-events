package org.launchcode.codingevents.models;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name field required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Email field required")
    @Email(message = "Invalid email")
    private String contactEmail;

    @ManyToOne
    @NotNull(message = "Category required")
    private EventCategory eventCategory;

    //no-arg constructor
    public Event() {}

    public Event(String name, String description, String contactEmail, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.eventCategory = eventCategory;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public EventCategory getEventCategory() { return eventCategory; }
    public void setType(EventCategory eventCategory) { this.eventCategory = eventCategory; }

    @Override
    public String toString() {
        return name;
    }

}
