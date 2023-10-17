package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.service.LostChildService;
import com.example.lostfiendchild.viewModels.LostChildVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class LostChildController {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    private String userDirectory = "/static/img/";
    @Autowired
    LostChildService lostChildService;

    @GetMapping(value = "/lost")
    String lostChild() {
//        lostChildService.saveLostChiuld();
        return "lostChild";
    }

    @PostMapping(value = "/addLostChild")
    String addLostChild(LostChildVM lostChild, Model model, @RequestParam("image") MultipartFile file) {
        try {
            lostChildService.saveLostChiuld(lostChild, file);
            model.addAttribute("childes", lostChildService.getAllChild());
        } catch (Exception ex) {

        }
        return "index";

    }


}
