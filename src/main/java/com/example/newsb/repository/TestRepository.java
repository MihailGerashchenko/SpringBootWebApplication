package com.example.newsb.repository;

import com.example.newsb.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

//    @Query("SELECT c FROM Test c")
//    List<Test> allTests();

//
//    Optional<Test> findBySubject(String subject);

//    Optional<Test> findById(long id);

//    @Override
//    Page<Test> findAll(Pageable pageable);

//    @Query("SELECT c FROM Test c WHERE c.subject LIKE :subject")
//    List<Test>  list(@Param("subject") String subject);

    List<Test> getAllBySubject(String subject);

    @Query("SELECT COUNT(c) FROM Test c")
    long count();

//    //refactor
//    @Query("SELECT u FROM Test u where u.subject = :subject")
//    Test findBySubject(@Param("subject") String subject);

}
