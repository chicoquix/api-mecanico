package sistema.ford.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistema.ford.mecanicoDTO.MecanicoAutenticacaoDTO;
import sistema.ford.model.Mecanico;
import sistema.ford.model.Usuario;
import sistema.ford.service.LoginService;
import sistema.ford.usuarioDTO.UsuarioAutenticacaoDTO;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/verificaLoginUsuario")
    public Usuario verificaLoginUsuario(@RequestBody UsuarioAutenticacaoDTO dados){
        return loginService.verificaUsuarioExistente(dados);
    }

    @PostMapping("/verificaLoginMecanico")
    public Mecanico verificaLoginMecanico(@RequestBody MecanicoAutenticacaoDTO dados){
        return loginService.verificaMecanicoExistente(dados);
    }

}
