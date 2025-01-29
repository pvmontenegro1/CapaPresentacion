package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    //Get all students
    List<Student> getAllStudent();

    //Get student by id
    Optional<Student> getStudentById(Long id);

    //Save a new Student
    Student saveStudent(Student student);

    //Delete a Student
    void deleteStudentById(Long id);

    //Update Student
    Student updateStudent(Student student, Long id);
}
