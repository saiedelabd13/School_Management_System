package com.school.Controller;

import com.school.Entity.Student;
import com.school.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {


    @Autowired
    private StudentServices studentService;

    @PostMapping("/addstudent")
    private Student addStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @PutMapping("/updatestudent/{id}")
    private Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/deletestudent/{id}")
    private void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/findstudent/{id}")
    private Student findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping()
    private List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
