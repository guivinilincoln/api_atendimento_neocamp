package br.com.mercadolivre.api_atendimento_neocamp.repository;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChamadoRespository extends JpaRepository<Chamado, Long> {
    @Modifying
    @Query("DELETE FROM Chamado c WHERE c.atendente = :atendente")
    void deleteByAtendente(Atendente atendente);
}
