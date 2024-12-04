package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.repository.BalcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalcaoService {

    @Autowired
    private BalcaoRepository balcaoRepository;

    public Balcao salvar(Balcao balcao){
        return balcaoRepository.save(balcao);
    }

    public List<Balcao> listar(){
        return balcaoRepository.findAll();
    }
}
