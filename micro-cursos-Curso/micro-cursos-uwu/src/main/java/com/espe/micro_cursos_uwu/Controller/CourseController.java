package com.espe.micro_cursos_uwu.Controller;

import com.espe.micro_cursos_uwu.Entity.Course;
import com.espe.micro_cursos_uwu.Models.User;
import com.espe.micro_cursos_uwu.Service.CourseService;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // get all courser
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    // Get course by id
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    // Create a new course
    @PostMapping
    public ResponseEntity<?> createCourse(@Valid  @RequestBody Course course, BindingResult result) {
        if(result.hasErrors()){

          return error(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(course));
    }
    public ResponseEntity<?> error(BindingResult result){
        Map<String,String> errores = new HashMap<>();
        result.getFieldErrors().forEach(
                err-> errores.put(
                        err.getField(),err.getDefaultMessage()
                )
        );
        return ResponseEntity.badRequest().body(errores);
    }

    // Delete course by id
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>  updateCourse(@Valid @RequestBody Course course, @PathVariable("id") Long id, BindingResult result){
        if(result.hasErrors()){

            return error(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(course, id));

    }
    @PostMapping("/asignar-usuario/{id}")
    public ResponseEntity<?> asignarUsuario(@RequestBody User user, @PathVariable Long id){
        Optional<User> o;
        try{
            o= courseService.addUser(user,id);

        }catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje","No existe el usuario"+ " el id o error en la comunicacion "+ e.getMessage()));

        }
        if (o.isPresent()){
            return  ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }
    

}
