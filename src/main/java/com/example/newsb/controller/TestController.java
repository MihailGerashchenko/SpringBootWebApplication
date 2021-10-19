package com.example.newsb.controller;

import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.exceptions.ErrorException;
import com.example.newsb.exceptions.Response;
import com.example.newsb.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String createTest(@Valid
                             @RequestParam(required = false) String subject,
                             @RequestParam(required = false) String question1,
                             @RequestParam(required = false) String question2,
                             @RequestParam(required = false) String question3,
                             @RequestParam(required = false) String time,
                             @RequestParam(required = false) Degree degree) {


        testService.addTestWithoutCustomer(subject, question1, question2, question3, time, degree);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String testID( long id, Model model){
        ArrayList<Test> list = testService.findTestByID(id);
        model.addAttribute("tests", list);
        return "bundle";
    }

    @GetMapping("/test1")
    public String testAll(Model model){
        List<Test> list = testService.findAllTests();
        model.addAttribute("tests", list);
        for (Test test : list) {
            System.out.println("OOOOOOOOOPPPPPPPPPPPPPPPPPP"+test);
        }
        return "bundle";
    }

//    @PostMapping(value = "/updatetest")
//    public String updateTest(@Valid
//                             @RequestParam(required = false) String subject,
//                             @RequestParam(required = false) String question1,
//                             @RequestParam(required = false) String question2,
//                             @RequestParam(required = false) String question3,
//                             @RequestParam(required = false) String time,
//                             @RequestParam(required = false) Degree degree) {
//
//        testService.updateTest(subject, question1, question2, question3, time, degree);
//        return "redirect:/";
//    }
//    @ExceptionHandler(ErrorException.class)
//    public Response handleException(ErrorException e) {
//        return new Response(e.getMessage());
//    }
}
