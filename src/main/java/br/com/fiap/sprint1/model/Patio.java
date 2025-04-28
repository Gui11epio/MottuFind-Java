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

    public Patio() {
    }

    public Patio(Long id, String nome, Double largura, Double comprimento, Filial filial, List<LeitorRfid> leitores, List<Moto> motos) {
        this.id = id;
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
        this.filial = filial;
        this.leitores = leitores;
        this.motos = motos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public List<LeitorRfid> getLeitores() {
        return leitores;
    }

    public void setLeitores(List<LeitorRfid> leitores) {
        this.leitores = leitores;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
