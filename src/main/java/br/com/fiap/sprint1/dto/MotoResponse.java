package br.com.fiap.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoResponse{
    private String placa;
    private String modelo;
    private String status;
    private Long patioId;
    private Long tagId;
}
