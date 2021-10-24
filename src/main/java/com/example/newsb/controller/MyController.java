package com.example.newsb.controller;

import com.example.newsb.entity.Customer;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class MyController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TestService testService;
    private static final int ITEMS_PER_PAGE = 6;

    public MyController(UserService userService, PasswordEncoder passwordEncoder, TestService testService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.testService = testService;
    }


    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String filter, Pageable pageable) {
        User user = getCurrentUser();
        String login = user.getUsername();
        Customer dbUser = userService.findByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("admin", isAdmin(user));
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        model.addAttribute("address", dbUser.getAddress());

        Iterable<Test> tests;
        if (filter != null && !filter.isEmpty()) {
            tests = testService.findWithSubject(filter);
        } else {
            tests = testService.findAllTests();
        }
        Page<Test> list = testService.findAll(pageable);


//        Page<Test> pages=dao.getPage(pageable);
//        m.addAttribute("number", pages.getNumber());
//        m.addAttribute("totalPages", pages.getTotalPages());
//        m.addAttribute("totalElements", pages.getTotalElements());
//        m.addAttribute("size", pages.getSize());
//        m.addAttribute("data",pages.getContent());

        model.addAttribute("list", list);
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


    @PostMapping(value = "/newuser")
    public String update(@Valid
                         @RequestParam String login,
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
    public String delete(@RequestParam(name = "toDelete[]", required = false) List<Long> ids, Model model) {
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
    public String admin(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        long totalCount = testService.count();
        int start = page * ITEMS_PER_PAGE;
        long pageCount = (totalCount / ITEMS_PER_PAGE) +
                ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("pages", pageCount);

        return "admin";
    }


    @GetMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private boolean isAdmin(User user) {
        Collection<GrantedAuthority> roles = user.getAuthorities();
        return roles.stream().anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()));

    }
}
