package com.previsao_do_tempo.previsao_do_tempo.controller;

import com.previsao_do_tempo.previsao_do_tempo.service.previsaoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/previsaotempo")
public class previsaoController {

    @Autowired
    private previsaoService prev;

    @RequestMapping(value = "/cidade", method =  RequestMethod.POST)
    public List<Object> inserirCidade(@RequestBody String cidade) throws JSONException {
        List<Object> dado = prev.dadosCidade(cidade);
        return dado;
    }

}
