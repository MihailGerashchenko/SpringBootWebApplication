package com.example.newsb.controller;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.Test;
import com.example.newsb.entity.UserRole;
import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.List;

@Controller
public class MyController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TestService testService;

    public MyController(UserService userService, PasswordEncoder passwordEncoder, TestService testService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.testService = testService;
    }

//    @GetMapping("/1")
//    public String index1(Model model, Pageable pageable) {
////        Page<Test> tests = testService.getAllTestsPageable(pageable);
////        model.addAttribute("tests", tests);
//        return "jjj";
//    }

    @GetMapping("/")
    public String index(Model model, Pageable pageable) {

        User user = getCurrentUser();

        String login = user.getUsername();
        Customer dbUser = userService.findByLogin(login);


        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("admin", isAdmin(user));
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        model.addAttribute("address", dbUser.getAddress());

        Page<Test> tests = testService.getAllTestsPageable(pageable);
        model.addAttribute("tests", tests);

        return "index";
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String address) {
        User user = getCurrentUser();

        String login = user.getUsername();
        userService.updateUser(login, email, phone, address);

        return "redirect:/";
    }

//    @GetMapping(value = "/createtest")
//    public String createTest(@RequestParam(required = false) String subject,
//                             @RequestParam(required = false) String question1,
//                             @RequestParam(required = false) String question2,
//                             @RequestParam(required = false) String question3,
//                             @RequestParam(required = false) String time,
//                             @RequestParam(required = false) StudentMark studentMark,
//                             Model model) {
//
//        model.addAttribute("subject", subject);
//        model.addAttribute("question1", question1);
//        model.addAttribute("question2", question2);
//        model.addAttribute("question3", question3);
//        model.addAttribute("time", time);
//        model.addAttribute("studentMark", studentMark);
//
//        testService.addTestWithoutCustomer(subject, question1, question2, question3, time, studentMark);
//        model.addAttribute("subject", subject);
//        return "newtest";
//    }
//
//    @PostMapping(value = "/updatetest")
//    public String updateTest(@RequestParam(required = false) String subject,
//                             @RequestParam(required = false) String question1,
//                             @RequestParam(required = false) String question2,
//                             @RequestParam(required = false) String question3,
//                             @RequestParam(required = false) String time,
//                             @RequestParam(required = false) StudentMark studentMark,
//                             Model model) {
//        testService.updateTest(subject, question1, question2, question3, time, studentMark);
//        return "redirect:/";
//    }


    // combine in DTO
    @PostMapping(value = "/newuser")
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String address,
                         Model model) {
        String passHash = passwordEncoder.encode(password);

        if (!userService.addUser(login, passHash, UserRole.STUDENT, email, phone, address)) {
            model.addAttribute("exists", true);
            model.addAttribute("login", login);
            return "register";
        }

        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "toDelete[]", required = false) List<Long> ids,
                         Model model) {
        userService.deleteUsers(ids);

        return "admin";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')") // !!!
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("tests", testService.getAllTestsPageable());
        return "admin";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

//    @GetMapping("/international")
//    public String getInternationalPage() {
//        return "international";
//    }

    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private boolean isAdmin(User user) {
        Collection<GrantedAuthority> roles = user.getAuthorities();
        //streem
//        roles.stream().filter("ROLE_ADMIN".equals(auth.getAuthority()));
        return roles.stream().anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()));

    }

//        for (GrantedAuthority auth : roles) {
//            if ("ROLE_ADMIN".equals(auth.getAuthority())) ;
//            return true;
//        }
//
//        return false;
//    }
}
