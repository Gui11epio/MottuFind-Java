package br.com.fiap.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorRfidResponse{
    private String localizacao;
    private String ipDispositivo;
    private Long patioId;
}
