package com.school.Services;

import com.school.Entity.Course;
import com.school.Entity.Instructor;
import com.school.Repository.CoursesRepo;
import com.school.Repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServices {

    @Autowired
    private InstructorRepo instructorRepo;
    @Autowired
    private CoursesRepo coursesrepo;

    public List<Instructor> findAllInstructors() {
        return instructorRepo.findAll();
    }

    public Instructor insertInstructor(Instructor instructor) {
        if (instructor.getId() != null) {
            throw new RuntimeException("id should be null for new instructor");
        }
        return instructorRepo.save(instructor);
    }

    public Instructor updateInstructor(Long instructorId, Instructor updatedInstructor) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow();
        instructor.setName(updatedInstructor.getName());
        instructor.setEmail(updatedInstructor.getEmail());
        instructor.setPhoneNumber(updatedInstructor.getPhoneNumber());
        return instructorRepo.save(instructor);
    }

    public void deleteInstructor(Long instructorId) {
        instructorRepo.deleteById(instructorId);
    }

    public Instructor findInstructorById(Long instructorId) {
        return instructorRepo.findById(instructorId).orElseThrow();
    }

    /// ///////////////////////////////////////////////////////////
    public Instructor assignCourseToInstructor(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor not found with id: " + instructorId));

        Course course = coursesrepo.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found with id: " + courseId));

        instructor.getCourses().add(course);
        return instructorRepo.save(instructor);
    }

    /// /////////////////////////////////////////////////////////////
    public Instructor removeCourseFromInstructor(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor not found with id: " + instructorId));

        Course course = coursesrepo.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found with id: " + courseId));

        instructor.getCourses().remove(course);
        return instructorRepo.save(instructor);
    }
}
