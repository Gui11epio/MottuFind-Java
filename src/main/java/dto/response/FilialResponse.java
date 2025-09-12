package dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialResponse{
    private Long id;
    private String nome;
    private String cidade;
    private String pais;
}
