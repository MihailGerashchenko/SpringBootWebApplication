package com.example.newsb;


import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
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
                "Cos 45", StudentMark.UPCOMING);
        test2 = new Test("Math", "Cos 30", "Sin 60",
                "Cos 45", StudentMark.UPCOMING);
        //split for 2 test
        costumer.addTest(test);
        costumer.addTest(test2);
        List<Test> tests = costumer.getTests();
        Assertions.assertAll(
                () -> assertEquals(2, tests.size()),
                () -> assertNotNull(costumer));
    }

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
