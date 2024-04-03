package br.com.smovies.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "filme")
@Data
public class Filme implements Serializable {
    @Id
    private String id;
    private String nomeCompleto;
    private String sinopse;
    private String urlImagemCapa;
    private LocalDate dataLancamento;
    private String diretorId;
}
