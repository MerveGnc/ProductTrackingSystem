package com.rora.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rora.model.User;
import com.rora.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginForm() {
        return "login"; 
    }
    
    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/home"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; 
        }
    }
    
    @GetMapping("/admin-login")
    public String showAdminLoginForm() {
        return "admin-login.html"; 
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
    

}