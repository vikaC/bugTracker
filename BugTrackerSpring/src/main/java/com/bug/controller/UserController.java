package com.bug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vita on 10/20/15.
 */

@Controller
public class UserController {
    
    @RequestMapping(value = {"/", "/index"})
    public String getIndexPage(ModelMap map) {
        return "index";
    }
}
