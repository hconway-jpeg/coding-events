package org.launchcode.codingevents.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Field required")
    @Size(min = 3, max = 20, message = "Must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Max 500 characters")
    private String description;

    @NotBlank(message = "Field required")
    @Email(message = "Invalid email")
    private String contactEmail;

    @NotBlank(message = "Field required")
    @NotNull(message = "Field required")
    private String eventLocation;

    @AssertTrue
    private Boolean mustRegister = true;

    @NotNull(message = "Field required")
    @Min(value = 1, message = "Must be greater than 0")
    private Integer numberAttending;

    @Future(message = "Cannot be in past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    public Event(String name, String description, String contactEmail, String eventLocation, Integer numberAttending, Date eventDate) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventLocation = eventLocation;
        this.numberAttending = numberAttending;
        this.eventDate = eventDate;
    }

    public Event() {
        this.id = nextId;
        nextId++;
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

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public Boolean getMustRegister() { return mustRegister; }
    public void setMustRegister(Boolean mustRegister) { this.mustRegister = mustRegister; }

    public Integer getNumberAttending() { return numberAttending; }
    public void setNumberAttending(Integer numberAttending) { this.numberAttending = numberAttending; }

    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public int getId() { return id; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
