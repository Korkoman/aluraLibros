package com.aluraChallenge.librosAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosIdioma(
        String idioma
) {
    public static DatosIdioma fromString(String idioma) {
        return new DatosIdioma(idioma);
    }
}
