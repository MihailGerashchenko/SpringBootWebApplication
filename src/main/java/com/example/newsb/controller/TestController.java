package com.example.newsb.controller;

import com.example.newsb.entity.Degree;
import com.example.newsb.entity.Test;
import com.example.newsb.exceptions.ApiRequestException;
import com.example.newsb.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
//        throw new ;

        testService.addTestWithoutCustomer(subject, question1, question2, question3, time, degree);
        return "redirect:/";
    }

//    @GetMapping("filter")
//    public String filterSubjectGet(@RequestParam(required = false) String filter,
//                                Model model) {
//        List<Test> list = testService.findAllTests();
//        model.addAttribute("tests", list);
//
//        Iterable<Test> tests;
//        if(filter !=null && !filter.isEmpty()){
//            tests = testService.findWithSubject(filter);
//        } else {
//            tests = testService.findAllTests();
//        }
//
//
//        model.addAttribute("tests", tests);
//        return "index";
//    }

//    @PostMapping("filter")
//    public String filterSubject(@RequestParam(required = false) String filter,
//                         Model model) {
//        Iterable<Test> tests;
//        if(filter !=null && !filter.isEmpty()){
//            tests = testService.findWithSubject(filter);
//        } else {
//            tests = testService.findAllTests();
//        }
//
//
//        model.addAttribute("tests", tests);
//        return "index";
//    }
//    @PostMapping("filter")
//    public String filterDegree(@RequestParam(required = false) String degree,
//                         Model model) {
//        Iterable<Test> tests;
//        if(degree !=null && !degree.isEmpty()){
//            tests = testService.findWithDegree(degree);
//        } else {
//            tests = testService.findAllTests();
//        }
//
//        model.addAttribute("tests", tests);
//        return "index";
//    }


//    @PostMapping("degree")
//    public String degree(@RequestParam(required = false) String degree,
//                         Model model) {
//        Iterable<Test> tests;
//        if(degree !=null && !degree.isEmpty()){
//            tests = testService.findTag(degree);
//        } else {
//            tests = testService.findAllTests();
//        }
//
//        model.addAttribute("tests", tests);
//        return "index";
//    }

//    @GetMapping("/iii)
//    public String testIDD(Model model){
//        List<Test> list = testService.findAllTests();
//        model.addAttribute("tests", list);
//        return "bundle";
//    }

//    @GetMapping("/test1")
//    public String testAll(Model model){
//        List<Test> list = testService.findAllTests();
//        model.addAttribute("tests", list);
//        for (Test test : list) {
//            System.out.println("OOOOOOOOOPPPPPPPPPPPPPPPPPP"+test);
//        }
//        return "bundle";
//    }

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
