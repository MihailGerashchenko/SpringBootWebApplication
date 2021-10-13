package com.example.newsb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Customers")
public class CustomUser {
    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "customUser", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    private String email;
    private String phone;
    private String address;

    public CustomUser(String login, String password, UserRole role,
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
        test.setCustomUser(this);
    }

    public Test getTest(int index) {
        return tests.get(index);
    }

    public void clearTests() {
        tests.clear();
    }
}
