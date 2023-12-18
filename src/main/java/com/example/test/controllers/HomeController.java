package com.example.test.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

}
