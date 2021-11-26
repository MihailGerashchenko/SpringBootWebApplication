package com.example.newsb.service;

import com.example.newsb.configuration.FulfillData;
import com.example.newsb.entity.Customer;
import com.example.newsb.repository.UserRepository;
import com.example.newsb.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
                }
            });
        });
    }

    @Transactional
    public boolean addUser(String login, String passHash,
                           UserRole role, String email,
                           String phone,
                           String address) {
        if (userRepository.existsByLogin(login))
            return false;

        Customer custumer = new Customer(login, passHash, role, email, phone, address);
        userRepository.save(custumer);

        return true;
    }

    @Transactional
    public Customer addUserWithTest(String login, String passHash,
                                    UserRole role, String email,
                                    String phone,
                                    String address) {

        Customer custumer = new Customer(login, passHash, role, email, phone, address);
        userRepository.save(custumer);
        return custumer;
    }

    @Transactional
    public void updateUser(String login, String email, String phone, String address) {
        Customer user = userRepository.findByLogin(login);
        if (user == null)
            return;

        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);

        userRepository.save(user);
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

