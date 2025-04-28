package br.com.fiap.sprint1.model;

import br.com.fiap.sprint1.model.Moto;
import jakarta.persistence.*;

@Entity
public class TagRfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoIdentificacao; // exemplo: "TAG-MOTO-0001"
    private boolean ativa;

    @OneToOne(mappedBy = "tag")
    private Moto moto;

    public TagRfid() {
    }

    public TagRfid(Long id, String codigoIdentificacao, boolean ativa, Moto moto) {
        this.id = id;
        this.codigoIdentificacao = codigoIdentificacao;
        this.ativa = ativa;
        this.moto = moto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(String codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}
