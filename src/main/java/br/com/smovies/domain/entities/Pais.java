package br.com.smovies.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "pais")
@Data
public class Pais implements Serializable {
    @Id
    private String id;
    private String nomeCompleto;
    private String sigla;
}
