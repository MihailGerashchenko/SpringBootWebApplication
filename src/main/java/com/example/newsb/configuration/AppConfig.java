package com.example.newsb.configuration;

import com.example.newsb.entity.StudentMark;
import com.example.newsb.entity.UserRole;
import com.example.newsb.service.TestService;
import com.example.newsb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

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

                for (int i = 0; i < 10; i++) {
                    testService.addTest("Math" + i, "Cos 30", "Sin 60",
                            "Cos 45", StudentMark.UPCOMING);
                }
            }
        };
    }
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasenames("i18n");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver lr = new CookieLocaleResolver();
        lr.setCookieName("lang");
        return lr;
    }
}

