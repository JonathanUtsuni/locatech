package br.com.fiap.locatech.locatech.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.locatech.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.locatech.entitites.Aluguel;
import br.com.fiap.locatech.locatech.services.AluguelService;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AluguelController.class);

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    // http://localhost:8080/Alugueis?page=1&size=10

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("Foi acessasdo o endpoint de Aluguel /veicuos");
        var Alugueis = this.aluguelService.findAllAlugueis(page, size);
        return ResponseEntity.ok(Alugueis);
    }

    // http://localhost:8080/Aluguels/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findAllAugueis(
            @PathVariable("id") Long id) {
        logger.info("/Aluguels/" + id);
        var Aluguel = this.aluguelService.findAluguelById(id);
        return ResponseEntity.ok(Aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(
            @RequestBody AluguelRequestDTO aluguel) {
        logger.info("POST -> /Aluguel");
        this.aluguelService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(
            @PathVariable("id") Long id,
            @RequestBody Aluguel Aluguel) {
        logger.info("PUT -> /Aluguel");
        this.aluguelService.updateAluguel(Aluguel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluguel(
            @PathVariable("id") Long id) {
        logger.info("DELETE -> /Aluguel");
        this.aluguelService.delete(id);
        return ResponseEntity.ok().build();
    }

}
