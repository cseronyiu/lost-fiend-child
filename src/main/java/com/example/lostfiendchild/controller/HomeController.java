package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.service.LostChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    LostChildService lostChildService;
    @GetMapping(value = "/")
    String index(Model model)
    {
        model.addAttribute("childes", lostChildService.getAllChild());
        return "index";
    }
}
