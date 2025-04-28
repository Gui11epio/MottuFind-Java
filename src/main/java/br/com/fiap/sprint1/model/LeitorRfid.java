package br.com.fiap.sprint1.model;

import br.com.fiap.sprint1.model.Patio;
import jakarta.persistence.*;

import java.util.List;

@Entity
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
