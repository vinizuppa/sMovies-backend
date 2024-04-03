package br.com.smovies.rest.dtos.diretor;

import lombok.Data;

import java.io.Serializable;

@Data
public class DiretorResponseDto implements Serializable {
    private String id;
    private String nomeDiretor;
    private String siglaPais;
}
