package br.com.smovies.domain.repositories;

import br.com.smovies.domain.entities.Pais;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends MongoRepository<Pais, String> {
}
