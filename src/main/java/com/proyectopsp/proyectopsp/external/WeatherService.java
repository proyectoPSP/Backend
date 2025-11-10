package com.proyectopsp.proyectopsp.external;

import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    private static final String API_KEY = "410604c356557d1e216aac8f21d105e6";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    RestTemplate restTemplate = new RestTemplate();

    public String obtenerClima(String destino) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + destino +
                "&appid=" + API_KEY + "&lang=es&units=metric";

        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response != null && response.containsKey("weather")) {
                var weather = (java.util.List<Map<String, Object>>) response.get("weather");
                return (String) weather.get(0).get("description");
            }
            return "No disponible";
        } catch (Exception e) {
            return "No se ha encontrado la ciudad";
        }
    }




}
