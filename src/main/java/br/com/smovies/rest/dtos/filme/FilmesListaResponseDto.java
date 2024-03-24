package br.com.smovies.rest.dtos.filme;

import br.com.smovies.domain.entities.Diretor;
import br.com.smovies.domain.entities.Filme;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmesListaResponseDto {
    private String id;
    private String nomeCompleto;
//    private String sinopse;
    private String urlImagemCapa;
//    private LocalDate dataLancamento;
//    private List<Diretor> diretor;
    private Double mediaNota;
    private Integer qtdAvaliacoes;
    private EstrelaDto estrelaDto;

    public FilmesListaResponseDto(Filme filme, FilmeAvaliacaoResponseDto filmeAvaliacaoResponseDto) {
        this.id = filme.getId();
        this.nomeCompleto = filme.getNomeCompleto();
        this.urlImagemCapa = filme.getUrlImagemCapa();
        this.mediaNota = filmeAvaliacaoResponseDto.getMediaNotaAvaliacao();
        this.qtdAvaliacoes = filmeAvaliacaoResponseDto.getQtdAvaliacoes();
        this.estrelaDto = filmeAvaliacaoResponseDto.getEstrelaDto();
    }
}
