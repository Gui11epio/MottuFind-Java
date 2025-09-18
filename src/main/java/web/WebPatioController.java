package web;

import dto.request.FilialRequest;
import dto.request.PatioRequest;
import dto.response.FilialResponse;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import dto.response.PatioResponse;
import lombok.AllArgsConstructor;
import model.Patio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PatioService;

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

        return "redirect:/web/patios";
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

        return "redirect:/web/patios";
    }

    // Excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        patioService.deletar(id);

        return "redirect:/web/patios";
    }




}
