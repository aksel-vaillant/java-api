package com.projet_API.tp5.controler;

import com.projet_API.tp5.model.AddressMeteo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;


@Controller
public class MeteoController {

    // teststst 
    @GetMapping("/meteo")
    public String meteo(Model model) {
        return "meteo";
    }
}

