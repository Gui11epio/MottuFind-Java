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


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
