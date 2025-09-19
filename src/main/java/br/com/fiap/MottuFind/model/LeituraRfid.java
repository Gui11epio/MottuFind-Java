package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
