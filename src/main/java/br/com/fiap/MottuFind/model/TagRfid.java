package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoIdentificacao; // exemplo: "TAG-MOTO-0001"
    private boolean ativa;

    @OneToOne(mappedBy = "tag")
    private Moto moto;


}
