package com.proyectopsp.proyectopsp.controller;

import com.proyectopsp.proyectopsp.ai.IAService;
import com.proyectopsp.proyectopsp.external.WeatherService;
import com.proyectopsp.proyectopsp.model.Itinerario;
import com.proyectopsp.proyectopsp.service.ItinerarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerarios")
public class ItinerarioController {

    private final ItinerarioService itinerarioService;
    private final IAService iaService;
    private final WeatherService weatherService;

    public ItinerarioController(ItinerarioService itinerarioService, IAService iaService, WeatherService weatherService) {
        this.itinerarioService = itinerarioService;
        this.iaService = iaService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<Itinerario> listarItinerarios() {
        return itinerarioService.getAll();
    }

    @GetMapping("/{id}")
    public Itinerario obtenerItinerario(@PathVariable int id) {
        return itinerarioService.getById(id);
    }

    // Desde el body pide los datos de destino, dias y presupuesto y se crea un itinerario con esos datos
    @PostMapping
    public Itinerario crearItinerario(@RequestBody Itinerario itinerario) {
        String clima = weatherService.obtenerClima(itinerario.getDestino());
        itinerario.setContenido(iaService.generarItinerario(itinerario, clima));
        return itinerarioService.create(itinerario);
    }


    //Probablemente se elimine proximamente
    @PutMapping("/{id}")
    public Itinerario actualizarItinerario(@PathVariable int id, @RequestBody Itinerario itinerario) {
        String clima = weatherService.obtenerClima(itinerario.getDestino());
        String contenido = iaService.generarItinerario(itinerario, clima);
        itinerario.setContenido(contenido);
        return itinerarioService.update(id, itinerario);
    }


    @DeleteMapping("/{id}")
    public boolean eliminarItinerario(@PathVariable int id) {
        return itinerarioService.delete(id);
    }
}



