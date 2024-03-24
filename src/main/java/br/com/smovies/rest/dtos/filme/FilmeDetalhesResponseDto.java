package br.com.smovies.rest.dtos.filme;

import br.com.smovies.domain.entities.Diretor;
import br.com.smovies.domain.entities.Filme;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmeDetalhesResponseDto {
    private String id;
    private String nomeCompleto;
    private String sinopse;
    private String urlImagemCapa;
    private LocalDate dataLancamento;
    private List<Diretor> diretor;

    public FilmeDetalhesResponseDto(Filme filme) {
        this.id = filme.getId();
        this.nomeCompleto = filme.getNomeCompleto();
        this.sinopse = filme.getSinopse();
        this.urlImagemCapa = filme.getUrlImagemCapa();
        this.dataLancamento = filme.getDataLancamento();
        this.diretor = filme.getDiretor();
    }
}
