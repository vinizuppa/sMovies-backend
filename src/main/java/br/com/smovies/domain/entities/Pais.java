package br.com.smovies.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pais")
@Data
public class Pais {
    @Id
    private String id;
    private String nomeCompleto;
    private String sigla;
}
