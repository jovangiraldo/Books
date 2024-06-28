package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutores(@JsonAlias("name") String name,
                           @JsonAlias("birth_year") Integer fechaNaciento)
                            {
}
