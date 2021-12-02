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

//
//    @org.junit.Test
//    public void testHomePage() throws Exception {
//        mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("login.jsp"));
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
