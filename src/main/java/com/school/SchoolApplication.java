package com.school;

import com.school.Entity.Course;
import com.school.Entity.Instructor;
import com.school.Entity.Registration;
import com.school.Entity.Student;
import com.school.Services.CoursesServices;
import com.school.Services.InstructorServices;
import com.school.Services.RegistrationServices;
import com.school.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SchoolApplication {

    @Autowired
    private CoursesServices coursesServices;
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private RegistrationServices registrationServices;
    @Autowired
    private InstructorServices instructorServices;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // add courses
            Course course1 = new Course();
            course1.setDescription("this is a course1");
            course1.setDuration(10);
            course1.setFee(100.0);
            course1.setLevel(Course.Level.BEGINNER);
            course1.setTitle("course1");
            coursesServices.insertCourse(course1);

            Course course2 = new Course();
            course2.setDescription("this is a course2");
            course2.setDuration(20);
            course2.setFee(200.0);
            course2.setLevel(Course.Level.INTERMEDIATE);
            course2.setTitle("course2");
            coursesServices.insertCourse(course2);

            Course course3 = new Course();
            course3.setDescription("this is a course3");
            course3.setDuration(30);
            course3.setFee(300.0);
            course3.setLevel(Course.Level.ADVANCED);
            course3.setTitle("course3");
            coursesServices.insertCourse(course3);


            /// //////////////*************************/////////////////////////
            // add students
            Student student1 = new Student();
            student1.setName("Student 1");
            student1.setEmail("student1@example.com");
            student1.setPhoneNumber("1234567890");
            student1.setAddress("Address 1");
            studentServices.insertStudent(student1);

            Student student2 = new Student();
            student2.setName("Student 2");
            student2.setEmail("student2@example.com");
            student2.setPhoneNumber("0987654321");
            student2.setAddress("Address 2");
            studentServices.insertStudent(student2);

            Student student3 = new Student();
            student3.setName("Student 3");
            student3.setEmail("student3@example.com");
            student3.setPhoneNumber("1112223333");
            student3.setAddress("Address 3");
            studentServices.insertStudent(student3);

            /// ////////////////********************////////////////////////////////////
            // add instructors
            Instructor instructor1 = new Instructor();
            instructor1.setName("Instructor 1");
            instructor1.setEmail("instructor1@example.com");
            instructor1.setPhoneNumber("1234567890");
            instructor1.getCourses().add(course1);
            instructorServices.insertInstructor(instructor1);

            Instructor instructor2 = new Instructor();
            instructor2.setName("Instructor 2");
            instructor2.setEmail("instructor2@example.com");
            instructor2.setPhoneNumber("0987654321");
            instructor2.getCourses().add(course2);
            instructorServices.insertInstructor(instructor2);

            Instructor instructor3 = new Instructor();
            instructor3.setName("Instructor 3");
            instructor3.setEmail("instructor3@example.com");
            instructor3.setPhoneNumber("1112223333");
            instructor3.getCourses().add(course3);
            instructorServices.insertInstructor(instructor3);


            // add registrations
            Registration registration1 = new Registration();
            registration1.setStudent(student1);
            registration1.setCourse(course1);
            registration1.setPaymentStatus(Registration.PaymentStatus.PAID);
            registrationServices.insertRegistration(registration1);

            Registration registration2 = new Registration();
            registration2.setStudent(student2);
            registration2.setCourse(course2);
            registration2.setPaymentStatus(Registration.PaymentStatus.PENDING);
            registrationServices.insertRegistration(registration2);

            Registration registration3 = new Registration();
            registration3.setStudent(student3);
            registration3.setCourse(course3);
            registration3.setPaymentStatus(Registration.PaymentStatus.REFUNDED);
            registrationServices.insertRegistration(registration3);


        };
    }
}
