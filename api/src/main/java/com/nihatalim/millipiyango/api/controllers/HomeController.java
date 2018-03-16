package com.nihatalim.millipiyango.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "redirect:/swagger-ui.html";
    }
}
