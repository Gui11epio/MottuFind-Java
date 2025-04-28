package br.com.fiap.sprint1.model;

import br.com.fiap.sprint1.model.Moto;
import jakarta.persistence.*;

@Entity
public class TagRfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoIdentificacao; // exemplo: "TAG-MOTO-0001"
    private boolean ativa;

    @OneToOne(mappedBy = "tag")
    private Moto moto;
}
