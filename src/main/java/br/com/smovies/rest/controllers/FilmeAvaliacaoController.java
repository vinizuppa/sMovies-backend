package br.com.smovies.rest.controllers;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.entities.FilmeAvaliacao;
import br.com.smovies.domain.service.FilmeAvaliacaoService;
import br.com.smovies.rest.dtos.FiltroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/filtro/{filmeId}")
    public ResponseEntity<?> buscarAvaliacoesFilme(@RequestBody FiltroDto filtroDto, @PathVariable String filmeId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(filmeAvaliacaoService.listarAvaliacoesPorFilmeId(filtroDto, filmeId));
    }
}
