package com.example.hibernaterelationships.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // Cascade type logic here means if we do any kind of operation on INSTRUCTOR, then the COURSES will be affected as well!
    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE})
    private List<Course> courses = new ArrayList<>();
    public Instructor(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Instructor() {

    }

    // notice how Courses aren't printed here because the of the lazy fetch type. otherwise, it will try it will produce a failed to initialize bcz of no session.
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses are lazy fetched}";
    }

    // notice how this new method prints the instructor along with its courses.
    public String toStringWithCourses(){
        return "Instructor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }



}