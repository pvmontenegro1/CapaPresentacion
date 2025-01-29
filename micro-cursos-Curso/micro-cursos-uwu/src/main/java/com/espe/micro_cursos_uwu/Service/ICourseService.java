package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Course;
import com.espe.micro_cursos_uwu.Models.User;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    //Get all courses
    List<Course> getAllCourse();

    //Get course by id
    Optional<Course> getCourseById(Long id);

    //Save a new course
    Course saveCourse(Course course);

    //Delete a course
    void deleteCourseById(Long id);

    //Update course
    Course updateCourse(Course course, Long id);

    Optional<User> addUser(User user, Long id);
}
