package com.example.hibernaterelationships.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Table(name = "review")
@Entity
@Getter
@Setter
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column(name = "comment")
    public String comment;

    public Review(String comment) {
        this.comment = comment;
    }

    public Review() {

    }
}
