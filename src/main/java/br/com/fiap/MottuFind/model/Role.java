package br.com.fiap.MottuFind.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // ex: "ROLE_ADMIN", "ROLE_USER"
}
