package com.Rohit.UniversityStudent.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message ="First name is required")
    @Pattern(regexp="^[A-Z].*",message = "First Letter Should be Capital letter")
    private String firstName;

    private String lastName;
    @Max(value=25,message = "Age should be at most 25")
    @Min(value=18,message="Age should be at least 18")
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
}