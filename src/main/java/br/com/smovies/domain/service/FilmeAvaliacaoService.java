package br.com.smovies.domain.service;

import br.com.smovies.domain.entities.FilmeAvaliacao;
import br.com.smovies.domain.repositories.FilmeAvaliacaoRepository;
import br.com.smovies.rest.dtos.filme.EstrelaDto;
import br.com.smovies.rest.dtos.filme.FilmeAvaliacaoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FilmeAvaliacaoService {
    @Autowired
    private FilmeAvaliacaoRepository filmeAvaliacaoRepository;

    public FilmeAvaliacaoResponseDto calcularMediaNotaFilme(String filmeId) {
        List<FilmeAvaliacao> filmeAvalicaoList = this.buscarPorFilmeId(filmeId);

        Double totalNota = filmeAvalicaoList.stream().mapToDouble(FilmeAvaliacao::getNota).sum();
        var media = 0.00;

        if (filmeAvalicaoList.size() != 0) {
            media = totalNota / filmeAvalicaoList.size();
        }


        var filmeAvaliacaoResponseDto = new FilmeAvaliacaoResponseDto();
        filmeAvaliacaoResponseDto.setMediaNotaAvaliacao(media);
        filmeAvaliacaoResponseDto.setQtdAvaliacoes(filmeAvalicaoList.size());
        filmeAvaliacaoResponseDto.setEstrelaDto(this.calcularEstrelas(media));

        return filmeAvaliacaoResponseDto;
    }

    private List<FilmeAvaliacao> buscarPorFilmeId(String filmeId) {
        List<FilmeAvaliacao> filmeAvaliacaoList = filmeAvaliacaoRepository.findByFilmeId(filmeId);
        return filmeAvaliacaoList;
    }

    private EstrelaDto calcularEstrelas(Double media) {
        var estrelaDto = new EstrelaDto();
        var estrelaCheia = (int) Math.floor(media);
        var estrelaMetade = media - Math.floor(media);

        estrelaDto.setQtdEstrelaCheia(this.retornarArray(estrelaCheia));
        estrelaDto.setQtdEstrelaMetade(this.retornarArray(estrelaMetade == 0.00 ? 0 : 1));
        estrelaDto.setQtdEstrelaVazia(this.retornarArray( estrelaCheia < 1 && estrelaMetade <= 0 ? 5 : 4 - estrelaCheia));

        return estrelaDto;
    }

    private List<Integer> retornarArray(Integer n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }

        return array;
    }
    public void cadastrarFilmeAvaliacao(FilmeAvaliacao filmeAvaliacao) {
        filmeAvaliacaoRepository.save(filmeAvaliacao);
    }
}
