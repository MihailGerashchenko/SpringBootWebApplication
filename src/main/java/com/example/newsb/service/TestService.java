package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public Optional<Test> addTest(String subject, String question1, String question2,
                                  String question3, String time, Degree degree, Customer customer) {

        Test test = Test
                .builder()
                .subject(subject)
                .question1(question1)
                .question2(question2)
                .question3(question3)
                .time(time)
                .degree(degree)
                .build();

        customer.addTest(test);
        testRepository.save(test);
        log.info("Test with subject " + test.getSubject() + " was saved into database");
        return Optional.of(test);
    }

    @Transactional()
    public Optional<Test> addTestWithoutCustomer(String subject, String question1, String question2,
                                                 String question3, String time, Degree degree) {

        Test test = Test
                .builder()
                .subject(subject)
                .question1(question1)
                .question2(question2)
                .question3(question3)
                .time(time)
                .degree(degree)
                .build();

        testRepository.save(test);
        log.info("Test with subject " + test.getSubject() + " was saved into database");
        return Optional.of(test);
    }

    @Transactional
    public Page<Test> findAll(Pageable pageable) {
        return testRepository.findAllByOrderBySubject(pageable);
    }

    @Transactional
    public Page<Test> findBySubject(String subject, Pageable pageable) {
        return testRepository.findBySubjectOrderBySubjectDesc(subject, pageable);
    }
}
