package br.com.smovies.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filmeAvaliacao")
@Data
public class FilmeAvaliacao {
    @Id
    private String id;
    private String usuarioId;
    private String filmeId;
    private Double nota;
    private String avaliacao;
}
