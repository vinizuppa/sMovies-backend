package br.com.smovies.rest.dtos.filmeAvaliacao;

import br.com.smovies.domain.entities.FilmeAvaliacao;
import br.com.smovies.rest.dtos.filme.EstrelaDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FilmeAvaliacaoDto implements Serializable {
    private String nomeAvaliador;
    private Double nota;
    private EstrelaDto estrelaDto;
    private String avaliacao;

    public FilmeAvaliacaoDto(FilmeAvaliacao filmeAvaliacao, EstrelaDto estrelaDto) {
        //TODO passar no construtor o nome do avaliador
        this.nomeAvaliador = "João Silva";
        this.nota = filmeAvaliacao.getNota();
        this.estrelaDto = estrelaDto;
        this.avaliacao = filmeAvaliacao.getAvaliacao();
    }
}
