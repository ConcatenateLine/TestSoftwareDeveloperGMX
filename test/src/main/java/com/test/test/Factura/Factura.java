package com.test.test.Factura;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.test.test.Persona.Persona;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate fecha;
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name="identificacion", referencedColumnName="identificacion")
    @JsonBackReference
    private Persona persona;

    protected Factura(){}

    public Factura(LocalDate fecha, BigDecimal monto, Persona persona) {
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
    }

    public Long getId() {
        return Id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Id=" + Id +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
