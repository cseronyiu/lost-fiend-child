package com.example.lostfiendchild.controller;

import com.example.lostfiendchild.entity.LostChildEntity;
import com.example.lostfiendchild.service.LostChildService;
import com.example.lostfiendchild.service.UserService;
import com.example.lostfiendchild.viewModels.LostChildVM;
import com.example.lostfiendchild.viewModels.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    LostChildService lostChildService;
    @Autowired
    UserService userService;
    @GetMapping(value = "/")
    String index(Model model)
    {
        List<LostChildVM> lostChildVMList = new ArrayList<>();

        for (LostChildEntity lostChildEntity: lostChildService.getAllChild()) {
            LostChildVM lostChildVM = new LostChildVM();
            lostChildVM.setName(lostChildEntity.getName());
            lostChildVM.setAge(lostChildEntity.getAge());
            lostChildVM.setHeight(lostChildEntity.getHeight());
            lostChildVM.setWeight(lostChildEntity.getWeight());
            lostChildVM.setFather_name(lostChildEntity.getFather_name());
            lostChildVM.setMother_name(lostChildEntity.getMother_name());
            lostChildVM.setAddress(lostChildEntity.getAddress());
            lostChildVM.setPhn_num(lostChildEntity.getPhn_num());
            if(lostChildEntity.getImageFileName() != null){
                lostChildVM.setImageFileNamePath(MvcUriComponentsBuilder
                        .fromMethodName(HomeController.class, "getImage", lostChildEntity.getImageFileName()).build().toString());
            }
            lostChildVMList.add(lostChildVM);
        }
        model.addAttribute("childes", lostChildVMList);
        return "index";
    }

    @GetMapping(value = "/signup")
    String signup(Model model)
    {
//        model.addAttribute("childes", lostChildService.getAllChild());
        return "signup";
    }

    @PostMapping(value = "/saveSignupData")
    String saveSignupData(UserVM userVM,Model model)
    {
        var user = userService.saveUser(userVM);
        if(user != null){
            return "login";
        } else {
            return "signup";
        }
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
    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = lostChildService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
