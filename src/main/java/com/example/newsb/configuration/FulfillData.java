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

    public static final String ADMINISTRATOR = "Taras Bulba";
    public static final String STUDENT = "Samuil Marshak";
    public static final String PASSWORD = "password";

    @PostConstruct
    public void fulfillData() {
        userService.addUser(ADMINISTRATOR,
                encoder.encode(PASSWORD),
                UserRole.ADMIN, "admin@gmail.com", "+380670124978", "Kiev");

        Customer customer1 = userService.addUserWithTest(STUDENT,
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student1@gmail.com", "+380940112364", "Kiev");

        Customer customer2 = userService.addUserWithTest("Alek Bolduin",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student2@gmail.com", "+380940112364", "Dnipro");

        Customer customer3 = userService.addUserWithTest("Osho",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student3@gmail.com", "+380940112364", "Kiev");

        Customer customer4 = userService.addUserWithTest("Eva Braun",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student4@gmail.com", "+380940112364", "Lviv");

        Customer customer5 = userService.addUserWithTest("Jack London",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student5@gmail.com", "+380940112364", "Kiev");

        Customer customer6 = userService.addUserWithTest("Ray Bradbury",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student6@gmail.com", "+380940112364", "Odessa");

        Customer customer7 = userService.addUserWithTest("Charlize Theron",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student7@gmail.com", "+380940112364", "Kiev");

        Customer customer8 = userService.addUserWithTest("Uzi Narkss",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student8@gmail.com", "+380940112364", "Kiev");

        Customer customer9 = userService.addUserWithTest("Stephen King",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student9@gmail.com", "+380940112364", "Kiev");

        Customer customer10 = userService.addUserWithTest("Giuseppe Tartini",
                encoder.encode(PASSWORD),
                UserRole.STUDENT, "student10@gmail.com", "+380940112364", "Milan");


        testService.addTest("Algebra", "Explaine sequences", " Explaine trigonometry",
                "Explaine equalities", "40:00", Degree.A, customer1);

        testService.addTestWithoutCustomer("Phisic", "Explaine conservation of energy", "Explaine dynamics",
                "Explaine kinematics", "40:00", Degree.A);

        testService.addTestWithoutCustomer("Chemistry", "Call each element from periodic table", "Explaine electrochemistry",
                "Explaine thermochemistry", "35:00", Degree.B);

        testService.addTestWithoutCustomer("Poetry", "Nikolay Gumilyov", "Bulat Okudzhava",
                "Anna Akhmatova", "30:00", Degree.B);

        testService.addTestWithoutCustomer("Literature", "Reveal Gabriel García Márquez autobiography ", "Reveal Bulat Okudzhava autobiography",
                "Reveal Anna Akhmatova autobiography", "30:00", Degree.B);

        testService.addTestWithoutCustomer("Astronomy", "Where does space begin?", "Why is the sky blue?",
                "How does a telescope work?", "30:00", Degree.B);

        testService.addTestWithoutCustomer("Geography", "Which is the longest river in the world?", "Which is the largest waterfall in the world?",
                "What are the names of the 5 oceans of the world?", "30:00", Degree.B);

        testService.addTestWithoutCustomer("World War 2", "What was the longest battle of World War II?", "What was the code name for the Battle of Normandy?",
                "What was the last major battle of World War II?", "30:00", Degree.A);

        testService.addTestWithoutCustomer("World War 1", "Who won World War I?", "What countries fought in World War I?",
                "Why was the Lusitania important?", "30:00", Degree.A);

        testService.addTestWithoutCustomer("Astrophysic", "What do black holes look like?", "What happened in the early universe?",
                "Does life exist outside of the solar system?", "30:00", Degree.A);
    }
}
