package com.previsao_do_tempo.previsao_do_tempo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class previsaoService {

    public String apiKey = "80e0070b689cbee079cb225a96f68b9a";//adicinar chave aqui

    public List<Object> dadosCidade(String city) throws JSONException {
        List<Object> dadosLugares;
        String lugar = converteString(city);
        dadosLugares = acessaAPI(lugar);
        return dadosLugares;
    }

    /*
    *  converte JSON para String
    */
    public String converteString(String city) throws JSONException {
        String cidade;
        if (city!=null) {
            JSONObject jsonObject = new JSONObject(city);
            cidade = jsonObject.getString("cidade");
            return cidade;
        }
        return "Lugar inválido";
    }

    /*
     *  Acessa API e retorna list com os dados necessários de previsão do tempo
     */
    private List<Object> acessaAPI(String lugar) {
        String linha;

        List<Object> valores = null;
        try {
            // Criar uma URL
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + lugar + "&units=metric&appid=" + apiKey + "&lang=pt_br");

            // Abrir conexão
            URLConnection connection = url.openConnection();

            // Criar um BufferedReader para ler a resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

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

            valores = new ArrayList<>();
            valores.add(lugar); //lugar
            valores.add(country); //país
            valores.add(arredondarEConverterParaInteiro(temp)); //temperatura atual
            valores.add(main); // status atual: chuva, sol, nuvens
            valores.add(arredondarEConverterParaInteiro(feelsLike)); // sensação termica
            valores.add(arredondarEConverterParaInteiro(tempMin)); //temperatura minima
            valores.add(arredondarEConverterParaInteiro(tempMax)); //temperatura maxima
            valores.add(description); //description
            valores.add(arredondarEConverterParaInteiro(humidity)); //umidade
            valores.add(arredondarEConverterParaInteiro(speed)); //velociade vento
            valores.add(pressure); // pressao
            valores.add(lon); //longitude
            valores.add(lat); //latitude


            for (Object valor : valores) {
                System.out.println(valor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return valores;
    }


    /*
     *  Função que arredonda e converte para inteiro
     */
    public static int arredondarEConverterParaInteiro(double numero) {
        long numeroArredondado = Math.round(numero);
        int numeroInteiro = Math.toIntExact(numeroArredondado);

        return numeroInteiro;
    }





}
