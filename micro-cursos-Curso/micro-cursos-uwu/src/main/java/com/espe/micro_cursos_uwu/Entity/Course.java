package com.espe.micro_cursos_uwu.Entity;


import com.espe.micro_cursos_uwu.Models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @PositiveOrZero
    @Column(name = "credits", nullable = false)
    private int credits;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    //Si yo elimino el curso se elimina la matricula
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="course_id")
    private List<CourseUser> courseUsers;

    @Transient
    private List<User> user;


    public Course() {
        courseUsers=new ArrayList<>();
        user=new ArrayList<>();
    }
    public void addCourseUser(CourseUser courseUser){
        courseUsers.add(courseUser);
    }

    public void removeCourseUser(CourseUser courseUser){
        courseUsers.remove(courseUser);
    }


    public List<CourseUser> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(List<CourseUser> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
