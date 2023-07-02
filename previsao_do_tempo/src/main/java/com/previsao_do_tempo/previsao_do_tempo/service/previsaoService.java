package com.previsao_do_tempo.previsao_do_tempo.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class previsaoService {

    public String apiKey = "";//adicinar chave aqui

    public String teste() {
        return "testando app service";
    }

    public String dadosCidade(String city) throws JSONException {

        String lugar = converteString(city);

        String x = acessaAPI(lugar);

        return x;
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
        return "nulo";
    }

    /*
     *  converte JSON para String
     */
    private String acessaAPI(String lugar) {
        List<String> listaDeDadosTempo = new ArrayList<String>();
        String linha;

        try {
            // Criar uma URL
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+lugar+"&units=metric&appid="+apiKey+"&lang=pt_br");

            // Abrir conexão
            URLConnection connection = url.openConnection();

            // Criar um BufferedReader para ler a resposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Ler e exibir o conteúdo da URL linha por linha
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lugar;
    }

}
