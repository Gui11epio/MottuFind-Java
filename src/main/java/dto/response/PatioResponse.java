package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatioResponse{
    String nome;
    Double largura;
    Double comprimento;
    Long filialId;
}
