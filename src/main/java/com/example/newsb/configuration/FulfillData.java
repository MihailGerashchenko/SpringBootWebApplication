package com.example.newsb.configuration;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
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

    @Autowired
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

        testService.addTest("Algebra", "Explaine sequences", " Explaine trigonometry",
                "Explaine equalities", "40:00", Degree.A, customer);

        testService.addTestWithoutCustomer("Phisic", "Explaine conservation of energy", "Explaine dynamics",
                "Explaine kinematics", "40:00", Degree.A);

        testService.addTestWithoutCustomer("Chemistry", "Name each element from periodic table", "Explaine electrochemistry",
                "Explaine thermochemistry", "35:00", Degree.B);

        testService.addTestWithoutCustomer("Poetry", "Nikolay Gumilyov", "Bulat Okudzhava",
                "Anna Akhmatova", "30:00", Degree.B);

        testService.addTestWithoutCustomer("Literature", "Reveal Gabriel García Márquez autobiography ", "Reveal Bulat Okudzhava autobiography",
                "Reveal Anna Akhmatova autobiography", "30:00", Degree.B);
    }
}
