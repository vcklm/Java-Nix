package com_nix_ragency.controllers;

import com_nix_ragency.models.Flat;
import com_nix_ragency.repositories.IFlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final IFlatRepository repository;
@Autowired
    public HomeController(IFlatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String findAll(Model model){
        List<Flat> flats=repository.findAll();
     model.addAttribute("flats",flats);
        return "home";
    }
    @GetMapping("/client")
    public String client(){
        return "client";
    }
    @GetMapping("/rieltor")
    public String rieltor(){
        return "rieltor";
    }
    @GetMapping("/owner")
    public String owner(){
        return "owner";
    }

}
