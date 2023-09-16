package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.service.LostChildService;
import com.example.lostfiendchild.viewModels.LostChildVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LostChildController {

    @Autowired
    LostChildService lostChildService;

    @GetMapping(value = "/lost")
    String lostChild(){
        lostChildService.saveLostChiuld();
        return "lostChild";
    }
    @PostMapping(value = "/addLostChild")
    String addLostChild(LostChildVM lostChild, Model model){
        lostChildService.saveLostChiuld(lostChild);
        model.addAttribute("childes", lostChildService.getAllChild());
        return "index";
    }
}
