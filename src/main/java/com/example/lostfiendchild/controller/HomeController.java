package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.service.LostChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping(value = "/signup")
    String signup(Model model)
    {
//        model.addAttribute("childes", lostChildService.getAllChild());
        return "signup";
    }

    @PostMapping(value = "/saveSignupData")
    String saveSignupData(Model model)
    {
//        model.addAttribute("childes", lostChildService.getAllChild());
        return "signup";
    }
    @GetMapping(value = "/login")
    String login(Model model)
    {
//        model.addAttribute("childes", lostChildService.getAllChild());
        return "login";
    }


}
