package sistema.ford.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.ford.mecanicoDTO.MecanicoAutenticacaoDTO;
import sistema.ford.model.Mecanico;
import sistema.ford.model.Usuario;
import sistema.ford.repository.MecanicoRepository;
import sistema.ford.repository.UsuarioRepository;
import sistema.ford.usuarioDTO.UsuarioAutenticacaoDTO;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public Usuario verificaUsuarioExistente(UsuarioAutenticacaoDTO dados){
        List<Usuario> usuarioList = usuarioRepository.findAll();
        for(Usuario usuario : usuarioList){
            //String nome = usuario.getNome();
            //String email = usuario.getEmail();
            //String senha = usuario.getSenha();
            if(usuario.getEmail().equals(dados.email()) && usuario.getSenha().equals(dados.senha())){
                return usuario;
            }
        }
        return null;
    }

    public Mecanico verificaMecanicoExistente(MecanicoAutenticacaoDTO dados) {
        List<Mecanico> mecanicoList = mecanicoRepository.findAll();
        for(Mecanico mecanico : mecanicoList){
            //String email = mecanico.getEmail();
            //String senha = mecanico.getSenha();
            if(mecanico.getEmail().equals(dados.email()) && mecanico.getSenha().equals(dados.senha())){
                return mecanico;
            }
        }
        return null;
    }
}
