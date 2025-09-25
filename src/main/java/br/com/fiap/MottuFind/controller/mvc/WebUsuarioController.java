package br.com.fiap.MottuFind.controller.mvc;

import br.com.fiap.MottuFind.model.Usuario;
import br.com.fiap.MottuFind.service.UsuarioService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class WebUsuarioController {
    private final UsuarioService usuarioService;

    // ✅ Apenas ADMIN pode acessar o cadastro de novos usuários
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/novo")
    public String novoUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    // ✅ Salvar no banco
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.criarUsuarioComRoleUser(usuario);
        return "redirect:/usuarios/lista";
    }

    // Lista de usuários (somente ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }
}
