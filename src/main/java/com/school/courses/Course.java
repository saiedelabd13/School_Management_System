package com.school.courses;

import com.school.instratctors.Instructor;
import com.school.Registrations.Registration;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private Integer duration; // in hours/weeks
    
    @Enumerated(EnumType.STRING)
    private Level level;
    
    private Double fee;
    
    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors = new HashSet<>();
    
    @OneToMany(mappedBy = "course")
    private Set<Registration> registrations = new HashSet<>();
    
    public enum Level {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
}