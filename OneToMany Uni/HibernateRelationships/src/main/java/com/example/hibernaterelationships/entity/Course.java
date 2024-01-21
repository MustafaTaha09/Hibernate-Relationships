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
@ToString
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private List<Review> reviews;
    public Course(String title) {
        this.title = title;
    }

    public Course() {
    }

    public void addReview(Review rev){ // If our Cascade type doesn't include PERSIST then we would need this helper method to add reviews.
        if(reviews == null)
            reviews = new ArrayList<>();

        reviews.add(rev);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String toStringWithReviews() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reviews=" + reviews +
                '}';

    }
}