package br.com.smovies.domain.repositories;

import br.com.smovies.domain.entities.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends MongoRepository<Filme, String> {
    Page<Filme> findAll(Pageable pageable);
}
