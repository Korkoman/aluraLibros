package com.aluraChallenge.librosAlura.model;

public class idioma {
    private String idioma;

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public idioma() {
    }

    public idioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "idioma{" +
                "idioma='" + idioma + '\'' +
                '}';
    }
}
