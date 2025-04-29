package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.model.TagRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRfidRepository extends JpaRepository<TagRfid, Long> {
}
