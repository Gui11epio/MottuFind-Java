package br.com.fiap.MottuFind.repository;



import br.com.fiap.MottuFind.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNome(String nome);
}
