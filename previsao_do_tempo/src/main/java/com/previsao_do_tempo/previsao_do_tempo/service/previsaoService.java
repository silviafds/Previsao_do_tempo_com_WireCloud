package com.previsao_do_tempo.previsao_do_tempo.service;

import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.stereotype.Service;

@Service
public class previsaoService {

    public String apiKey = "";//adicinar chave aqui

    public String teste() {
        return "testando app service";
    }

    public String dadosCidade(String city) throws JSONException {
        String cidade=null;
        if (city!=null) { //convete dado para String
            JSONObject jsonObject = new JSONObject(city);
            cidade = jsonObject.getString("cidade");
        }

        //chama API
        String apiURL = "https://api.openweathermap.org/data/3.0/onecall?q="+cidade+"&units=metric&appid="+apiKey+"&lang=pt_br";

        if(apiURL==null) {
            return "é null";
        }
        System.out.println(apiURL);
        return apiURL;
    }


}
