package br.com.fiap.MottuFind.repository;

import br.com.fiap.MottuFind.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, String> {
}
