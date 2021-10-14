package com.example.newsb.configuration;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.UserRole;
import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
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


    //    private final TestRepository testService;
//    private final UserRepository userService;
//
//    public FulfillData(TestRepository testRepository, UserRepository userRepository) {
//        this.testService = testRepository;
//        this.userService = userRepository;
//    }
    public static final String ADMINISTRATOR = "admin";
    public static final String STUDENT = "student";

    @PostConstruct
    public void fulfillData() {
        userService.addUser(ADMINISTRATOR,
                encoder.encode("password"),
                UserRole.ADMIN, "admin@gmail.com", "+380670124978", "Kiev");
//        userService.addUser(STUDENT,
//                encoder.encode("password"),
//                UserRole.STUDENT, "student@gmail.com", "+380940112364", "Kiev");
        Customer customer = userService.addUserWithTest(STUDENT,
                encoder.encode("password"),
                UserRole.STUDENT, "student@gmail.com", "+380940112364", "Kiev");

        for (int i = 1; i < 10; i++) {
            testService.addTest("Algebra test №" + i, "Sequences", "Trigonometry",
                    "Equalities", StudentMark.UPCOMING, customer);
        }
        for (int i = 1; i < 4; i++) {
            testService.addTestWithoutCustomer("Phisic test №" + i, "Conservation of Energy", "Dynamics",
                    "Kinematics", StudentMark.UPCOMING);
        }
        for (int i = 1; i < 4; i++) {
            testService.addTestWithoutCustomer("Chemistry test №" + i, "Periodic Table", "Electrochemistry",
                    "Thermochemistry", StudentMark.UPCOMING);
        }
        for (int i = 1; i < 4; i++) {
            testService.addTestWithoutCustomer("Poetry test №" + i, "Nikolay Gumilyov", "Bulat Okudzhava",
                    "Anna Akhmatova", StudentMark.UPCOMING);
        }
    }

}
