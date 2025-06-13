package br.com.nivaldoservices.consulta_credito_api.repositories.credito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.nivaldoservices.consulta_credito_api.models.Credito;
import jakarta.transaction.Transactional;

@Service
@Transactional
public interface CreditoRepository extends JpaRepository<Credito, Long> {

        List<Credito> findByNumeroNfse(String numeroNfse);

        List<Credito> findByNumeroCredito(String numeroCredito);

}
