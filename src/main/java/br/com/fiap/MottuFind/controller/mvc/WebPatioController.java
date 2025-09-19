package br.com.fiap.MottuFind.controller.mvc;

import br.com.fiap.MottuFind.dto.request.PatioRequest;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import br.com.fiap.MottuFind.dto.response.PatioResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.MottuFind.service.PatioService;

@Controller
@RequestMapping("/patios")
@AllArgsConstructor
public class WebPatioController {
    private final PatioService patioService;

    @GetMapping
    public String listar(Model model, Pageable pageable) {
        Page<PatioResponse> page = patioService.listar(pageable);

        model.addAttribute("patios", page.getContent());
        model.addAttribute("pageNumber", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());

        return "patios/index";
    }



    @GetMapping("/novo")
    public String formNovo(Model model){
        model.addAttribute("patio", new PatioRequest());

        return "patios/form";
    }

    @PostMapping("/criar")
    public String criar(@Valid @ModelAttribute("patio") PatioRequest patioRequest) {
        patioService.criar(patioRequest);

        return "redirect:/patios";
    }

    // Formulário de edição
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        PatioResponse patio = patioService.buscarPorId(id);
        model.addAttribute("patio", patio);

        return "patios/form";
    }

    // Submeter edição
    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("patio") PatioRequest dto) {
        patioService.atualizar(id, dto);

        return "redirect:/patios";
    }

    // Excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        patioService.deletar(id);

        return "redirect:/patios";
    }




}
