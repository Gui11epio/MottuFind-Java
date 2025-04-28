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

    public LeitorRfid() {
    }

    public LeitorRfid(Long id, String localizacao, String ipDispositivo, Patio patio, List<LeituraRfid> leituras) {
        this.id = id;
        this.localizacao = localizacao;
        this.ipDispositivo = ipDispositivo;
        this.patio = patio;
        this.leituras = leituras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getIpDispositivo() {
        return ipDispositivo;
    }

    public void setIpDispositivo(String ipDispositivo) {
        this.ipDispositivo = ipDispositivo;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public List<LeituraRfid> getLeituras() {
        return leituras;
    }

    public void setLeituras(List<LeituraRfid> leituras) {
        this.leituras = leituras;
    }
}
