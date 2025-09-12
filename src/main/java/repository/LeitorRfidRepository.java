package repository;

import model.LeitorRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRfidRepository extends JpaRepository<LeitorRfid, Long> {
}
