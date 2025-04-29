package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.model.LeituraRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraRfidRepository extends JpaRepository<LeituraRfid, Long> {
}
