package com.example.newsb;


import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.entity.UserRole;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.Assert.*;

public class OneToManyTest {

    Customer costumer;


    @org.junit.Test
    public void saveTestingCustomerWithTest() {

        Test test;
        Test test2;

        costumer = new Customer("login", "password", UserRole.STUDENT,
                "email", "phone", "address");
        test = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "25 minutes", Degree.A);
        test2 = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "30 minutes", Degree.B);

        costumer.addTest(test);
        costumer.addTest(test2);
        List<Test> tests = costumer.getTests();

        Assertions.assertAll(
                () -> assertEquals(2, tests.size()),
                () -> assertNotNull(costumer));
    }
}
