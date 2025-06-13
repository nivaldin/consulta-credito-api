package br.com.nivaldoservices.consulta_credito_api.services.credito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.nivaldoservices.consulta_credito_api.exceptions.ExcecaoPadrao;
import br.com.nivaldoservices.consulta_credito_api.models.Credito;
import br.com.nivaldoservices.consulta_credito_api.repositories.credito.CreditoRepository;

class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarCreditoPorNumeroNfseComSucesso() throws ExcecaoPadrao {
        String numeroNfse = "NF12345";
        Credito credito = new Credito(); // Crie e configure um objeto se necessário
        when(creditoRepository.findByNumeroNfse(numeroNfse)).thenReturn(List.of(credito));

        List<Credito> resultado = creditoService.buscarPorNumeroNfse(numeroNfse);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(creditoRepository, times(1)).findByNumeroNfse(numeroNfse);
    }

    @Test
    void deveLancarExcecaoPadraoQuandoRepositorioFalha() {
        String numeroNfse = "NF12345";
        when(creditoRepository.findByNumeroNfse(numeroNfse))
            .thenThrow(new RuntimeException("Erro no banco"));

        ExcecaoPadrao excecao = assertThrows(ExcecaoPadrao.class, () -> {
            creditoService.buscarPorNumeroNfse(numeroNfse);
        });

        assertTrue(excecao.getMessage().contains("erro inesperado"));
        verify(creditoRepository, times(1)).findByNumeroNfse(numeroNfse);
    }

    @Test
    void deveBuscarCreditoPorNumeroCreditoComSucesso() throws ExcecaoPadrao {
        String numeroCredito = "CR456";
        Credito credito = new Credito();
        when(creditoRepository.findByNumeroCredito(numeroCredito)).thenReturn(List.of(credito));

        List<Credito> resultado = creditoService.buscarPorNumeroCredito(numeroCredito);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(creditoRepository, times(1)).findByNumeroCredito(numeroCredito);
    }
}
