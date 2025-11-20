package com.proyectopsp.proyectopsp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;
    private int dias;
    private double presupuesto;
    private String contenido = null; // Itinerario generado por la IA (texto)
    private String intereses;
    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne
    private Usuario usuario;

    public Itinerario() {}
}
