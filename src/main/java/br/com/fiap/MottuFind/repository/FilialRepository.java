package br.com.fiap.MottuFind.repository;

import br.com.fiap.MottuFind.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {

}
