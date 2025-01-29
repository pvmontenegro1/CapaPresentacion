package com.espe.micro_cursos_uwu.Service;

import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Entity.Student;
import com.espe.micro_cursos_uwu.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        try{
            List<Student> student = studentRepository.findAll();
            if(student.isEmpty()){
                return new ArrayList<>();
            }
            return student;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        try{
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()){
                return student;
            }else{
                throw new RuntimeException("Student with "+id+" not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error finding Student with id " + id, e);
        }
    }

    @Override
    public Student saveStudent(Student student) {
        try {
            student.setCreated_at(LocalDateTime.now());
            return studentRepository.save(student);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error saving Student", e);
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        try{
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()){
                studentRepository.deleteById(id);
            }else{
                throw new RuntimeException("Student with "+id+" was deleted");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        try {
            Optional<Student> existingStudent = studentRepository.findById(id);
            if (existingStudent.isPresent()) {
                Student updateStudent = existingStudent.get();
                updateStudent.setFirst_name(student.getFirst_name());
                updateStudent.setLast_name(student.getLast_name());
                updateStudent.setEmail(student.getEmail());
                updateStudent.setBirthday(student.getBirthday());
                updateStudent.setPhone_number(student.getPhone_number());
                updateStudent.setCreated_at(student.getCreated_at());
                return studentRepository.save(updateStudent);
            } else {
                throw new RuntimeException("Student with id " + id + " not found");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error updating Student with id " + id, e);
        }
    }
}
