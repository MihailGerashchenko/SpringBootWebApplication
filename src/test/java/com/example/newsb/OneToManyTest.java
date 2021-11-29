package com.example.newsb;


import com.example.newsb.controller.CustomerController;
import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.entity.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


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


//
//    @org.junit.Test
//    public void testHomePage() throws Exception {
//        mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("login.jsp"))
//                .andExpect(content().string(
//                        containsString("Логин")));
//    }

//    @org.junit.Test
//    public void testPersist() {
//        long id = saveTestingCustomerWithTest("login", "login",
//                UserRole.STUDENT, "login@email.com", "+3548916215",
//                "Kiev", "Math", "Cos 30", "Sin 60",
//                "Cos 45", StudentMark.UPCOMING);
//
////        em.clear();
//
////        CustomUser customUser = em.find(CustomUser.class, id);
////        assertNotNull(customUser);
//
////        List<Test> tests;
////        assertEquals(2, tests.size());
//////                customUser.getTests();
//
//    }
//
//    @org.junit.Test
//    public void testRemoveClient() {
//        long id = saveTestingCustomerWithTest("login", "login",
//                UserRole.STUDENT, "login@email.com", "+3548916215",
//                "Kiev", "Math", "Cos 30", "Sin 60",
//                "Cos 45", StudentMark.UPCOMING);
//
////        em.clear();
////
////        final CustomUser customUser = em.getReference(CustomUser.class, id);
////        assertNotNull(customUser);
////
////        performTransaction(() -> {
////            em.remove(customUser);
////            return null;
////        });
//    }
//
//    @org.junit.Test
//    public void testRemoveAddress() {
//        long id = saveTestingCustomerWithTest("login", "login",
//                UserRole.STUDENT, "login@email.com", "+3548916215",
//                "Kiev", "Math", "Cos 30", "Sin 60",
//                "Cos 45", StudentMark.UPCOMING);
////
////        em.clear();
////
////        final CustomUser customUser = em.find(CustomUser.class, id);
////        assertNotNull(customUser);
////
////        final List<Test> tests = customUser.getTests();
////        assertEquals(2, tests.size());
////
////        performTransaction(() -> {
////            Test a1 = customUser.getTest(0);
////            Test a2 = customUser.getTest(1);
////
////            customUser.clearTests();
////            em.merge(customUser);
////
////            em.remove(a1);
////            em.remove(a2);
////            return null;
////        });
////
////        CustomUser customUser1 = em.find(CustomUser.class, id);
////        assertNotNull(customUser1);
////
////        List<Test> tests1 = customUser1.getTests();
////        assertEquals(0, tests1.size());
////    }
//    }
}
