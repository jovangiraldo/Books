package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title")
                         String title,
                         @JsonAlias("authors") List<DatosAutores> Autores,
                         @JsonAlias("languages") List<String>idiomas,
                         @JsonAlias("download_count")  Double numeroDeDescargas){

}
