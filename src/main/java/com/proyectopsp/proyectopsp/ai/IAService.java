package com.proyectopsp.proyectopsp.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class IAService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    // Puedes apuntar al endpoint de Gemini
    private static final String GEMINI_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public String generarItinerario(String destino, int dias, double presupuesto, String clima) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String prompt = String.format(
                    "Genera un itinerario de viaje de %d días en %s con un presupuesto de %.2f€. " +
                            "El clima será %s. Incluye actividades diarias, recomendaciones de hoteles y precios estimados, " +
                            "en formato de texto normal (no JSON). Escribe de manera clara y organizada.",
                    dias, destino, presupuesto, clima
            );

            JSONObject requestBody = new JSONObject()
                    .put("contents", new JSONArray()
                            .put(new JSONObject()
                                    .put("text", prompt)))
                    .put("model", "gemini-2.0-flash");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-goog-api-key", geminiApiKey);

            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            String response = restTemplate.postForObject(GEMINI_URL, entity, String.class);

            JSONObject jsonResponse = new JSONObject(response);
            // Ajusta cómo extraes la respuesta según lo que Gemini devuelva
            String content = jsonResponse
                    .getJSONArray("responses")
                    .getJSONObject(0)
                    .getString("text");
            return content.trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar el itinerario.";
        }
    }
}

