package br.com.mercadolivre.api_atendimento_neocamp.repository;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
