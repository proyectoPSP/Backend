package com.proyectopsp.proyectopsp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Itinerario {
    private int id;
    private String destino;
    private int dias;
    private double presupuesto;
    private String contenido; // Itinerario generado por la IA (texto)
    private LocalDate fechaCreacion;

    public Itinerario() {}

    public Itinerario(int id, String destino, int dias, double presupuesto, String contenido) {
        this.id = id;
        this.destino = destino;
        this.dias = dias;
        this.presupuesto = presupuesto;
        this.contenido = contenido;
        fechaCreacion = LocalDate.now();
    }
}
