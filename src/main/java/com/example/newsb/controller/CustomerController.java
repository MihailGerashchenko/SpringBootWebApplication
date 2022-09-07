package com.example.newsb.controller;

import com.example.newsb.entity.Customer;
import com.example.newsb.entity.Test;
import com.example.newsb.entity.UserRole;
import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TestService testService;
    private static final int ITEMS_PER_PAGE = 5;

    public CustomerController(UserService userService, PasswordEncoder passwordEncoder, TestService testService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.testService = testService;
    }


    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String filter,
                        @PageableDefault(page = 0, size = ITEMS_PER_PAGE) Pageable pageable) {

        User user = getCurrentUser();
        String login = user.getUsername();
        Optional<Customer> dbUser = userService.findByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("admin", isAdmin(user));
        model.addAttribute("email", dbUser.get().getEmail());
        model.addAttribute("phone", dbUser.get().getPhone());
        model.addAttribute("address", dbUser.get().getAddress());

        Page<Test> tests;
        if (filter != null && !filter.isEmpty()) {
            tests = testService.findBySubject(filter, pageable);
        } else {
            tests = testService.findAll(pageable);
        }

        Page<Test> list = testService.findAll(pageable);

        model.addAttribute("itemPerPage", ITEMS_PER_PAGE);
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
    public String admin(Model model, @RequestParam(required = false) String filter,
                        @PageableDefault(page = 0, size = ITEMS_PER_PAGE) Pageable pageable) {

        Page<Customer> customers;
        if (filter != null && !filter.isEmpty()) {
            customers = userService.findByLogin(filter, pageable);
        } else {
            customers = userService.findAll(pageable);
        }

        Page<Customer> list = userService.findAll(pageable);

        model.addAttribute("customer", customers);
        model.addAttribute("users", list);
        model.addAttribute("itemPerPage", ITEMS_PER_PAGE);

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
