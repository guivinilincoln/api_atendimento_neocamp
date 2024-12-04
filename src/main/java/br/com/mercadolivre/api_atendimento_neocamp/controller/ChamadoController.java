package br.com.mercadolivre.api_atendimento_neocamp.controller;

import br.com.mercadolivre.api_atendimento_neocamp.model.Chamado;
import br.com.mercadolivre.api_atendimento_neocamp.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public Chamado criar(@RequestBody Chamado chamado){
        return chamadoService.salvar(chamado);
    }

    @GetMapping
    public List<Chamado> listar(){
        return chamadoService.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> atualizar(@PathVariable Long id, @RequestBody Chamado chamado) {
        return chamadoService.atualizar(id, chamado)
                .map(updatedChamado -> ResponseEntity.ok(updatedChamado))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 se não encontrar o chamado
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        chamadoService.excluir(id);
    }
}
