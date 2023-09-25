package sistema.ford.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.ford.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String s);
}
