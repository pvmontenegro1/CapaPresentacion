package com.espe.micro_cursos_uwu.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotEmpty
//    @Email //Valida eque el tambien puedad ser emial
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty(message = "El nombre debe estar bien escrito ")
    @Column(name = "last_name")
    private String last_name;

    @Email
    @Column(name = "email")
    private String email;

    @Past
    @Column(name = "birthday")

    private Date birthday;

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Solo se permiten letras, números y espacios")
    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
