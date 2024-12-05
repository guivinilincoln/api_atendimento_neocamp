package br.com.mercadolivre.api_atendimento_neocamp.controller;

import br.com.mercadolivre.api_atendimento_neocamp.model.ApiResponse;
import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.service.BalcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balcoes")
public class BalcaoController {

    @Autowired
    private BalcaoService balcaoService;

    @PostMapping
    public ResponseEntity<ApiResponse> criar(@RequestBody Balcao balcao){
        Balcao novoBalcao = balcaoService.salvar(balcao);
        ApiResponse response = new ApiResponse("Balcão criado com sucesso: " + novoBalcao.getNome(), true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public List<Balcao> listar() {
        return balcaoService.listar();
    }
}
