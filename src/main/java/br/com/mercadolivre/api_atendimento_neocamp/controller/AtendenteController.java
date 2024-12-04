package br.com.mercadolivre.api_atendimento_neocamp.controller;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @PostMapping
    public Atendente criar(@RequestBody Atendente atendente){
        return atendenteService.salvar(atendente);
    }

    @GetMapping
    public List<Atendente> listar(){
        return atendenteService.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtendente(@PathVariable Long id){
        atendenteService.deletarAtendente(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
