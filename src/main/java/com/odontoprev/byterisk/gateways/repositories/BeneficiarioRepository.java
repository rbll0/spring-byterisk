package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
