package br.com.fiap.MottuFind.dto.response;

import br.com.fiap.MottuFind.model.MotoModelo;
import br.com.fiap.MottuFind.model.MotoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoResponse{
    private String placa;
    private MotoModelo modelo;
    private String marca;
    private MotoStatus status;
    private Long patioId;
    private Long tagId;
}
