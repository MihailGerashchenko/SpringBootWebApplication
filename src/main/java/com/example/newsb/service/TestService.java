package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.repository.TestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional
    public List<Test> findWithSubject(String subject){
        return testRepository.findBySubject(subject);
    }

    @Transactional
    public Page<Test> findAllPage(Pageable pageable){
        return testRepository.findAll(pageable);
    }
    @Transactional
    public Page<Test> findSubjectPage(String subject, Pageable pageable){
        return testRepository.findBySubject(subject, pageable);
    }

    @Transactional
    public Page<Test> findPagenated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return testRepository.findAll(pageable);
    }
}
