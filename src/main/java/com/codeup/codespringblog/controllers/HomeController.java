package com.codeup.codespringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String landing(){
        return "index";
    }
}
