package sistema.ford.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistema.ford.ReuniaoDTO.CadastroReuniaoDTO;
import sistema.ford.ReuniaoDTO.DetalhamentoReuniaoDTO;
import sistema.ford.service.ReuniaoService;

@RestController
@RequestMapping("/reuniao")
public class ReuniaoController {

    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping("/marcar")
    public DetalhamentoReuniaoDTO marcarReuniao(@RequestBody CadastroReuniaoDTO dados){
        var dto = reuniaoService.marcarReuniao(dados);
        return dto;
    }

}
