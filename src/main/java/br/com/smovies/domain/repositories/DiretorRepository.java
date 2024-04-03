package br.com.smovies.domain.repositories;

import br.com.smovies.domain.entities.Diretor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends MongoRepository<Diretor, String> {
    List<Diretor> findAll();
}
