package com.projet_API.tp5.controler;

import com.projet_API.tp5.model.Address;
import com.projet_API.tp5.model.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository ;
    @GetMapping("/adresses")
    public String showAddresses (Model model){
        model.addAttribute ("allAddresses", addressRepository.findAll());
        return "addresses";
    }
}
