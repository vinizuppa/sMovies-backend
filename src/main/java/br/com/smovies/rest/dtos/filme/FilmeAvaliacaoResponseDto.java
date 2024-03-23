package br.com.smovies.rest.dtos.filme;

import lombok.Data;

@Data
public class FilmeAvaliacaoResponseDto {
    private Double mediaNotaAvaliacao;
    private Integer qtdAvaliacoes;
    private EstrelaDto estrelaDto;
}
