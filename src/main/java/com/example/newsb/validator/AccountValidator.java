package com.example.newsb.validator;


import com.example.newsb.entity.Customer;
import com.example.newsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("accountValidator")
public class AccountValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Customer customer = (Customer) object;
        if(userService.findByLogin(customer.getLogin()) !=null){
            errors.rejectValue("login", "messages.login.exists");
        }
    }
}
