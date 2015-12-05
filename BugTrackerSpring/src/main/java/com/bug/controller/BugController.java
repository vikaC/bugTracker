package com.bug.controller;

import com.bug.exeption.BugException;
import com.bug.model.Bug;
import com.bug.service.BugService;
import com.bug.validation.BugValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BugController {

    @Autowired
    BugService service;

    @Autowired
    BugValidation validator;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");

    @RequestMapping(value = "/bugs")
    private String getBugs(Model model) {
        model.addAttribute("bugs", service.findAll());
        return "bugs";
    }

    @RequestMapping(value = "/bugs/get")
    private String getBugById(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("bug", service.findById(id));
        return "bug";
    }

    @RequestMapping(value = "/bugs/add/full")
    private String addBug(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description,
                          @RequestParam(name = "creationDate") String creationDate,
                          @RequestParam(name = "dueDate") String dueDate) throws BugException {
        if (!validator.validate(name, description, creationDate, dueDate))
            throw new BugException("Validation exception");
        LocalDate creation = LocalDate.parse(creationDate);
        LocalDate due = LocalDate.parse(dueDate);
        if (!validator.isDateValid(creation, due))
            throw new BugException("Wrong data range");
        service.insert(new Bug(name, description, creation, due));
        return "success";
    }

    @RequestMapping(value = "/bugs/add")
    private String addBug(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description,
                          @RequestParam(name = "creationDate") String creationDate) throws BugException {
        if (!validator.validate(name, description, creationDate))
            throw new BugException("Validation exception");
        service.insert(new Bug(name, description, LocalDate.parse(creationDate)));
        return "success";
    }

    @RequestMapping(value = "bug/delete")
    private String deleteBug(@RequestParam(name = "id") int id) {
        service.delete(service.findById(id));
        return "success";
    }

    @RequestMapping(value = "/bugs/update/full")
    private String updateBug(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description,
                          @RequestParam(name = "creationDate") String creationDate,
                          @RequestParam(name = "dueDate") String dueDate) throws BugException {
        if (!validator.validate(name, description, creationDate, dueDate))
            throw new BugException("Validation exception");
        LocalDate creation = LocalDate.parse(creationDate,formatter);
        LocalDate due = LocalDate.parse(dueDate,formatter);
        if (!validator.isDateValid(creation, due))
            throw new BugException("Wrong data range");
        service.update(new Bug(name, description, creation, due));
        return "success";
    }

    @RequestMapping(value = "/bugs/update")
    private String updateBug(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description,
                          @RequestParam(name = "creationDate") String creationDate) throws BugException {
        if (!validator.validate(name, description, creationDate))
            throw new BugException("Validation exception");
        service.update(new Bug(name, description, LocalDate.parse(creationDate,formatter)));
        return "success";
    }




}
