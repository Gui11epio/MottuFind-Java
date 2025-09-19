package br.com.fiap.MottuFind.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRfidResponse{
    Long id;
    String codigoIdentificacao;
    boolean ativa;
}
