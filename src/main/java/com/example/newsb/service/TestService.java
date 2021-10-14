package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public Test addTest(String subject, String question1, String question2,
                        String question3, StudentMark studentMark, Customer customer) {

        Test test = new Test(subject, question1, question2, question3, studentMark);
        customer.addTest(test);
        testRepository.save(test);
        return test;
    }

    @Transactional()
    public Test addTestWithoutCustomer(String subject, String question1, String question2,
                                       String question3, StudentMark studentMark) {
        Test test = new Test(subject, question1, question2, question3, studentMark);
        testRepository.save(test);
        return test;
    }
    @Transactional(readOnly = true)
    public long count() {
        return testRepository.count();
    }

    @Transactional(readOnly=true)
    public List<Test> searchTests(String pattern) {
        return testRepository.list(pattern);
    }


//
//
//    @Transactional(readOnly = true)
//    public List<Test> listTests(Customer customer, int start,
//                                int count) {
//        return testRepository.listTests(customer, start, count);
//    }
//
//    @Transactional
//    public List<Test> listTests(Customer customer) {
//        return testRepository.listTests(customer, 0, 0);
//    }
//
//
//
    @Transactional(readOnly = true)
    public List<Test> getAllTests() {
        return testRepository.allTests();
    }

    @Transactional(readOnly = true)
    public Page<Test> getAllTestsPageable(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

//
//    @Transactional(readOnly = true)
//    public Test findBySubject(String subject) {
//        return testRepository.findBySubject(subject);
//    }

}
