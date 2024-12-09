package com.example.login.controller;

import com.example.login.dto.UserDTO;
import com.example.login.entity.User;
import com.example.login.service.UserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDTO,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDTO.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "Já existe uma conta cadastrada com esse email.");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "/register";
        }

        userService.saveUser(userDTO);
        return "redirect:/register?success";
    }
}
