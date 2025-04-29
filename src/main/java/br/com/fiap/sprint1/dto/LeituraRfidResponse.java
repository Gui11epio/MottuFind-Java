package br.com.fiap.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeituraRfidResponse{
    private Long id;
    private LocalDateTime dataHora;
    private Long leitorId;
    private Long tagId;
}
