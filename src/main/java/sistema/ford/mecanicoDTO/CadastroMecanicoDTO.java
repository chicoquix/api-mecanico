package sistema.ford.mecanicoDTO;

import java.time.LocalDateTime;
import java.util.List;

public record CadastroMecanicoDTO(String email, String senha, String nome, String endereco, List<LocalDateTime> horarios) {
}
