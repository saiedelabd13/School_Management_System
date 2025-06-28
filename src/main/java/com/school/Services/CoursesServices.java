package com.school.Services;

import com.school.Entity.Course;
import com.school.Repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {
    @Autowired
    private CoursesRepo coursesrepo;

    public List<Course> findAllCourses() {
        return coursesrepo.findAll();
    }

    public Course insertCourse(Course list_course) {
        if (list_course.getId() != null) {
            throw new RuntimeException("id is not null");
        }
        return coursesrepo.save(list_course);
    }

    public Course updateCourse(Long courseId, Course list_course) {
        Course course = coursesrepo.findById(list_course.getId()).orElseThrow();
        course.setTitle(list_course.getTitle());
        course.setDescription(list_course.getDescription());
        course.setDuration(list_course.getDuration());
        course.setLevel(list_course.getLevel());
        course.setFee(list_course.getFee());
        return coursesrepo.save(list_course);
    }


    public void deleteCourse(Long courseId) {
        coursesrepo.deleteById(courseId);
    }

    public Course findCourseById(Long courseId) {
        return coursesrepo.findById(courseId).orElseThrow();

    }


}


