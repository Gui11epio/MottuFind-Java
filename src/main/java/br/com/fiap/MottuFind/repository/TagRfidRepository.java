package br.com.fiap.MottuFind.repository;

import br.com.fiap.MottuFind.model.TagRfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRfidRepository extends JpaRepository<TagRfid, Long> {
}
