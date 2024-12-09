package com.example.login.controller;

import com.example.login.dto.UserDTO;
import com.example.login.service.UserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // método para requisição da página inicial
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // método para redirecionar para a página de registro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // cria objeto de modelo para armazenar dados do formulário
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }
}
