package br.com.smovies.rest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroDto {
    private Integer numeroPagina;
    private Integer quantidadePorPagina;
}
