package com.previsao_do_tempo.previsao_do_tempo.controller;

import com.previsao_do_tempo.previsao_do_tempo.model.DadoClimatico;
import com.previsao_do_tempo.previsao_do_tempo.service.PrevisaoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/previsao-tempo")
public class PrevisaoController {

    @Autowired
    private PrevisaoService prev;

    @GetMapping(value = "/")
    public String listar() {
        return "/index";
    }

    @GetMapping(value = "")
    public String teste() {
        return listar();
    }

    @PostMapping(value = "/cidade")
    public String inserirCidade(@RequestParam String cidade, Model model) throws JSONException {
        DadoClimatico dadoClimatico = prev.dadosCidade(cidade);
        model.addAttribute("dadoClimatico", dadoClimatico);
        return "/analise";
    }

}
