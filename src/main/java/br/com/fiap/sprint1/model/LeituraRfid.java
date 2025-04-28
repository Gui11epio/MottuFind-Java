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
}
