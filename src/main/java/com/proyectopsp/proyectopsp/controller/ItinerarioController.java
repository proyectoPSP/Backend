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

    @PostMapping
    public Itinerario crearItinerario(@RequestBody Itinerario itinerario) {
        // Aqui va la obtencion del clima en base al destino del itinerario
        // Aqui va la respuesta de la ia en base a el destino, los dias, el presupuesto y el clima
        String contenido = null;
        itinerario.setContenido(contenido);
        return itinerarioService.create(itinerario);
    }

    @PutMapping("/{id}")
    public Itinerario actualizarItinerario(@PathVariable int id, @RequestBody Itinerario itinerario) {
        return itinerarioService.update(id, itinerario);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarItinerario(@PathVariable int id) {
        return itinerarioService.delete(id);
    }
}