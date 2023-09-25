package sistema.ford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.ford.model.Usuario;
import sistema.ford.repository.UsuarioRepository;
import sistema.ford.usuarioDTO.CadastroUsuarioDTO;
import sistema.ford.usuarioDTO.DetalhamentoUsuarioDTO;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public DetalhamentoUsuarioDTO adicionarUsuario(CadastroUsuarioDTO dados) {
        Exception exception = null;
        if(dados != null) {
            try {
                Usuario usuario = new Usuario(dados.email(), dados.senha(), dados.nome());
                usuarioRepository.save(usuario);
                return new DetalhamentoUsuarioDTO(usuario);
            } catch (Exception e) {
                exception = e;
            }
        }
        throw new RuntimeException("Erro ao salvar Usuário", exception);
    }

    public DetalhamentoUsuarioDTO atualizarUsuario(Long id, DetalhamentoUsuarioDTO dados) {
        Exception exception = null;
        if (dados != null) {
            try {
                Usuario usuario = usuarioRepository.getReferenceById(id);
                usuario.setEmail(dados.email());
                usuario.setSenha(dados.senha());
                usuario.setNome(dados.nome());
                Usuario usuarioEditado = usuario;
                usuarioRepository.save(usuarioEditado);
                return new DetalhamentoUsuarioDTO(usuarioEditado);
            } catch (Exception e) {
                exception = e;
            }
        }
        throw new RuntimeException("Erro ao atualizar Usuário", exception);
    }

    public void removerUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao excluir Usuário", e);
        }
    }


}
