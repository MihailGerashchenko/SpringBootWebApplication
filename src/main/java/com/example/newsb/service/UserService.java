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
    public Optional<Customer> findByLogin(String login) {
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
    public Optional<Customer> addUserWithTest(String login, String passHash, UserRole role,
                                              String email, String phone, String address) {

        if (userRepository.existsByLogin(login)) {
            log.error("Student with login " + login + " already exists");
            return Optional.empty();
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
        return Optional.of(customer);
    }

    @Transactional
    public void updateUser(String login, String email, String phone, String address) {
        Optional<Customer> user = userRepository.findByLogin(login);
        if (user.isPresent()) {
            user.get().setEmail(email);
            user.get().setPhone(phone);
            user.get().setAddress(address);

            userRepository.save(user.get());
            log.info("Student with login " + login + " updated");
        } else {
            log.error("Student with login " + login + " does not exist");
            throw new IllegalStateException("Update was not performed");
        }
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

