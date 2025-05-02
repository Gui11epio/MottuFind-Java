package br.com.fiap.sprint1.model;

import jakarta.persistence.*;

@Entity
public class Moto {
    @Id
    private String placa; // um exemplo: ABC-1234

    private MotoModelo modelo;
    private String marca;

    @Enumerated(EnumType.STRING)
    private MotoStatus status;

    @ManyToOne
    private Patio patio;

    @OneToOne(cascade = CascadeType.ALL)
    private TagRfid tag;

    public Moto() {
    }

    public Moto(String placa, MotoModelo modelo, String marca, MotoStatus status, Patio patio, TagRfid tag) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.status = status;
        this.patio = patio;
        this.tag = tag;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public MotoModelo getModelo() {
        return modelo;
    }

    public void setModelo(MotoModelo modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public MotoStatus getStatus() {
        return status;
    }

    public void setStatus(MotoStatus status) {
        this.status = status;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public TagRfid getTag() {
        return tag;
    }

    public void setTag(TagRfid tag) {
        this.tag = tag;
    }
}
