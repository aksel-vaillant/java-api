package com.projet_API.tp5.controler;

import com.projet_API.tp5.objectFromRequest.address.AddressQueryResult;
import com.projet_API.tp5.objectFromRequest.meteo.MeteoQueryResult;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class MeteoController {

    @PostMapping(path = "/meteo")
    public String postBody(@RequestParam(value = "address") String addressMeteo, Model model) {
        // Préparation des échanges
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();

        // Avoir les données GPS lat/lon à partir d'une adresse
        double[] coordinate = getAddressResult(restTemplate, model, addressMeteo);

        // Avoir les données météo à partir des points GPS
        getMeteoResult(restTemplate, model, coordinate[1], coordinate[0]);

        return "meteo";
    }

    /*
    *       getAddressResult
    *
    *       retourne la position latitude et longitude d'une adresse
     */
    private double[] getAddressResult(RestTemplate restTemplate, Model model, String addressMeteo){
        // Préparation de la requête
        String uri = "https://api-adresse.data.gouv.fr/search/?limit=1&q=" + addressMeteo.replace(" ", "+");

        // Résultat de la requête
        AddressQueryResult result = restTemplate.getForObject(uri, AddressQueryResult.class);

        // Traitement des informations
        String name = result.getFeatures()[0].getProperties().getName();
        String city = result.getFeatures()[0].getProperties().getCity() + ", " +result.getFeatures()[0].getProperties().getContext();

        double lon = result.getFeatures()[0].getGeometry().getCoordinates()[0];
        double lat = result.getFeatures()[0].getGeometry().getCoordinates()[1];

        // Affichage des informations dans le fichier html
        model.addAttribute("name", name);
        model.addAttribute("city", city);

        model.addAttribute("lon", lon);
        model.addAttribute("lat", lat);

        return new double[]{lon, lat};
    }

    /*
     *       getMeteoResult
     *
     *       retourne la probabilité de pluie et l'échelle de température
     */
    private void getMeteoResult(RestTemplate restTemplate, Model model, double lat, double lon) {
        // Préparation de la requête
        String uri = "https://api.meteo-concept.com/api/forecast/daily?" +
                "token=08c9d0a82c1eb23fdd59cb4c8d61743dc3dcee51ef8d83bca0b9060c36923e9f&" +
                "latlng="+ lat +","+ lon;

        // Résultat de la requête
        MeteoQueryResult result = restTemplate.getForObject(uri, MeteoQueryResult.class);

        // Traitement des informations
        int probarain = result.getForecast()[0].getProbarain();
        int tmin = result.getForecast()[0].getTmin();
        int tmax = result.getForecast()[0].getTmax();
        int weather = result.getForecast()[0].getWeather();

        // Affichage des informations dans le fichier html
        model.addAttribute("probarain", probarain);
        model.addAttribute("tmin", tmin);
        model.addAttribute("tmax", tmax);
        model.addAttribute("weather", weather);
    }
}
