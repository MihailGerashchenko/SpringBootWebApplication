package com.example.newsb.service;

import com.example.newsb.StudentMark;
import com.example.newsb.Test;
import com.example.newsb.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
        @Transactional
    public boolean addTest(String subject, String question1, String question2,
                           String question3, StudentMark studentMark){

        Test test = new Test(subject, question1, question2, question3, studentMark);
        testRepository.save(test);
        return true;
    }
}
