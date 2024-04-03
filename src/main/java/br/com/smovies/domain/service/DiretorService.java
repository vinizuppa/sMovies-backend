package br.com.smovies.domain.service;

import br.com.smovies.domain.entities.Diretor;
import br.com.smovies.domain.repositories.DiretorRepository;
import br.com.smovies.rest.dtos.diretor.DiretorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private PaisService paisService;

    public List<DiretorResponseDto> buscarDiretores() {
        var diretorList = diretorRepository.findAll();
        List<DiretorResponseDto> diretorResponseDtoList = new ArrayList<>();

        diretorList.forEach(diretor -> {
            var diretorResponseDto = new DiretorResponseDto();
            diretorResponseDto.setId(diretor.getId());
            diretorResponseDto.setNomeDiretor(diretor.getNome());
            diretorResponseDto.setSiglaPais(paisService.buscarNomePaisPeloId(diretor.getPaisId()));

            diretorResponseDtoList.add(diretorResponseDto);
        });

        return diretorResponseDtoList;
    }

    public Diretor buscarDiretorPorId(String diretorId) {
        var diretor = diretorRepository.findById(diretorId);

        if (diretor.isPresent()) {
            return diretor.get();
        }

        return null;
    }
}
