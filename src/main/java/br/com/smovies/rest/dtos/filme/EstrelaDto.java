package br.com.smovies.rest.dtos.filme;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EstrelaDto implements Serializable {
    private List<Integer> qtdEstrelaCheia;
    private List<Integer> qtdEstrelaMetade;
    private List<Integer> qtdEstrelaVazia;
}
