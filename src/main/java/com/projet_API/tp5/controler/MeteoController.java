package com.projet_API.tp5.controler;

import com.projet_API.tp5.data.data.address.AddressQueryResult;
import com.projet_API.tp5.data.data.meteo.MeteoQueryResult;
import com.projet_API.tp5.model.AddressMeteo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;


@Controller
public class MeteoController {

    @PostMapping(path = "/meteo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String postBody(@ModelAttribute AddressMeteo addresseMeteo, Model model) {
        model.addAttribute("addresses", addresseMeteo);
        System.out.println(addresseMeteo.getAddress());

        String request = addresseMeteo.getAddress().replace(" ", "+");
        System.out.println(request);

        String uri = "https://api-adresse.data.gouv.fr/search/?limit=1&q=" + request;
        System.out.println(uri);

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10*1000);
        requestFactory.setReadTimeout(10*1000);

        //RestTemplateBuilder builder = new RestTemplateBuilder();
        //RestTemplate restTemplate = builder.build();

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        AddressQueryResult result = restTemplate.getForObject(uri, AddressQueryResult.class);
        System.out.println(result);

        String label = result.getFeatures()[0].getProperties().getLabel();
        System.out.println(label);
        System.out.println("Geometry coordinates : " + result.getFeatures()[0].getGeometry().getCoordinates());
        double lon = result.getFeatures()[0].getGeometry().getCoordinates()[0];
        double lat = result.getFeatures()[0].getGeometry().getCoordinates()[1];

        //String meteoResult = getMeteoResult(model, lat, lon);

        //model.addAttribute("label", label);
        //model.addAttribute("status", meteoResult);

        model.addAttribute("lon", lon);
        model.addAttribute("lat", lat);

        return "meteo";
    }



    /*private String getMeteoResult(Model model, double lat, double lon) {
        String uri = "https://api.meteo-concept.com/api/forecast/daily?" +
                "token=2c3c2754e63990debfe78a1a00b2cb232d6dea52bcae58217bc587ffad7ebc5e&" +
                "latlng="+ lat +","+ lon;

        RestTemplateBuilder builder = new RestTemplateBuilder();

        RestTemplate restTemplate = builder.build();
        MeteoQueryResult result = restTemplate.getForObject(uri, MeteoQueryResult.class);
        int probarain = result.getForecast()[0].getProbarain();

        model.addAttribute("probarain", probarain);

        if(probarain > 40) {
            return "Il ne fait pas beau";
        } else {
            return "Il fait beau";
        }
    }*/
}
