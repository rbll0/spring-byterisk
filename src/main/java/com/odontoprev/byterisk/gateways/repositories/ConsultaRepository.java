package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Adicionar métodos de consulta personalizados
}
