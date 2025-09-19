package br.com.fiap.MottuFind.controller.mvc;

import br.com.fiap.MottuFind.dto.request.MotoRequest;
import br.com.fiap.MottuFind.dto.response.MotoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.MottuFind.service.MotoService;

@Controller
@RequestMapping("/motos")
@AllArgsConstructor
public class WebMotoController {
    private final MotoService motoService;

    @GetMapping
    public String listar(Pageable pageable, Model model) {
        Page<MotoResponse> page = motoService.listar(pageable);

        model.addAttribute("motos", page.getContent());
        model.addAttribute("pageNumber", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());

        return "motos/index";
    }




    // Formulário de cadastro
    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("moto", new MotoRequest());

        return "motos/form";
    }

    // Submeter cadastro
    @PostMapping
    public String criar(@Valid @ModelAttribute("moto") MotoRequest dto) {
        motoService.criar(dto);

        return "redirect:/motos";
    }

    // Formulário de edição
    @GetMapping("/editar/{placa}")
    public String formEditar(@PathVariable String placa, Model model) {
        MotoResponse moto = motoService.buscarPorPlaca(placa);
        model.addAttribute("moto", moto);

        return "motos/form";
    }

    // Submeter edição
    @PostMapping("/{id}")
    public String atualizar(@PathVariable String placa,
                            @Valid @ModelAttribute("moto") MotoRequest dto) {
        motoService.atualizar(placa, dto);

        return "redirect:/motos";
    }

    // Excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable String placa) {
        motoService.deletar(placa);

        return "redirect:/motos";
    }

}
