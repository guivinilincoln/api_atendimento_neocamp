package br.com.mercadolivre.api_atendimento_neocamp.controller;

import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.service.BalcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balcoes")
public class BalcaoController {
    @Autowired
    private BalcaoService balcaoService;

    @PostMapping
    public Balcao criar(@RequestBody Balcao balcao) {
        return balcaoService.salvar(balcao);
    }

    @GetMapping
    public List<Balcao> listar() {
        return balcaoService.listar();
    }
}
