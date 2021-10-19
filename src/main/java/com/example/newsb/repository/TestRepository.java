package com.example.newsb.repository;

import com.example.newsb.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findBySubject(String subject);

    List<Test> findByDegree(String degree);

//    List<Test> getAllBySubject(String subject);

    @Query("SELECT COUNT(c) FROM Test c")
    long count();

}
