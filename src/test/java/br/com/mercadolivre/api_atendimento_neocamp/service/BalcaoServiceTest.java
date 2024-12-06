package br.com.mercadolivre.api_atendimento_neocamp.service;

import br.com.mercadolivre.api_atendimento_neocamp.model.Atendente;
import br.com.mercadolivre.api_atendimento_neocamp.model.Balcao;
import br.com.mercadolivre.api_atendimento_neocamp.repository.AtendenteRepository;
import br.com.mercadolivre.api_atendimento_neocamp.repository.BalcaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BalcaoServiceTest {

    @InjectMocks
    private BalcaoService balcaoService;

    @Mock
    private BalcaoRepository balcaoRepository;

    @Mock
    private AtendenteRepository atendenteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void salvar_deveLancarExcecao_quandoAtendenteNaoInformado() {
        Balcao balcao = new Balcao();
        // Sem atendente

        Exception exception = assertThrows(RuntimeException.class, () -> balcaoService.salvar(balcao));
        assertEquals("Atendente deve ser informado.", exception.getMessage());
    }

    @Test
    void salvar_deveLancarExcecao_quandoAtendenteNaoEncontrado() {
        Balcao balcao = new Balcao();
        Atendente atendente = new Atendente();
        atendente.setId(1L);
        balcao.setAtendente(atendente);

        when(atendenteRepository.findById(atendente.getId())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> balcaoService.salvar(balcao));
        assertEquals("Atendente não encontrado.", exception.getMessage());
    }

    @Test
    void salvar_deveLancarExcecao_quandoAtendenteJaVinculado() {
        Balcao balcao = new Balcao();
        Atendente atendente = new Atendente();
        atendente.setId(1L);
        balcao.setAtendente(atendente);

        when(atendenteRepository.findById(atendente.getId())).thenReturn(Optional.of(atendente));
        when(balcaoRepository.existsByAtendente(atendente)).thenReturn(true);

        Exception exception = assertThrows(RuntimeException.class, () -> balcaoService.salvar(balcao));
        assertEquals("Atendente já está vinculado a um balcão.", exception.getMessage());
    }

    @Test
    void salvar_deveSalvarBalcao_quandoAtendenteValido() {
        Balcao balcao = new Balcao();
        Atendente atendente = new Atendente();
        atendente.setId(1L);
        balcao.setAtendente(atendente);

        when(atendenteRepository.findById(atendente.getId())).thenReturn(Optional.of(atendente));
        when(balcaoRepository.existsByAtendente(atendente)).thenReturn(false);
        when(balcaoRepository.save(balcao)).thenReturn(balcao);

        Balcao resultado = balcaoService.salvar(balcao);

        assertNotNull(resultado);
        assertEquals(atendente, resultado.getAtendente());

        verify(balcaoRepository).save(balcao); // Verifica se o método save foi chamado
    }

    @Test
    void listar_deveRetornarListaDeBalcao() {
        // Exemplo de teste, ajuste de acordo com suas necessidades
        List<Balcao> balcoes = balcaoService.listar();
        assertNotNull(balcoes);
        // Adicione outras verificações conforme necessário
    }
}
