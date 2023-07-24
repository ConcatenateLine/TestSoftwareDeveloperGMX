package com.test.test.Directorio;

import com.test.test.Persona.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RequestMapping("api/directorio")
public class DirectorioRestService {

    @Autowired
    private final Directorio directorio;

    Logger logger = LoggerFactory.getLogger(Directorio.class);

    public DirectorioRestService(Directorio directorio) {
        this.directorio = directorio;
    }

    @PostMapping
    public @ResponseBody Persona storePersona(@RequestBody Persona persona){
        logger.info("StorePersona: "+ persona);
        return directorio.storePersona(persona);
    }

    @GetMapping
    public @ResponseBody List<Persona> findPersonas(){
        return  directorio.findPersonas();
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public @ResponseBody Persona findPersonaByIdentificacion(@Param(value = "identificacion") String identificacion){
        return directorio.findPersonaByIdentificacion(identificacion);
    }

    @RequestMapping(value="/eliminar{identificacion}", method = RequestMethod.DELETE)
    public void deletePersonaByIdentificacion(@Param(value = "identificacion") String identificacion){
        Integer persona =  directorio.deletePersonaByIdentificacion(identificacion);
    }
}
