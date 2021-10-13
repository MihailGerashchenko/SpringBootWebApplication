package com.example.newsb.repository;

import com.example.newsb.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    @Override
    List<Test> findAll();

    @Override
    List<Test> findAllById(Iterable<Long> longs);

    @Override
    <S extends Test> S save(S entity);

    @Override
    Optional<Test> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Test entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Test> entities);

    @Override
    void deleteAll();


}
