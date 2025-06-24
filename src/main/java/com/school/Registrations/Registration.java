package com.school.Registrations;

import com.school.students.Student;
import com.school.courses.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
   // @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
  //  @JoinColumn(name = "course_id")
    private Course course;
    
    private LocalDateTime registrationDate;

    public enum PaymentStatus {
        PENDING, PAID, REFUNDED, CANCELLED
    }
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}