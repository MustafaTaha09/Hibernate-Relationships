package com.example.hibernaterelationships.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // Cascade type logic here means if we do any kind of operation on COURSE except for REMOVE type of operation, then the INSTRUCTOR will be affected as well!
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Column(name = "title")
    private String title;

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


    public String toStringWithInstructor() {
        return "Course{" +
                "id=" + id +
                ", instructor=" + instructor +
                ", title='" + title + '\'' +
                '}';
    }
}