package com.proyectopsp.proyectopsp.controller;

import com.proyectopsp.proyectopsp.external.IAService;
import com.proyectopsp.proyectopsp.external.WeatherService;
import com.proyectopsp.proyectopsp.entity.Itinerario;
import com.proyectopsp.proyectopsp.service.BDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerarios")
public class ItinerarioController {

    private final BDService bdService;
    private final IAService iaService;
    private final WeatherService weatherService;

    public ItinerarioController(BDService bdService, IAService iaService, WeatherService weatherService) {
        this.bdService = bdService;
        this.iaService = iaService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<Itinerario> listarItinerarios() {
        return bdService.findAllItinerarios();
    }

    @GetMapping("/{id}")
    public Itinerario obtenerItinerario(@PathVariable int id) {
    }

    // Desde el body pide los datos de destino, dias y presupuesto y se crea un itinerario con esos datos
    @PostMapping
    public Itinerario crearItinerario(@RequestBody Itinerario itinerario) {
        String clima = weatherService.obtenerClima(itinerario.getDestino());
        itinerario.setContenido(iaService.generarItinerario(itinerario, clima));
        return bdService;
    }

    @DeleteMapping("/{id}")
    public boolean eliminarItinerario(@PathVariable int id) {
        return itinerarioService.delete(id);
    }
}



