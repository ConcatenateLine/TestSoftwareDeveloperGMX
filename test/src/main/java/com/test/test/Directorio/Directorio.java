package com.test.test.Directorio;

import com.test.test.Persona.Persona;
import com.test.test.Persona.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Directorio {

    @Autowired
    private final PersonaRepository personaRepository;
    Logger logger = LoggerFactory.getLogger(Directorio.class);

    public Directorio(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public Persona storePersona(Persona persona){
        logger.info("StorePersona: "+ persona);
        return personaRepository.save(persona);
    }

    public Persona findPersonaByIdentificacion(String identificacion){
        Optional<Persona> optionalPersona = Optional.ofNullable(personaRepository.findPersonaByIdentificacion(identificacion));
        logger.info("FindPersona: "+ optionalPersona);
        return optionalPersona.get();
    }

    public List<Persona> findPersonas(){
        return personaRepository.findAll();
    }

    public Integer deletePersonaByIdentificacion(String identificacion){
        Integer persona = personaRepository.deletePersonaByIdentificacion(identificacion);
        logger.info("Eliminando: "+ identificacion);
        return persona;
    }
}
