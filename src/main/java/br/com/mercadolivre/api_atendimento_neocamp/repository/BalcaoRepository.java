package br.com.mercadolivre.api_atendimento_neocamp.repository;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalcaoRepository extends JpaRepository<Balcao, Long> {
    boolean existsByAtendente(Atendente atendente);
}
