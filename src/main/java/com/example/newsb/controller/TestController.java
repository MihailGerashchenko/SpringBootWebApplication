package com.example.newsb.controller;

import com.example.newsb.entity.StudentMark;
import com.example.newsb.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String createTest(){
        return "newtest";
    }

    @PostMapping(value = "/createtest")
    public String createTest(@RequestParam(required = false) String subject,
                             @RequestParam(required = false) String question1,
                             @RequestParam(required = false) String question2,
                             @RequestParam(required = false) String question3,
                             @RequestParam(required = false) String time,
                             @RequestParam(required = false) StudentMark studentMark,
                             Model model) {

//        model.addAttribute("subject", subject);
//        model.addAttribute("question1", question1);
//        model.addAttribute("question2", question2);
//        model.addAttribute("question3", question3);
//        model.addAttribute("time", time);
//        model.addAttribute("studentMark", studentMark);

        testService.addTestWithoutCustomer(subject, question1, question2, question3, time, studentMark);
        System.out.println(subject +  question1 + question2);
        return "newtest";
    }

    @PostMapping(value = "/updatetest")
    public String updateTest(@RequestParam(required = false) String subject,
                             @RequestParam(required = false) String question1,
                             @RequestParam(required = false) String question2,
                             @RequestParam(required = false) String question3,
                             @RequestParam(required = false) String time,
                             @RequestParam(required = false) StudentMark studentMark,
                             Model model) {
        testService.updateTest(subject, question1, question2, question3, time, studentMark);
        return "redirect:/";
    }
}
