package br.com.smovies.rest.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
public class FiltroDto implements Serializable {
    private Integer numeroPagina;
    private Integer quantidadePorPagina;
}
