package sistema.ford.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sistema.ford.service.UsuarioService;
import sistema.ford.usuarioDTO.CadastroUsuarioDTO;
import sistema.ford.usuarioDTO.DetalhamentoUsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(value = "/cadastrar")
    public DetalhamentoUsuarioDTO cadastrar(@RequestBody CadastroUsuarioDTO dados){
        var dto = service.adicionarUsuario(dados);
        return dto;
    }

    @PostMapping("/atualizar/{id}")
    public DetalhamentoUsuarioDTO atualizar(@PathVariable("id") Long id, @RequestBody DetalhamentoUsuarioDTO dados) {
        var dto = service.atualizarUsuario(id, dados);
        return dto;
    }

    @DeleteMapping("/excluir/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.removerUsuario(id);
    }

}
