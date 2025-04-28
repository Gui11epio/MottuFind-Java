package br.com.fiap.sprint1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double largura;
    private Double comprimento;

    @ManyToOne
    private Filial filial;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<LeitorRfid> leitores;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Moto> motos;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
