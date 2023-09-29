package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.service.LostChildService;
import com.example.lostfiendchild.service.UserService;
import com.example.lostfiendchild.viewModels.LostChildVM;
import com.example.lostfiendchild.viewModels.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    LostChildService lostChildService;
    @Autowired
    UserService userService;
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

    @PostMapping(value = "/doLogin")
    String doLogin(UserVM userVM, Model model)
    {
       var userList = userService.getUserByEmailAndPassword(userVM);
       if(userList.size()>0){
           model.addAttribute("childes", lostChildService.getAllChild());
           return "index";
       } else {
           return "login";
       }
    }
}
