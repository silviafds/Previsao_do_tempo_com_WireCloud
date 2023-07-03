package com.previsao_do_tempo.previsao_do_tempo.controller.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscribe")
public class PrevisaoRestController {

    @PostMapping
    public void subscribe(@RequestBody JsonNode jsonNode) {
        System.out.println(jsonNode.toPrettyString());
    }
}
