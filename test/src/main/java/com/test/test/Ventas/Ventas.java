package com.test.test.Ventas;

import com.test.test.Factura.Factura;
import com.test.test.Factura.FacturaRepository;
import com.test.test.Persona.Persona;
import com.test.test.Persona.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ventas {

    @Autowired
    private final FacturaRepository facturaRepository;
    private final PersonaRepository personaRepository;
    Logger logger = LoggerFactory.getLogger(Ventas.class);

    public Ventas(FacturaRepository facturaRepository, PersonaRepository personaRepository){
        this.facturaRepository = facturaRepository;
        this.personaRepository = personaRepository;
    }

    public Long storeFactura(Factura factura, String identificacion){
        logger.info("StoreFactura: "+ factura);
        Persona persona = personaRepository.findPersonaByIdentificacion(identificacion);
        Factura responseFactura = facturaRepository.save(new Factura(factura.getFecha(),factura.getMonto(),persona));
        logger.info("StoreFacturaResponse: "+ responseFactura);
        return responseFactura.getId();
    }

    public List<Factura> findFacturaByIdentificacion(String identificacion){
        List<Factura> facturas = facturaRepository.findFacturasByPersona_Identificacion(identificacion);
        logger.info("FindFacturas: " + facturas);
        return  facturas;
    }

}