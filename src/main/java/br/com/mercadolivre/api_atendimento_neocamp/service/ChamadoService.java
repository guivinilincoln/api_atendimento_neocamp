package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.model.Chamado;
import br.com.mercadolivre.api_atendimento_neocamp.repository.AtendenteRepository;
import br.com.mercadolivre.api_atendimento_neocamp.repository.ChamadoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRespository chamadoRespository;

    @Autowired
    private AtendenteRepository atendenteRepository;


    public Chamado salvar(Chamado chamado){
        if(chamado.getAtendente().getId() != null){
            Atendente atendente = atendenteRepository.findById(chamado.getAtendente().getId())
                    .orElseThrow(()-> new RuntimeException("Atendente não encontrado"));
            chamado.setAtendente(atendente);
        }
        return chamadoRespository.save(chamado);
    }

    public List<Chamado> listar(){
        return chamadoRespository.findAll();
    }

    public void excluir(Long id){
        chamadoRespository.deleteById(id);
    }
}
