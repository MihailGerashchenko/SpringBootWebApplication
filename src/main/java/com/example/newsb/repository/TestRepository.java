package com.example.newsb.repository;

import com.example.newsb.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

    Page<Test> findBySubjectOrderBySubjectDesc(String subject, Pageable pageable);

    Page<Test> findAllByOrderBySubject(Pageable pageable);

}
