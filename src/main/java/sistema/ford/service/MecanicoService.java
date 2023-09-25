package sistema.ford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.ford.mecanicoDTO.CadastroMecanicoDTO;
import sistema.ford.mecanicoDTO.DetalhamentoMecanicoDTO;
import sistema.ford.model.Mecanico;
import sistema.ford.model.Usuario;
import sistema.ford.repository.MecanicoRepository;
import sistema.ford.usuarioDTO.DetalhamentoUsuarioDTO;


@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;


    public DetalhamentoMecanicoDTO adicionarMecanico(CadastroMecanicoDTO dados) {
        Exception exception = null;
        if(dados != null) {
            try {
               Mecanico mecanico = new Mecanico(dados.email(), dados.senha(), dados.nome(), dados.endereco(), dados.horarios());
                mecanicoRepository.save(mecanico);
                return new DetalhamentoMecanicoDTO(mecanico);
            } catch (Exception e) {
                exception = e;
            }
        }
        throw new RuntimeException("Erro ao salvar Mecânico", exception);
    }

    public DetalhamentoMecanicoDTO atualizarMecanico(Long id, DetalhamentoMecanicoDTO dados) {
        Exception exception = null;
        if (dados != null) {
            try {
                Mecanico mecanico = mecanicoRepository.getReferenceById(id);
                mecanico.setEmail(dados.email());
                mecanico.setSenha(dados.senha());
                mecanico.setNome(dados.nome());
                mecanico.setEndereco(dados.endereco());
                mecanico.setHorarios(dados.horarios());
                Mecanico mecanicoEditado = mecanico;
               mecanicoRepository.save(mecanicoEditado);
                return new DetalhamentoMecanicoDTO(mecanicoEditado);
            } catch (Exception e) {
                exception = e;
            }
        }
        throw new RuntimeException("Erro ao atualizar Usuário", exception);
    }

    public void removerUsuario(Long id) {
        try {
            mecanicoRepository.deleteById(id);

        }
        catch (Exception e){
            throw new RuntimeException("Erro ao excluir Mecânico", e);
        }
    }
}
