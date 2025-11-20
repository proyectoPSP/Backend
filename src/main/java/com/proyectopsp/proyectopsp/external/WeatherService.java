package com.proyectopsp.proyectopsp.external;

import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {
    public String obtenerClima(String destino) {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "410604c356557d1e216aac8f21d105e6";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = apiUrl + "?q=" + destino + "&appid=" + apiKey + "&lang=es&units=metric";

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response != null && response.containsKey("weather")) {
                var weather = (java.util.List<Map<String, Object>>) response.get("weather");
                return (String) weather.get(0).get("description");
            }
            return "No se ha encontrado la ciudad";
        } catch (Exception e) {
            return "Servicio no disponible";
        }
    }
}
