package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
        //HashMap<String, String> events = new HashMap<>();
        events.put("Fancy Feast", "Not Just For Cats!");
        events.put("NerdFest", "We've got lightsabers and we're not afraid to use them.");
        events.put("Electric Boogaloo", "Probably exactly what you think it is...");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
//        events.put(eventName, eventDescription);
//        return "redirect:";
//    }

}
