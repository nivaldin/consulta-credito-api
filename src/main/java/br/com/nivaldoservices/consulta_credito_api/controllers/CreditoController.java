package br.com.nivaldoservices.consulta_credito_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.nivaldoservices.consulta_credito_api.exceptions.ExcecaoPadrao;
import br.com.nivaldoservices.consulta_credito_api.models.Credito;
import br.com.nivaldoservices.consulta_credito_api.services.credito.CreditoService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/creditos")
@CrossOrigin(origins = "*")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{numeroNfse}")
    public List<Credito> getByNumeroNfse(@PathVariable String numeroNfse) throws ExcecaoPadrao {
        return creditoService.buscarPorNumeroNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public List<Credito> getByNumeroCredito(@PathVariable String numeroCredito) throws ExcecaoPadrao {
        return creditoService.buscarPorNumeroCredito(numeroCredito);
    }

}
