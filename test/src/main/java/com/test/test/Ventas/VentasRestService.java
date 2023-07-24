package com.test.test.Ventas;

import com.test.test.Factura.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/ventas")
public class VentasRestService {

    @Autowired
    private final Ventas ventas;

    public VentasRestService(Ventas ventas) {
        this.ventas = ventas;
    }

    @PostMapping
    public @ResponseBody Long storeFactura(@RequestBody Factura factura,@RequestParam(value = "identificacion") String identificacion){
        return ventas.storeFactura(factura,identificacion);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public @ResponseBody List<Factura> findFacturasByPersona(@Param(value = "identificacion") String identificacion){
        List<Factura> facturas = ventas.findFacturaByIdentificacion(identificacion);
        return facturas;
    }
}
