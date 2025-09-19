package br.com.fiap.MottuFind.repository;

import br.com.fiap.MottuFind.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}
