package com.school.Controller;

import com.school.Entity.Course;
import com.school.Services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CoursesController {
    @Autowired
    private CoursesServices courses_services;

    @PostMapping("/addcourses")
    private void insertCourse(Course course) {
        courses_services.insertCourse(course);
    }

    @PutMapping("/updatecourses")
    private void updateCourse(Long courseId, @RequestParam Course updatedCourse) {
        courses_services.updateCourse(courseId, updatedCourse);
    }

    @DeleteMapping("/{id}")
    private void deleteCourse(@PathVariable Long courseId) {
        courses_services.deleteCourse(courseId);
    }

    @GetMapping("/getcourses/{id}")
    private Course getCourseById(@PathVariable Long courseId) {
        return courses_services.findCourseById(courseId);
    }

    @GetMapping("/findAllCourses")
    private List<Course> findAllCourses() {
        return courses_services.findAllCourses();
    }

}
