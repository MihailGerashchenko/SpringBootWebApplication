package com.example.newsb.repository;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {

//    Page<Test> findByTag(String tag, Pageable pageable);
//
//    Page<Test> findAll(Pageable pageable);

//    List<Test> listTests(Customer customer, int start, int count);
//
//    List<Test> listTests(String pattern);
//
//    List<Test> listTests(Customer customer);

    @Query("SELECT c FROM Test c")
    List<Test> allTests();

//    @Override
//    Page<Test> findAll(Pageable pageable);

    @Query("SELECT c FROM Test c WHERE c.subject LIKE :subject")
    List<Test>  list(@Param("subject") String subject);

    @Query("SELECT COUNT(c) FROM Test c")
    long count();

}
