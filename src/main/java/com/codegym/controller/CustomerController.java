package com.codegym.controller;

import com.codegym.model.MyFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String upload(Model model){
        model.addAttribute("myFile", new MyFile());
        return "upload";
    }
}
