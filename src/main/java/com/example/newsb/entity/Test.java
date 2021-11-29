package com.example.newsb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Tests")
public class Test {

    @Id
    @GeneratedValue
    private Long id;
    private String subject;
    private String question1;
    private String question2;
    private String question3;
    private String time;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Test(String subject, String question1, String question2,
                String question3, String time, Degree degree) {
        this.subject = subject;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.time = time;
        this.degree = degree;
    }
}

