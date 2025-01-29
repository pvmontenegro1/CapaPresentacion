package com.espe.micro_cursos_uwu.Controller;

import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // get all Studentr
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    // Get Student by id
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    // Create a new Student
    @PostMapping
    public Student createStudent(@RequestBody Student Student) {
        return studentService.saveStudent(Student);
    }

    // Delete Student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student Student, @PathVariable("id") Long id){
        return studentService.updateStudent(Student, id);
    }
}
