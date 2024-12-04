package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.repository.AtendenteRepository;
import br.com.mercadolivre.api_atendimento_neocamp.repository.ChamadoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtendenteService {

    @Autowired
    private ChamadoRespository chamadoRespository;

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Atendente salvar(Atendente atendente){
        return atendenteRepository.save(atendente);
    }

    public List<Atendente> listar(){
        return atendenteRepository.findAll();
    }

    @Transactional
    public void deletarAtendente(Long id) {
        // Busca o atendente
        Atendente atendente = atendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atendente não encontrado"));

        // Exclui os chamados relacionados
        chamadoRespository.deleteByAtendente(atendente);

        // Finalmente, exclui o atendente
        atendenteRepository.delete(atendente);
    }

}
