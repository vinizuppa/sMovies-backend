package br.com.smovies.rest.controllers;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.entities.FilmeAvaliacao;
import br.com.smovies.domain.service.FilmeAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme-avaliacao")
public class FilmeAvaliacaoController {
    @Autowired
    private FilmeAvaliacaoService filmeAvaliacaoService;
    @PostMapping
    public ResponseEntity<?> cadastrarFilmeAvaliacao(@RequestBody FilmeAvaliacao filmeAvaliacao) throws Exception {
        filmeAvaliacaoService.cadastrarFilmeAvaliacao(filmeAvaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeAvaliacao);
    }
}
