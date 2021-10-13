package com.example.newsb;

import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.example.newsb")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppConfig extends GlobalMethodSecurityConfiguration implements WebMvcConfigurer {

    public static final String ADMINISTRATOR = "admin";
    public static final String STUDENT = "student";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demo(final UserService userService,
                                  final TestService testService,
                                  final PasswordEncoder encoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService.addUser(ADMINISTRATOR,
                        encoder.encode("password"),
                        UserRole.ADMIN, "admin@gmail.com", "+380670124978", "Kiev");
                userService.addUser(STUDENT,
                        encoder.encode("password"),
                        UserRole.STUDENT, "student@gmail.com", "+380940112364", "Kiev");
                testService.addTest("Math", "Cos 30", "Sin 60",
                        "Cos 45", StudentMark.UPCOMING);

            }
        };
    }
}

