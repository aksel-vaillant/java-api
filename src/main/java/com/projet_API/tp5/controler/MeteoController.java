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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MeteoController {

    @PostMapping(path="/meteo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postBody(@ModelAttribute AddressMeteo addresseMeteo, Model model) throws IOException {
        model.addAttribute("addresses", addresseMeteo);

        /*URL url = new URL("https://api-adresse.data.gouv.fr/search/?q=8+bd+du+port");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();

        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Host", "api-adresse.data.gouv.fr");

        http.setRequestMethod("GET");
        http.setConnectTimeout(10000);// 5000 milliseconds = 5 seconds
        http.setReadTimeout(10000);

        int status = http.getResponseCode();
        System.out.println(status);

        if(status >= 500){
            // Fucking error
            System.out.println("merdeeeee");
        }else if(status>= 200 && status <=299){
            // Getting datas
            byte[] out = new byte[200];
            OutputStream stream = http.getOutputStream();
            stream.write(out);
            System.out.println(out);
            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        }
        http.disconnect();*/

        URL url = new URL("https://api-adresse.data.gouv.fr/search/?q=8+bd+du+port");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "*/*");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

        // https://reqbin.com/req/java/v0crmky0/rest-api-post-example
        
        return "meteo";
    }




}
