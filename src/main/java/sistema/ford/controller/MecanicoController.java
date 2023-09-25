package sistema.ford.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sistema.ford.mecanicoDTO.CadastroMecanicoDTO;
import sistema.ford.mecanicoDTO.DetalhamentoMecanicoDTO;
import sistema.ford.service.MecanicoService;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    @Autowired
    private MecanicoService service;

    @PostMapping("/cadastrar")
    public DetalhamentoMecanicoDTO cadastrar(@RequestBody CadastroMecanicoDTO dados){
        var dto = service.adicionarMecanico(dados);
        return dto;
    }

    @PostMapping("/atualizar/{id}")
    public DetalhamentoMecanicoDTO atualizar(@PathVariable("id") Long id, @RequestBody DetalhamentoMecanicoDTO dados) {
        var dto = service.atualizarMecanico(id, dados);
        return dto;
    }

    @DeleteMapping("/excluir/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.removerUsuario(id);
    }

}
