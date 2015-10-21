package com.bug.controller;


import com.bug.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @Autowired
    ProjectService service;

    @RequestMapping(value = "/project")
    public String getProjectList(ModelMap map) {
        map.addAttribute("projects", service.findAll());
        return "project";
    }

    @RequestMapping(value = "/add/project")
    public String addProject(ModelMap map) {
        System.out.println("adding new project");
        return "addProject";
    }
}
