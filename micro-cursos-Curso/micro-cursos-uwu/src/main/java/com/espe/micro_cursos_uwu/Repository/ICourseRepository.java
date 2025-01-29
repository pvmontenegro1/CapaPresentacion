package com.espe.micro_cursos_uwu.Repository;

import com.espe.micro_cursos_uwu.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
