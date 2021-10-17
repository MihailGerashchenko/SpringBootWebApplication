package com.example.newsb.configuration;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.UserRole;
import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FulfillData {
    private final UserService userService;
    private final TestService testService;
    private final PasswordEncoder encoder;

    public FulfillData(UserService userService, TestService testService, PasswordEncoder encoder) {
        this.userService = userService;
        this.testService = testService;
        this.encoder = encoder;
    }

    public static final String ADMINISTRATOR = "admin";
    public static final String STUDENT = "student";

    @PostConstruct
    public void fulfillData() {
        userService.addUser(ADMINISTRATOR,
                encoder.encode("password"),
                UserRole.ADMIN, "admin@gmail.com", "+380670124978", "Kiev");
        Customer customer = userService.addUserWithTest(STUDENT,
                encoder.encode("password"),
                UserRole.STUDENT, "student@gmail.com", "+380940112364", "Kiev");

        testService.addTest("Algebra test №", "Sequences", "Trigonometry",
                "Equalities", "25 minutes", StudentMark.UPCOMING, customer);

        testService.addTestWithoutCustomer("Phisic test №", "Conservation of Energy", "Dynamics",
                "Kinematics", "40 minutes", StudentMark.UPCOMING);

        testService.addTestWithoutCustomer("Chemistry test №", "Periodic Table", "Electrochemistry",
                "Thermochemistry", "35 minutes", StudentMark.UPCOMING);

        testService.addTestWithoutCustomer("Poetry test №", "Nikolay Gumilyov", "Bulat Okudzhava",
                "Anna Akhmatova", "30 minutes", StudentMark.UPCOMING);
    }
}
