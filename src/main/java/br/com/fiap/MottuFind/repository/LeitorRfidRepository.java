package br.com.fiap.MottuFind.repository;

import br.com.fiap.MottuFind.model.LeitorRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRfidRepository extends JpaRepository<LeitorRfid, Long> {
}
