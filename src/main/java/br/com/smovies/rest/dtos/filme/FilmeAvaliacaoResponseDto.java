package br.com.smovies.rest.dtos.filme;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilmeAvaliacaoResponseDto implements Serializable {
    private Double mediaNotaAvaliacao;
    private Integer qtdAvaliacoes;
    private EstrelaDto estrelaDto;
}
