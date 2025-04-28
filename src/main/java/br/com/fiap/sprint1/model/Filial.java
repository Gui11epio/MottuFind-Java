package br.com.fiap.sprint1.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String pais;

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    private List<Patio> patios;

    public Filial() {
    }

    public Filial(Long id, String nome, String cidade, String pais, List<Patio> patios) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
        this.patios = patios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Patio> getPatios() {
        return patios;
    }

    public void setPatios(List<Patio> patios) {
        this.patios = patios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
