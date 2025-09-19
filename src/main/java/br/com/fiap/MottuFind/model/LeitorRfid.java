package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeitorRfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao; // Exemplo: "Entrada principal", "Área B"
    private String ipDispositivo; // IP do leitor IoT

    @ManyToOne
    private Patio patio;

    @OneToMany(mappedBy = "leitor", cascade = CascadeType.ALL)
    private List<LeituraRfid> leituras;


}
