package com.cleaning.webproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUs {

    @GetMapping("/about")
    public String aboutUs(Model model) {
        return "about-us";
    }
}
