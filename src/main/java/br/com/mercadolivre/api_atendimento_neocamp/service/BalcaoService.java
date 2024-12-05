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
        if(balcao.getAtendente() == null || balcao.getAtendente().getId() == null){
            throw new RuntimeException("Atendente deve ser informado.");
        }
        Atendente atendente = atendenteRepository.findById(balcao.getAtendente().getId())
                .orElseThrow(() -> new RuntimeException("Atendente não encontrado."));

        if (balcaoRepository.existsByAtendente(atendente)) {
            throw new RuntimeException("Atendente já está vinculado a um balcão.");
        }

        balcao.setAtendente(atendente); // Vincula o atendente ao balcão
        return balcaoRepository.save(balcao);
    }

    public List<Balcao> listar(){
        return balcaoRepository.findAll();
    }
}
