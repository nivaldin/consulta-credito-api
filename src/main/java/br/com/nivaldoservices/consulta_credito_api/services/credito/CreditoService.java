package br.com.nivaldoservices.consulta_credito_api.services.credito;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nivaldoservices.consulta_credito_api.exceptions.ExcecaoPadrao;
import br.com.nivaldoservices.consulta_credito_api.models.Credito;
import br.com.nivaldoservices.consulta_credito_api.repositories.credito.CreditoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditoService {

    private final CreditoRepository creditoRepository;

    public List<Credito> buscarPorNumeroNfse(String numeroNfse) throws ExcecaoPadrao {
        try {
             return creditoRepository.findByNumeroNfse(numeroNfse);
        } catch (Exception e) {
            throw new ExcecaoPadrao("erro inesperado: " + e.getMessage());
        }
    }

    public List<Credito> buscarPorNumeroCredito(String numeroCredito) throws ExcecaoPadrao {
        try {
            return creditoRepository.findByNumeroCredito(numeroCredito);
        } catch (Exception e) {
            throw new ExcecaoPadrao("erro inesperado: " + e.getMessage());
        }
    }
}
