package com.school.Services;

import com.school.Entity.Student;
import com.school.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepo student_repo;

    public List<Student> findAllStudents() {
        return student_repo.findAll();
    }

    public Student insertStudent(Student student) {
        if (student.getId() != null) {
            throw new RuntimeException("id should be null for new student");
        }
        return student_repo.save(student);
    }

    public Student updateStudent(Long studentId, Student updatedStudent) {
        Student student = student_repo.findById(studentId).orElseThrow();
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        student.setAddress(updatedStudent.getAddress());
        return student_repo.save(student);
    }

    public void deleteStudent(Long studentId) {
        student_repo.deleteById(studentId);
    }

    public Student findStudentById(Long studentId) {
        return student_repo.findById(studentId).orElseThrow();
    }
}
