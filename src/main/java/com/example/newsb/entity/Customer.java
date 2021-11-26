package com.example.newsb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customers")
@Builder
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

//    @NotEmpty(message = "You have to input your login")
//    @Size(min = 2, max = 25, message = "login has to be validated between 2 and 25 characters")
    private String login;

//    @NotEmpty(message = "You have to input your password")
//    @Size(min = 2, max = 60, message = "password has to be validated between 2 and 60 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Test> tests = new ArrayList<>();

//    @NotEmpty(message = "You have to input your email")
//    @Email(message = "Email has to be valid")
    private String email;

//    @NotEmpty(message = "You have to input your phone")
//    @Size(min = 2, max = 20, message = "phone has to be validated between 7 and 20 characters")
    private String phone;

//    @NotEmpty(message = "You have to input your address")
//    @Size(min = 2, max = 30, \message = "address has to be validated between 2 and 30 characters")
    private String address;

    public Customer(String login, String password, UserRole role,
                    String email, String phone, String address) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public void addTest(Test test) {
        tests.add(test);
        test.setCustomer(this);
    }

    public Test getTest(int index) {
        return tests.get(index);
    }

    public void clearTests() {
        tests.clear();
    }
}
