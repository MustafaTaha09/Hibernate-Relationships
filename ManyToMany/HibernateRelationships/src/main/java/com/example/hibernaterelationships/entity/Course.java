package com.example.hibernaterelationships.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;


    public void addStudent(Student s){
        if(students == null)
            students = new ArrayList<>();

        students.add(s);

    }
    public Course(String title) {
        this.title = title;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String toStringWithStudents() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", students=" + students +
                '}';
    }
}