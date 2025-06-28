package com.school.Controller;

import com.school.Entity.Instructor;
import com.school.Services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("instructors")
public class InstructorControler {


    @Autowired
    private InstructorServices instructorService;

    @PostMapping("/insertInstructor")
    private Instructor insertInstructor(@RequestBody Instructor instructor) {
        return instructorService.insertInstructor(instructor);
    }

    @PutMapping("/updateinstructor/{id}")
    private Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/deleteinstructor/{id}")
    private void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }

    @GetMapping("/getinstructor/{id}")
    private Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.findInstructorById(id);
    }

    @GetMapping("/findAllInstructors")
    private List<Instructor> findAllInstructors() {
        return instructorService.findAllInstructors();
    }

    @PostMapping("/{id}/courses/{courseId}")
    private Instructor assignCourse(@PathVariable Long id, @PathVariable Long courseId) {
        return instructorService.assignCourseToInstructor(id, courseId);
    }

    @DeleteMapping("/{id}/courses/{courseId}")
    private Instructor removeCourse(@PathVariable Long id, @PathVariable Long courseId) {
        return instructorService.removeCourseFromInstructor(id, courseId);
    }

}
