package com.aluraChallenge.librosAlura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private String idioma;
    @JoinColumn(name= "autor_id")
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Autor autorEnt;

    public Libro() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(autorEnt, libro.autorEnt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(autorEnt);
    }

    public Libro(DatosLibro datosLibro) {
        this.id = datosLibro.id();
        this.nombre = datosLibro.titulo();
        this.autor = datosLibro.autor().get(0).nombre();
        this.idioma = datosLibro.idioma().get(0).idioma();
    }

    public Autor getAutorEnt() {
        return autorEnt;
    }

    public void setAutorEnt(Autor autorEnt) {
        this.autorEnt = autorEnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }



    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                "'";
    }
}
