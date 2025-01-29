package com.espe.micro_cursos_uwu.clients;


import com.espe.micro_cursos_uwu.Models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="micro-cursos-uwu",url="localhost:8001/api/estudiantes")
public interface UserClientRest {
    @GetMapping("/{id}")
    User getStudentById(@PathVariable Long id);

}
