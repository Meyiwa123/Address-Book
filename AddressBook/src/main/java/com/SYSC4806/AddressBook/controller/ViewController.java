package com.SYSC4806.AddressBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {
    @GetMapping("/home")
    public String showHomePage () {
        return "home";
    }
}
