package com.bug.controller;

import com.bug.exeption.EmployeeException;
import com.bug.model.Employee;
import com.bug.service.EmployeeService;
import com.bug.validation.EmployeeValidation;
import com.bug.validation.EmployeeValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    //TODO add spring security

    @RequestMapping(value = {"/", "/index"})
    public String getIndexPage(ModelMap map) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/index/registration")
    public String isSignInSuccess(@RequestParam String login, @RequestParam String password,
                                  @RequestParam String confirmedPassword, @RequestParam String name,
                                  @RequestParam String surname, @RequestParam String position) throws EmployeeException {
        EmployeeValidation validator = new EmployeeValidatorImpl();
        System.out.println(login + " " + password + " " + confirmedPassword + " " + name + " " + surname);
        if (validator.validate(login, password, confirmedPassword, name, surname)) {
            Employee entity = new Employee(login, password, name, surname, position);
            service.insert(entity);
            return "success";
        } else {
            throw new EmployeeException("Registration wasn't success ");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/index/log")
    public String isLogInSuccess(@RequestParam String login, @RequestParam String password) throws EmployeeException {
        EmployeeValidation validator = new EmployeeValidatorImpl();
        System.out.println(login+" "+password);
        if (validator.validate(login, password)) {
            Employee entity = service.findByLogin(login);
            if (entity != null) {
                if (!service.isLoginPasswordMatch(login, password)) {
                    throw new EmployeeException("Password or login don't match!");
                }
            }
            return "success";
        } else {
            throw new EmployeeException("Registration wasn't successes ");
        }
    }

}
