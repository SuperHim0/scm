package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class pageController {
    
    // home page
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Himanshu kuamr");
        model.addAttribute("college", "UIET_MDU");
        model.addAttribute("link", "www.google.com");
        System.out.println("inside the controller at home function");
        return "home";
    }
    // about page : -
    @GetMapping("/about")
    public String aboutPage() {
        System.out.println("inside the about page");
        return "about";
    }
    
    // service page : - 
    @GetMapping("/services")
    public String servicePage() {
        return "services";
    }
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @GetMapping("/signup")
    public String signupePage() {
        return "signup";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/do-register")
    public String registerForm() {
        System.out.println("register done");


        return "redirect:/login";
    }
    

}
