package com.example.newsb.service;

import com.example.newsb.entity.Customer;
import com.example.newsb.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer costumer = userService.findByLogin(login);
        if (costumer == null)
            throw new UsernameNotFoundException(login + " not found");

        List<GrantedAuthority> roles = Arrays.asList(
                new SimpleGrantedAuthority(costumer.getRole().toString())
        );

        return new User(costumer.getLogin(), costumer.getPassword(), roles);
    }
}

