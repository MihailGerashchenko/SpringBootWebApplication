package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public Test addTest(String subject, String question1, String question2,
                        String question3, String time, Degree degree, Customer customer) {

        Test test = new Test(subject, question1, question2, question3, time, degree);
        customer.addTest(test);
        testRepository.save(test);
        return test;
    }

    @Transactional()
    public Test addTestWithoutCustomer(String subject, String question1, String question2,
                                       String question3, String time, Degree degree) {
        Test test = new Test(subject, question1, question2, question3, time, degree);
        testRepository.save(test);
        return test;
    }

    @Transactional(readOnly = true)
    public Page<Test> getAllTestsPageable(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

//    @Transactional
//    public void updateTest(String subject, String question1, String question2,
//                           String question3, String time, Degree degree) {
//        Test test = testRepository.findBySubject(subject);
//        if (test == null)
//            return;
//        test.setSubject(subject);
//        test.setQuestion1(question1);
//        test.setQuestion2(question2);
//        test.setQuestion3(question3);
//        test.setTime(time);
//        test.setDegree(degree);
//        testRepository.save(test);
//    }

    @Transactional
    public ArrayList<Test> findTestByID(long id){
        Optional<Test> tests = testRepository.findById(id);
        ArrayList<Test> list = new ArrayList<>();
        tests.ifPresent(list::add);
        return list;
    }

    @Transactional
    public List<Test> findAllTests(){
        return testRepository.findAll();

    }
}
