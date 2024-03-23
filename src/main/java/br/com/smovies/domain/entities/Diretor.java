package br.com.smovies.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "diretor")
@Data
public class Diretor {
    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private Pais pais;
}
