package br.com.smovies.domain.service;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.repositories.FilmeRepository;
import br.com.smovies.rest.dtos.FiltroDto;
import br.com.smovies.rest.dtos.filme.FilmeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private FilmeAvaliacaoService filmeAvaliacaoService;

    public void cadastrarFilme(Filme filme) {
        filmeRepository.save(filme);
    }

    public Page<FilmeResponseDto> buscarTodosFilmes(FiltroDto filtroDto) {
        Page<Filme> filmesPage = filmeRepository.findAll(PageRequest.of(filtroDto.getNumeroPagina(), filtroDto.getQuantidadePorPagina()));

        Page<FilmeResponseDto> filmeResponseDtoPage = filmesPage.map(filme -> new FilmeResponseDto(filme, filmeAvaliacaoService.calcularMediaNotaFilme(filme.getId())));

        return filmeResponseDtoPage;
    }
}
