package com.projet_API.tp5.controler;

import com.projet_API.tp5.data.data.address.AddressQueryResult;
import com.projet_API.tp5.data.data.meteo.MeteoQueryResult;
import com.projet_API.tp5.model.AddressApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class MeteoFinder {
    @PostMapping("/meteo_finder")
    public String meteoFinder(@RequestParam String address, Model model) {
        String uri = "https://api-adresse.data.gouv.fr/search/?limit=1&q=" + address;
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        AddressQueryResult result = restTemplate.getForObject(uri, AddressQueryResult.class);

        String label = result.getFeatures()[0].getProperties().getLabel();
        System.out.println("Geometry coordinates : " + result.getFeatures()[0].getGeometry().getCoordinates());
        double lon = result.getFeatures()[0].getGeometry().getCoordinates()[0];
        double lat = result.getFeatures()[0].getGeometry().getCoordinates()[1];

        String meteoResult = getMeteoResult(model, lat, lon);

        model.addAttribute("label", label);
        model.addAttribute("status", meteoResult);

        return "meteo_finder";
    }

    private String getMeteoResult(Model model, double lat, double lon) {
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
    }
}
