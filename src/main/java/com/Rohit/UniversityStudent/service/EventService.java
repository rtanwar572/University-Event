package com.Rohit.UniversityStudent.service;

import com.Rohit.UniversityStudent.entities.Event;
import com.Rohit.UniversityStudent.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }

    public void updateEvent(Event updateEvent) {
        Event event=eventRepo.findById(updateEvent.getId())
                .orElseThrow(()-> new IllegalArgumentException("Event not found"));
        event.setEventName(updateEvent.getEventName());
        event.setLocationOfEvent(updateEvent.getLocationOfEvent());
        event.setDate(updateEvent.getDate());
        event.setStartTime(updateEvent.getStartTime());
        event.setEventName(updateEvent.getEndTime());
        eventRepo.save(event);
    }

    public List<Event> getAllEventsByDate(String date) {
        return eventRepo.findAllByDate(date);
    }

    public void deleteEvent(int id) {
        eventRepo.deleteById(id);
    }
}
