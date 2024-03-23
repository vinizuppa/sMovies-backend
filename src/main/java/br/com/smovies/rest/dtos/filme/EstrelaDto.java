package br.com.smovies.rest.dtos.filme;

import lombok.Data;

import java.util.List;

@Data
public class EstrelaDto {
    private List<Integer> qtdEstrelaCheia;
    private List<Integer> qtdEstrelaMetade;
    private List<Integer> qtdEstrelaVazia;
}
