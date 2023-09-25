package sistema.ford.usuarioDTO;

import sistema.ford.model.Usuario;

public record DetalhamentoUsuarioDTO(String email, String senha, String nome) {

    public DetalhamentoUsuarioDTO(Usuario usuario) {
        this(usuario.getEmail(), usuario.getSenha(), usuario.getNome());
    }

}
