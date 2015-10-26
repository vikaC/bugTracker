package com.bug.controller;


import com.bug.exeption.ProjectException;
import com.bug.model.Project;
import com.bug.service.ProjectService;
import com.bug.validation.ProjectValidation;
import com.bug.validation.ProjectValidationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ProjectController {

    @Autowired
    ProjectService service;

    @RequestMapping(value = "/project")
    public String getProjectList(ModelMap map) {
        map.addAttribute("projects", service.findAll());
        return "project";
    }

    @RequestMapping(value = "/project/add")
    public String addProject() {
        System.out.println("adding new project");
        return "addProject";
    }

    @RequestMapping(value = "project/add/new")
    @ResponseBody
    public String addNewProject(@RequestParam("name") String name, @RequestParam("start") String startDate,
                                @RequestParam("end") String endDate) throws ProjectException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDate start, end;
        try {
            start = LocalDate.parse(startDate, formatter);
            end = LocalDate.parse(endDate, formatter);
            System.out.println("startDate " + start.toString());
            System.out.println("endDate " + end.toString());
            System.out.println("project name " + name);
        } catch (Exception e) {
            throw new ProjectException("Wrong date format");
        }
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
