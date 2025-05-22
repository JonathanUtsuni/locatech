package br.com.fiap.locatech.locatech.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.locatech.locatech.entitites.Pessoa;
import br.com.fiap.locatech.locatech.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PessoaController.class);

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // http://localhost:8080/Pessoas?page=1&size=10

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("Foi acessasdo o endpoint de Pessoa /veicuos");
        var Pessoas = this.pessoaService.findAllPessoas(page, size);
        return ResponseEntity.ok(Pessoas);
    }

    // http://localhost:8080/Pessoas/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoa(
            @PathVariable("id") Long id) {
        logger.info("/Pessoas/" + id);
        var Pessoa = this.pessoaService.findPessoaById(id);
        return ResponseEntity.ok(Pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(
            @RequestBody Pessoa Pessoa) {
        logger.info("POST -> /Pessoas");
        this.pessoaService.savePessoa(Pessoa);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable("id") Long id,
            @RequestBody Pessoa Pessoa) {
        logger.info("PUT -> /Pessoas");
        this.pessoaService.updatePessoa(Pessoa, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable("id") Long id) {
        logger.info("DELETE -> /Pessoas");
        this.pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
