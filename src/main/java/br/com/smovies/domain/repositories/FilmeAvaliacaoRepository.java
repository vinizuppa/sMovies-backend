package br.com.smovies.domain.repositories;

import br.com.smovies.domain.entities.FilmeAvaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeAvaliacaoRepository extends MongoRepository<FilmeAvaliacao, String> {
    List<FilmeAvaliacao> findByFilmeId(String filmeId);
}
