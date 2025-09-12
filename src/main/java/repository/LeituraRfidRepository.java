package repository;

import model.LeituraRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraRfidRepository extends JpaRepository<LeituraRfid, Long> {
}
