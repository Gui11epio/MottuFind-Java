package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Role roles;
}