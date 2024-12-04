package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Chamado;
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

    public Chamado salvar(Chamado chamado){
        return chamadoRespository.save(chamado);
    }

    public List<Chamado> listar(){
        return chamadoRespository.findAll();
    }

    public Optional<Chamado> atualizar(Long id, Chamado atualizado) {
        return chamadoRespository.findById(id).map(chamado -> {
            chamado.setDescricao(atualizado.getDescricao());
            chamado.setStatus(atualizado.getStatus());
            return chamadoRespository.save(chamado);
        });
    }

    public void excluir(Long id){
        chamadoRespository.deleteById(id);
    }
}
