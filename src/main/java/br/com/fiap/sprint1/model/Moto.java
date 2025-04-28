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

    public Moto() {
    }

    public Moto(String placa, String modelo, String marca, String cor, String status, Patio patio, TagRfid tag) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.status = status;
        this.patio = patio;
        this.tag = tag;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}
