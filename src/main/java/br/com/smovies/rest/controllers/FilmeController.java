package br.com.smovies.rest.controllers;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.service.FilmeService;
import br.com.smovies.rest.dtos.FiltroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public ResponseEntity<?> cadastrarFilme(@RequestBody Filme filme) throws Exception {
        filmeService.cadastrarFilme(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    @PostMapping("/filtro")
    public ResponseEntity<?> buscarTodosFilmes(@RequestBody FiltroDto filtroDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.buscarTodosFilmes(filtroDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDetalhesFilme(@PathVariable String id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.buscarDetalhesFilme(id));
    }
}
