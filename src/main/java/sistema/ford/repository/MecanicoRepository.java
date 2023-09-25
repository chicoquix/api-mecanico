package sistema.ford.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.ford.model.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
    Mecanico findByEmail(String s);
}
