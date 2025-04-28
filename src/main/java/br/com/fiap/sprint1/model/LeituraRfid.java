package br.com.fiap.sprint1.model;

import br.com.fiap.sprint1.model.LeitorRfid;
import br.com.fiap.sprint1.model.TagRfid;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LeituraRfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora; // Momento da leitura

    @ManyToOne
    private LeitorRfid leitor;

    @ManyToOne
    private TagRfid tag;

    public LeituraRfid() {
    }

    public LeituraRfid(Long id, LocalDateTime dataHora, LeitorRfid leitor, TagRfid tag) {
        this.id = id;
        this.dataHora = dataHora;
        this.leitor = leitor;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LeitorRfid getLeitor() {
        return leitor;
    }

    public void setLeitor(LeitorRfid leitor) {
        this.leitor = leitor;
    }

    public TagRfid getTag() {
        return tag;
    }

    public void setTag(TagRfid tag) {
        this.tag = tag;
    }
}
