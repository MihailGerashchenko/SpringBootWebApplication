package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Customer> costumer = userService.findByLogin(login);
        if (costumer.isEmpty())
            throw new UsernameNotFoundException(login + " not found");
        log.error("Student with login " + login + " not found");


        List<GrantedAuthority> roles = Arrays.asList(
                new SimpleGrantedAuthority(costumer.get().getRole().toString())
        );
        return new User(costumer.get().getLogin(), costumer.get().getPassword(), roles);
    }
}

