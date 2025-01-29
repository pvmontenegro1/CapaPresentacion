package com.espe.micro_cursos_uwu.Repository;

import com.espe.micro_cursos_uwu.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
