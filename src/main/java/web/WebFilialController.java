package web;

import dto.request.FilialRequest;
import dto.response.FilialResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.FilialService;

@Controller
@RequestMapping("/filiais")
@AllArgsConstructor
public class WebFilialController {
    private final FilialService filialService;


    @GetMapping
    public String listar(Pageable pageable, Model model) {
        Page<FilialResponse> page = filialService.listar(pageable);

        model.addAttribute("filiais", page.getContent());
        model.addAttribute("pageNumber", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());

        return "filiais/index";
    }


    @GetMapping("/{id}")
    public String listarPorId(@PathVariable Long id, Model model) {
        FilialResponse filial = filialService.buscarPorId(id);
        model.addAttribute("filial", filial);

        return "filiais/detail";
    }

    // Formulário de cadastro
    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("filial", new FilialRequest());

        return "filiais/form";
    }

    // Submeter cadastro
    @PostMapping
    public String criar(@Valid @ModelAttribute("filial") FilialRequest dto) {
        filialService.criar(dto);

        return "redirect:/filiais";
    }

    // Formulário de edição
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        FilialResponse filial = filialService.buscarPorId(id);
        // converta se precisar para FilialRequest
        model.addAttribute("filial", filial);

        return "filiais/form";
    }

    // Submeter edição
    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("filial") FilialRequest dto) {
        filialService.atualizar(id, dto);

        return "redirect:/filiais";
    }

    // Excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        filialService.deletar(id);

        return "redirect:/filiais";
    }


}
