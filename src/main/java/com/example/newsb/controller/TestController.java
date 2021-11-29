package com.example.newsb.controller;

import com.example.newsb.entity.Degree;
import com.example.newsb.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/createtest")
    public String createTest() {
        return "newtest";
    }

    @PostMapping(value = "/createtest")
    public String createTest(@RequestParam(required = false) String subject,
                             @RequestParam(required = false) String question1,
                             @RequestParam(required = false) String question2,
                             @RequestParam(required = false) String question3,
                             @RequestParam(required = false) String time,
                             @RequestParam(required = false) Degree degree) {

        testService.addTestWithoutCustomer(subject, question1, question2, question3, time, degree);
        return "redirect:/";
    }
}
