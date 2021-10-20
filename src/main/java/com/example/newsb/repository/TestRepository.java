package com.example.newsb.repository;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findBySubject(String subject);

    Page<Test> findBySubject(String subject, Pageable pageable);

    Page<Test> findAll(Pageable pageable);

//    List<Test> listContacts(Customer customer, int start, int count);

//    @Query("SELECT COUNT(c) FROM Test c")
//    long count();

}
