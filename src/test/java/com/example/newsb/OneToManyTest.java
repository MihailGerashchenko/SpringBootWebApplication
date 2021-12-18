package com.example.newsb;


import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.entity.UserRole;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest
public class OneToManyTest {

    Customer costumer;

    @org.junit.Test
    public void testOne() {

        Test test;
        Test test2;
        costumer = new Customer(1L, "login", "password", UserRole.STUDENT,
                new ArrayList<Test>(), "email", "phone", "address");
        test = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "25 minutes", Degree.A);
        test2 = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "30 minutes", Degree.B);

        costumer.addTest(test);
        costumer.addTest(test2);
        List<Test> tests = costumer.getTests();
        assertEquals(2, tests.size());
    }

    @org.junit.Test
    public void testTwo() {

        Test test;
        Test test2;
        costumer = new Customer(1L, "login", "password", UserRole.STUDENT,
                new ArrayList<Test>(), "email", "phone", "address");
        test = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "25 minutes", Degree.A);
        test2 = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", "30 minutes", Degree.B);

        costumer.addTest(test);
        costumer.addTest(test2);
        assertNotNull(costumer);
    }
}
