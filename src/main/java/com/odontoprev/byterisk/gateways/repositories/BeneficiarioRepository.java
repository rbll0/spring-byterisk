package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Beneficiario. Fornece métodos para realizar operações CRUD no banco de dados.
 */
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
