package br.com.smovies.domain.service;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.repositories.FilmeRepository;
import br.com.smovies.rest.dtos.FiltroDto;
import br.com.smovies.rest.dtos.filme.FilmeDetalhesResponseDto;
import br.com.smovies.rest.dtos.filme.FilmesListaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private FilmeAvaliacaoService filmeAvaliacaoService;
    @Autowired
    private DiretorService diretorService;

    @CacheEvict(value="buscarTodosFilmes", allEntries = true)
    public void cadastrarFilme(Filme filme) {
        filmeRepository.save(filme);
    }

    @Cacheable(value="buscarTodosFilmes", key="#filtroDto.numeroPagina")
    public Page<FilmesListaResponseDto> buscarTodosFilmes(FiltroDto filtroDto) {
        Page<Filme> filmesPage = filmeRepository.findAll(PageRequest.of(filtroDto.getNumeroPagina(), filtroDto.getQuantidadePorPagina()));

        Page<FilmesListaResponseDto> filmeResponseDtoPage = filmesPage.map(filme -> new FilmesListaResponseDto(filme, filmeAvaliacaoService.calcularMediaNotaFilme(filme.getId())));

        return filmeResponseDtoPage;
    }

    @Cacheable("buscarDetalhesFilme")
    public Object buscarDetalhesFilme(String id) {
        var filme = filmeRepository.findById(id);
        var diretor = diretorService.buscarDiretorPorId(filme.get().getDiretorId());

        if (filme.isPresent()) {
            return new FilmeDetalhesResponseDto(filme.get(), Arrays.asList(diretor));
        }

        return null;
    }
}
