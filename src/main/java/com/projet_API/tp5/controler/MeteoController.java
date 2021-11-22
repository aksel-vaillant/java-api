package com.projet_API.tp5.controler;

import com.projet_API.tp5.model.AddressApi;
import com.projet_API.tp5.model.AddressMeteo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MeteoController {

    @PostMapping(path="/meteo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postBody(@ModelAttribute AddressMeteo addresseMeteo, Model model) {
        model.addAttribute("addresses", addresseMeteo);
        return "meteo";
    }


}
