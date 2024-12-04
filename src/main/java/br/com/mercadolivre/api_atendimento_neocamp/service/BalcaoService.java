package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.repository.AtendenteRepository;
import br.com.mercadolivre.api_atendimento_neocamp.repository.BalcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalcaoService {

    @Autowired
    private BalcaoRepository balcaoRepository;

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Balcao salvar(Balcao balcao){
        if (balcao.getAtendente() != null && balcao.getAtendente().getId() != null) {
            Atendente atendente = atendenteRepository.findById(balcao.getAtendente().getId())
                    .orElseThrow(() -> new RuntimeException("Atendente não encontrado"));
            balcao.setAtendente(atendente); // Configura o atendente encontrado
        } else {
            throw new RuntimeException("Atendente deve ser informado.");
        }
        return balcaoRepository.save(balcao); // Salva o balcao
    }

    public List<Balcao> listar(){
        return balcaoRepository.findAll();
    }
}
