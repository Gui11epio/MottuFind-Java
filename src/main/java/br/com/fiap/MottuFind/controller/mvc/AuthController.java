package br.com.fiap.MottuFind.controller.mvc;

import br.com.fiap.MottuFind.model.Role;
import br.com.fiap.MottuFind.model.Usuario;
import br.com.fiap.MottuFind.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario,
                            RedirectAttributes redirectAttributes) {

        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            redirectAttributes.addFlashAttribute("erro", "Username já cadastrado!");
            return "redirect:/cadastro";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole(Role.ROLE_USER); // Padrão: usuário comum

        usuarioRepository.save(usuario);

        redirectAttributes.addFlashAttribute("sucesso", "Cadastro realizado com sucesso!");
        return "redirect:/login";
    }

    @GetMapping("/acesso-negado")
    public String acessoNegado() {
        return "acesso-negado";
    }
}