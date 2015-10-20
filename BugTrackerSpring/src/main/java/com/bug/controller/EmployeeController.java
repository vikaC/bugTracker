package com.bug.controller;

import com.bug.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = {"/", "/index"})
    public String getIndexPage(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = "/list")
    public String getEmployeeList(ModelMap map) {
        map.addAttribute("employees", service.findAll());
        return "index";
    }

    @RequestMapping(value = "/employeeById/{id}")
    public String getEmployee(ModelMap map,@PathVariable int id) {
        map.addAttribute("employees", service.findById(id));
        return "index";
    }

    @RequestMapping(value = "/employeeByLogin/{login}")
    public String getEmployee(ModelMap map,@PathVariable String  login) {
        map.addAttribute("employees", service.findByLogin(login));
        return "index";
    }
}
