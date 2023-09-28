package com.Rohit.UniversityStudent.Controller;

import com.Rohit.UniversityStudent.entities.Event;
import com.Rohit.UniversityStudent.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController{
    @Autowired
    private EventService eventService;
    @PostMapping
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event)
    {
        Event addedEvent=eventService.addEvent(event);
        return ResponseEntity.ok(addedEvent);
    }
    @PutMapping
    public ResponseEntity<Void>updateEvent(@Valid @RequestBody Event event)
    {
        eventService.updateEvent(event);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Event>>getAllEventsByDate(@RequestParam String date)
    {
        List<Event> events=eventService.getAllEventsByDate(date);
        return ResponseEntity.ok(events);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void>deleteEvent(@PathVariable int Id)
    {
        eventService.deleteEvent(Id);
        return ResponseEntity.ok().build();
    }

}