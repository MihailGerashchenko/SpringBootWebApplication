package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public Test addTest(String subject, String question1, String question2,
                        String question3, String time, StudentMark studentMark, Customer customer) {

        Test test = new Test(subject, question1, question2, question3, time, studentMark);
        customer.addTest(test);
        testRepository.save(test);
        return test;
    }

    @Transactional()
    public Test addTestWithoutCustomer(String subject, String question1, String question2,
                                       String question3, String time, StudentMark studentMark) {
        Test test = new Test(subject, question1, question2, question3, time, studentMark);
        testRepository.save(test);
        return test;
    }

    @Transactional(readOnly = true)
    public Page<Test> getAllTestsPageable(Pageable pageable) {
        return testRepository.findAll(pageable);
    }
//    @Transactional(readOnly = true)
//    public Page<Test> getAllTestsPageable(Pageable pageable) {
//        return testRepository.findAll(pageable);
//    }

    @Transactional
    public void updateTest(String subject, String question1, String question2,
                           String question3, String time, StudentMark studentMark) {
        Test test = testRepository.findBySubject(subject);
        if (test == null)
            return;
        test.setSubject(subject);
        test.setQuestion1(question1);
        test.setQuestion2(question2);
        test.setQuestion3(question3);
        test.setTime(time);
        test.setStudentMark(studentMark);
        testRepository.save(test);
    }

}
