package com.example.newsb.service;

import com.example.newsb.configuration.FulfillData;
import com.example.newsb.entity.Customer;
import com.example.newsb.entity.UserRole;
import com.example.newsb.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Customer findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public void deleteUsers(List<Long> ids) {
        ids.forEach(id -> {
            Optional<Customer> user = userRepository.findById(id);
            user.ifPresent(u -> {
                if (!FulfillData.ADMINISTRATOR.equals(u.getLogin())) {
                    userRepository.deleteById(u.getId());
                    log.info("Students with ids " + ids + " were deleted");
                }
            });
        });
    }

    @Transactional
    public boolean addUser(String login, String passHash, UserRole role,
                           String email, String phone, String address) {

        if (userRepository.existsByLogin(login)) {
            log.error("Student with login " + login + " already exists");
            return false;
        }

        Customer customer = Customer
                .builder()
                .login(login)
                .password(passHash)
                .role(role)
                .email(email)
                .phone(phone)
                .address(address)
                .build();

        userRepository.save(customer);
        log.info("Student with login " + login + " saved in database");
        return true;
    }

    @Transactional
    public Customer addUserWithTest(String login, String passHash, UserRole role,
                                    String email, String phone, String address) {

        if (userRepository.existsByLogin(login)) {
            log.error("Student with login " + login + " already exists");
            return null;
        }

        Customer customer = Customer
                .builder()
                .login(login)
                .password(passHash)
                .role(role)
                .email(email)
                .phone(phone)
                .address(address)
                .tests(new ArrayList<>())
                .build();

        userRepository.save(customer);
        log.info("Student with login " + login + " saved in database");
        return customer;
    }

    @Transactional
    public void updateUser(String login, String email, String phone, String address) {
        Customer user = userRepository.findByLogin(login);
        if (user == null) {
            log.error("Student with login " + login + " does not exist");
            return;
        }

        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);

        userRepository.save(user);
        log.info("Student with login " + login + " updated");
    }

    @Transactional
    public Page<Customer> findAll(Pageable pageable) {
        return userRepository.findAllByOrderByLogin(pageable);

    }

    @Transactional
    public Page<Customer> findByLogin(String login, Pageable pageable) {
        return userRepository.findByLoginOrderByLogin(login, pageable);
    }
}

