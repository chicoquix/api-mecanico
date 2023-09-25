package sistema.ford.ReuniaoDTO;


import java.time.LocalDateTime;

public record CadastroReuniaoDTO(String emailUsuario, String emailMecanico, LocalDateTime horario) {
}
