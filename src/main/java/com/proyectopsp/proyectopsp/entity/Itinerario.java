package com.proyectopsp.proyectopsp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data // Crea todos los getters y setters
@Entity // Define la clase como una entidad para la base de datos
public class Itinerario {
    @Id
    @GeneratedValue
    private Long id;

    private String destino;
    private int dias;
    private double presupuesto;
    private String contenido = null; // Itinerario generado por la IA (texto)
    private String intereses;
    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_usuario") // Se le dice a jpa que el objeto usuario se mapea a la columna id_usuario usando usuario.getId() por defecto
    private Usuario usuario;
}
