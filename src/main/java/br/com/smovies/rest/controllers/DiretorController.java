package br.com.smovies.rest.controllers;

import br.com.smovies.domain.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diretor")
public class DiretorController {
    @Autowired
    private DiretorService diretorService;

    @GetMapping
    public ResponseEntity<?> buscarDiretores() {
        return ResponseEntity.status(HttpStatus.OK).body(diretorService.buscarDiretores());

    }
}
