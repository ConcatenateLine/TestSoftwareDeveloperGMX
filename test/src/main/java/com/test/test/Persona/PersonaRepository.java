package com.test.test.Persona;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findPersonaByIdentificacion(String identificacion);
    @Transactional
    Integer deletePersonaByIdentificacion(String identificacion);
}
