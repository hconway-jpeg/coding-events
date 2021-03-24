package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.*;

import static javax.persistence.CascadeType.*;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name field required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;

    @OneToOne(cascade = ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "Category required")
    private EventCategory eventCategory;

    //no-arg constructor
    public Event() {}

    public Event(String name,  EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public EventCategory getEventCategory() { return eventCategory; }
    public void setEventCategory(EventCategory eventCategory) { this.eventCategory = eventCategory; }

    @Override
    public String toString() {
        return name;
    }

}