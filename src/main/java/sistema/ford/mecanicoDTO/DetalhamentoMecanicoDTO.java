package sistema.ford.mecanicoDTO;

import sistema.ford.model.Mecanico;
import sistema.ford.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhamentoMecanicoDTO(String email, String senha, String nome, String endereco, List<LocalDateTime> horarios) {

    public DetalhamentoMecanicoDTO(Mecanico mecanico) {
        this(mecanico.getEmail(), mecanico.getSenha(), mecanico.getNome(), mecanico.getEndereco(), mecanico.getHorarios());
    }

}
