package com.example.newsb.repository;

import com.example.newsb.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Customer, Long> {

    Customer findByLogin(String login);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM Customer u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);

    Page<Customer> findByLoginOrderByLogin(String login, Pageable pageable);

    Page<Customer> findAllByOrderByLogin(Pageable pageable);
}

