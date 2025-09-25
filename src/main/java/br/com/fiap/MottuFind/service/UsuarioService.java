package br.com.fiap.MottuFind.service;

import br.com.fiap.MottuFind.model.Role;
import br.com.fiap.MottuFind.model.Usuario;
import br.com.fiap.MottuFind.repository.RoleRepository;
import br.com.fiap.MottuFind.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario criarUsuarioComRoleUser(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Define role padrão USER (ou outra lógica)
        Role roleUser = roleRepository.findByNome("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        usuario.setRoles(roles);

        return usuarioRepository.save(usuario);
    }

    public Usuario criarUsuarioAdmin(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Role roleAdmin = roleRepository.findByNome("ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        usuario.setRoles(roles);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

}
