package com.example.newsb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Tests")
public class Test {

    @Id
    @GeneratedValue
    private Long id;

//    @NotEmpty(message = "You have to input subject")
//    @Size(min = 2, max = 25, message = "subject has to be validated between 2 and 30 characters")
    private String subject;

//    @NotEmpty(message = "You have to input question1")
//    @Size(min = 3, max = 100, message = "question1 has to be validated between 10 and 100 characters")
    private String question1;

//    @NotEmpty(message = "You have to input question2")
//    @Size(min = 3, max = 100, message = "question2 has to be validated between 10 and 100 characters")
    private String question2;

//    @NotEmpty(message = "You have to input question3")
//    @Size(min = 3, max = 100, message = "question3 has to be validated between 10 and 100 characters")
    private String question3;

    @NotEmpty(message = "You have to input time for students at your convinience")
    private String time;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToOne
    @JoinColumn(name= "customer_id")
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

