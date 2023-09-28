package com.Rohit.UniversityStudent.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventName;

    private String locationOfEvent;
    private String date;
    private String startTime;
    private String endTime;

}