package com.example.newsb;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Tests")
public class Test {

    @Id
    @GeneratedValue
    private Long id;

    private String subject;
    private String question1;
    private String question2;
    private String question3;
    @Enumerated(EnumType.STRING)
    private StudentMark studentMark;

    @ManyToOne
    @JoinColumn(name= "customer_id")
    private CustomUser customUser;

    public Test(String subject, String question1, String question2,
                String question3, StudentMark studentMark) {
        this.subject = subject;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.studentMark = studentMark;
    }
}

