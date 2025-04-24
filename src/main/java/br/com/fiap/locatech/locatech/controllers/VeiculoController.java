package br.com.fiap.locatech.locatech.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @GetMapping
    public String getVeiculos() {
        return "Hello veiculo";
    }

}
