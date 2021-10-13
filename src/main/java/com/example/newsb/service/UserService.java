package com.example.newsb.service;

import com.example.newsb.AppConfig;
import com.example.newsb.CustomUser;
import com.example.newsb.UserRepository;
import com.example.newsb.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final TestRepository testRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CustomUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public void deleteUsers(List<Long> ids) {
        ids.forEach(id -> {
            Optional<CustomUser> user = userRepository.findById(id);
            user.ifPresent(u -> {
                if ( ! AppConfig.ADMINISTRATOR.equals(u.getLogin())) {
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

        CustomUser user = new CustomUser(login, passHash, role, email, phone, address);
        userRepository.save(user);

        return true;
    }

//    @Transactional
//    public boolean addTest(String subject, String question1, String question2, String question3,
//                           String question4, String question5, String question6, String question7,
//                           StudentMark studentMark){
//
//        if(testRepository.existsBySubject(subject))
//            return false;
//
//        Test test = new Test(subject, question1, question2, question3, question4,
//                question5, question6, question7, studentMark);
//        testRepository.save(test);
//        return true;
//    }

    @Transactional
    public void updateUser(String login, String email, String phone) {
        CustomUser user = userRepository.findByLogin(login);
        if (user == null)
            return;

        user.setEmail(email);
        user.setPhone(phone);

        userRepository.save(user);
    }
}

