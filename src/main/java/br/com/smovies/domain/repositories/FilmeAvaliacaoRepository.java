package br.com.smovies.domain.repositories;

import br.com.smovies.domain.entities.Filme;
import br.com.smovies.domain.entities.FilmeAvaliacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeAvaliacaoRepository extends MongoRepository<FilmeAvaliacao, String> {
    List<FilmeAvaliacao> findByFilmeId(String filmeId);

    @Query("{ 'filmeId': ?0}")
    Page<FilmeAvaliacao> findAllByFilmeId(String filmeId, Pageable pageable);
}
