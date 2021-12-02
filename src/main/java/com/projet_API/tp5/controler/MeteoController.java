package com.projet_API.tp5.controler;

import com.fasterxml.jackson.core.JsonParser;
import com.projet_API.tp5.model.AddressApi;
import com.projet_API.tp5.model.AddressMeteo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Controller
public class MeteoController {




    @PostMapping(path="/meteo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postBody(@ModelAttribute AddressMeteo addresseMeteo, Model model) throws IOException {
        model.addAttribute("addresses", addresseMeteo);

        /*String sURL = "https://api-adresse.data.gouv.fr/search/?q=8+bd+du+port"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
        */

        return "meteo";
    }




}
