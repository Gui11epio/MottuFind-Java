package br.com.fiap.sprint1.model;

import jakarta.persistence.*;

@Entity
public class Moto {
    @Id
    private String placa; // um exemplo: ABC-1234

    private String modelo;
    private String marca;
    private String cor;
    private String status;

    @ManyToOne
    private Patio patio;

    @OneToOne(cascade = CascadeType.ALL)
    private TagRfid tag;



    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}
