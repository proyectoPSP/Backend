package com.proyectopsp.proyectopsp.ai;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

            JsonObject textObject = new JsonObject();
            textObject.addProperty("text", prompt);

            JsonArray innerArray = new JsonArray();
            innerArray.add(textObject);

            JsonArray contentsArray = new JsonArray();
            contentsArray.add(innerArray);

            JsonObject requestBody = new JsonObject();
            requestBody.add("contents", contentsArray);
            requestBody.addProperty("model", "gemini-2.0-flash");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-goog-api-key", geminiApiKey);

            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            String response = restTemplate.postForObject(GEMINI_URL, entity, String.class);

            JsonObject jsonResponse = new com.google.gson.JsonParser().parse(response).getAsJsonObject();
            String content = jsonResponse.getAsJsonArray("responses")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();

            return content.trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar el itinerario.";
        }
    }
}

