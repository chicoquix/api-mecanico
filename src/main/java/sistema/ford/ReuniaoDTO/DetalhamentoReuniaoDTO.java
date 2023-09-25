package sistema.ford.ReuniaoDTO;

import sistema.ford.model.Mecanico;
import sistema.ford.model.Reuniao;
import sistema.ford.model.Usuario;

import java.time.LocalDateTime;

public record DetalhamentoReuniaoDTO(Usuario usuario, Mecanico mecanico, LocalDateTime horario) {
    public DetalhamentoReuniaoDTO(Reuniao reuniao) {
        this(reuniao.getUsuario(), reuniao.getMecanico(), reuniao.getHorario());
    }
}
