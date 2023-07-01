package com.previsao_do_tempo.previsao_do_tempo.controller;

import com.previsao_do_tempo.previsao_do_tempo.service.previsaoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/previsaotempo")
public class previsaoController {

    @Autowired
    private previsaoService prev;

    @GetMapping
    public String eita() {
        String palavra = prev.teste();
        return palavra;
    }

    @RequestMapping(value = "/cidade", method =  RequestMethod.POST)
    public String inserirCidade(@RequestBody String cidade) throws JSONException {
        String dado = prev.dadosCidade(cidade);
        return dado;
    }

}
