package com.previsao_do_tempo.previsao_do_tempo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previsao_do_tempo.previsao_do_tempo.model.DadoClimatico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

@Service
public class PrevisaoService {

    public String apiKey = "80e0070b689cbee079cb225a96f68b9a";//adicinar chave aqui

    public DadoClimatico dadosCidade(String city) {
        return acessaAPI(WordUtils.capitalize(city));
    }

    /*
     *  Acessa API e retorna os dados necessários de previsão do tempo
     */
    private DadoClimatico acessaAPI(String lugar) {
        String linha;

        DadoClimatico dadoClimatico = null;
        try {
            // Criar uma URL
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + lugar + "&units=metric&appid=" + apiKey + "&lang=pt_br");

            // Abrir conexão
            URLConnection connection = url.openConnection();

            // Criar um BufferedReader para ler a resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

            StringBuilder response = new StringBuilder();

            while ((linha = reader.readLine()) != null) {
                response.append(linha);
                System.out.println(linha);
            }
            reader.close();

            // Analisar a resposta JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            // Extrair valores de coord
            JsonNode coordNode = rootNode.get("coord");
            double lon = coordNode.get("lon").asDouble();
            double lat = coordNode.get("lat").asDouble();
            // Extrair valores de description
            JsonNode weatherNode = rootNode.get("weather").get(0);
            String main = weatherNode.get("main").asText();
            String description = weatherNode.get("description").asText();
            // Extrair valores de sys
            JsonNode sysNode = rootNode.get("sys");
            String country = sysNode.get("country").asText();
            // Extrair valores de main
            JsonNode mainNode = rootNode.get("main");
            double temp = mainNode.get("temp").asDouble();
            double feelsLike = mainNode.get("feels_like").asDouble();
            double tempMin = mainNode.get("temp_min").asDouble();
            double tempMax = mainNode.get("temp_max").asDouble();
            int pressure = mainNode.get("pressure").asInt();
            int humidity = mainNode.get("humidity").asInt();
            // Extrair valores de vento
            JsonNode ventoNode = rootNode.get("wind");
            double speed = ventoNode.get("speed").asDouble();

            dadoClimatico = new DadoClimatico(lugar, country, main, WordUtils.capitalize(description),
                    temp, tempMin, tempMax, feelsLike, humidity, speed, pressure, lon, lat);

            System.out.println(dadoClimatico);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadoClimatico;
    }

}
