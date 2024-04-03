package br.com.smovies.domain.service;

import br.com.smovies.domain.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public String buscarNomePaisPeloId(String paisId) {
        var pais = paisRepository.findById(paisId);

        if (pais.isPresent()) {
            return pais.get().getNomeCompleto();
        }
        return "";
    }
}
