package br.com.smovies.rest.dtos.filme;

import br.com.smovies.domain.entities.Diretor;
import br.com.smovies.domain.entities.Filme;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class FilmeDetalhesResponseDto implements Serializable {
    private String id;
    private String nomeCompleto;
    private String sinopse;
    private String urlImagemCapa;
    private LocalDate dataLancamento;
    private List<Diretor> diretor;

    public FilmeDetalhesResponseDto(Filme filme, List<Diretor> diretores) {
        this.id = filme.getId();
        this.nomeCompleto = filme.getNomeCompleto();
        this.sinopse = filme.getSinopse();
        this.urlImagemCapa = filme.getUrlImagemCapa();
        this.dataLancamento = filme.getDataLancamento();
        this.diretor = diretores;
    }
}
