package br.com.fiap.MottuFind.controller.mvc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class WebLoginController {
    @GetMapping
    public String login() {
        return "login"; // Thymeleaf login.html
    }
}
