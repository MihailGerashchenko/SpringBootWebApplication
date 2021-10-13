package com.example.newsb.service;

import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    private final TestRepository testRepository;
//    private final UserRepository userRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public Test addTest(String subject, String question1, String question2,
                        String question3, StudentMark studentMark){

        Test test = new Test(subject, question1, question2, question3, studentMark);
        testRepository.save(test);
//        Customer customer = userRepository.findByLogin("student");
//        customer.addTest(test);
        return test;
    }
}
