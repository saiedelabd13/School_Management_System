package com.school.students;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    
    @OneToMany(mappedBy = "student")
    private Set<Registration> registrations = new HashSet<>();
}