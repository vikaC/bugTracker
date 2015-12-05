package com.bug.controller;


import com.bug.exeption.ProjectException;
import com.bug.model.Project;
import com.bug.service.ProjectService;
import com.bug.validation.ProjectValidation;
import com.bug.validation.ProjectValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ProjectController {

    @Autowired
    ProjectService service;
    @Autowired
    ProjectValidation validator;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");

    @RequestMapping(value = "/project")
    public String getProjectList(ModelAndView map) {
        map.addObject("projects", service.findAll());
        return "projects";
    }

    @RequestMapping(value = "project/add/new")
    @ResponseBody
    public String addNewProject(@RequestParam("name") String name, @RequestParam("start") String startDate,
                                @RequestParam("end") String endDate) throws ProjectException {
        if (!validator.validate(endDate, startDate, name))
            throw new ProjectException("Validation exception");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        ProjectValidation validator = new ProjectValidationImpl();
        if (validator.isValidDates(start, end)) {
            if (validator.isNameValid(name)) {
                Project project = new Project(name, start, end);
                service.insert(project);
            } else {
                throw new ProjectException("Project name to short! Length of name should be bigger than 4 character!");
            }
        } else {
            throw new ProjectException("Start date later than Due Date");
        }
        return "success";
    }
}
