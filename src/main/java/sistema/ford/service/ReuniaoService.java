package sistema.ford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.ford.ReuniaoDTO.CadastroReuniaoDTO;
import sistema.ford.ReuniaoDTO.DetalhamentoReuniaoDTO;
import sistema.ford.model.Mecanico;
import sistema.ford.model.Reuniao;
import sistema.ford.model.Usuario;
import sistema.ford.repository.MecanicoRepository;
import sistema.ford.repository.ReuniaoRepository;
import sistema.ford.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReuniaoService {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DetalhamentoReuniaoDTO marcarReuniao(CadastroReuniaoDTO dados) {
        Mecanico mecanico = mecanicoRepository.findByEmail(dados.emailMecanico());
        if(mecanico  == null){
            throw new RuntimeException("Email inválido, mecânico não existe");
        }
        Usuario usuario = usuarioRepository.findByEmail(dados.emailUsuario());
        if(usuario == null){
            throw new RuntimeException("Email inválido, usuário não existe");
        }
        List<LocalDateTime> listaHorarios = mecanico.getHorarios();
        for(LocalDateTime horario : listaHorarios){
            if(dados.horario().equals(horario)){
                Reuniao reuniao = new Reuniao(usuario, mecanico, dados.horario());
                mecanico.getHorarios().remove(dados.horario());
                mecanicoRepository.save(mecanico);
                reuniaoRepository.save(reuniao);
                return new DetalhamentoReuniaoDTO(reuniao);
            }
        }
       throw new RuntimeException("Horário não disponível");
    }

}
