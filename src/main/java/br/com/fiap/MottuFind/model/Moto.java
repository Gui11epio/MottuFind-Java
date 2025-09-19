package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto {
    @Id
    private String placa;

    private MotoModelo modelo;
    private String marca;

    @Enumerated(EnumType.STRING)
    private MotoStatus status;

    @ManyToOne
    private Patio patio;

    @OneToOne(cascade = CascadeType.ALL)
    private TagRfid tag;


}
