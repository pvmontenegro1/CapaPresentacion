package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Course;
import com.espe.micro_cursos_uwu.Entity.CourseUser;
import com.espe.micro_cursos_uwu.Models.User;
import com.espe.micro_cursos_uwu.Repository.ICourseRepository;
import com.espe.micro_cursos_uwu.clients.UserClientRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private UserClientRest clientRest;

    @Override
    public List<Course> getAllCourse() {
        try{
            List<Course> courses = courseRepository.findAll();
            if(courses.isEmpty()){
                return new ArrayList<>();
            }
            return courses;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        try{
            Optional<Course> course = courseRepository.findById(id);
            if(course.isPresent()){
                return course;
            }else{
                throw new RuntimeException("Course with "+id+" not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error finding course with id " + id, e);
        }
    }

    @Override
    public Course saveCourse(Course course) {
        try {
            course.setCreated_at(LocalDateTime.now());
            return courseRepository.save(course);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error saving course", e);
        }
    }

    @Override
    public void deleteCourseById(Long id) {
        try{
            Optional<Course> course = courseRepository.findById(id);
            if(course.isPresent()){
                courseRepository.deleteById(id);
            }else{
                throw new RuntimeException("Course with "+id+" was deleted");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        try {
            Optional<Course> existingCourse = courseRepository.findById(id);
            if (existingCourse.isPresent()) {
                Course updateCourse = existingCourse.get();
                updateCourse.setName(course.getName());
                updateCourse.setDescription(course.getDescription());
                updateCourse.setCredits(course.getCredits());
                updateCourse.setCreated_at(course.getCreated_at());
                return courseRepository.save(updateCourse);
            } else {
                throw new RuntimeException("Course with id " + id + " not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error updating course with id " + id, e);
        }
    }

    @Override
    public Optional<User> addUser(User user, Long id) {
        Optional<Course> optional= courseRepository.findById(id);
        if(optional.isPresent()){
            User userTemp= clientRest.getStudentById(user.getId());
            Course course= optional.get();
            CourseUser courseUser= new CourseUser();

            courseUser.setUserId(userTemp.getId());
            course.addCourseUser(courseUser);
            courseRepository.save(course);
            return  Optional.of(userTemp);
        }
        return Optional.empty();
    }

}
