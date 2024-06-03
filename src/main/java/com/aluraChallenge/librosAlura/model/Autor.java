package com.aluraChallenge.librosAlura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaDeceso;
    @OneToOne
    private Libro libro;

    public Autor() {
    }

    public Autor(DatosAutor datos) {
        this.nombre = datos.nombre();
        this.fechaNacimiento = datos.fechaNacimiento();
        this.fechaDeceso = datos.fechaDeceso();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(libro, autor.libro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libro);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeceso() {
        return fechaDeceso;
    }

    public void setFechaDeceso(Integer fechaDeceso) {
        this.fechaDeceso = fechaDeceso;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro){
        this.libro = libro;
    }

    @Override
    public String toString() {
        return """
                ***** Autor *****
                
                Nombre: %s
                Año de nacimiento: %s
                Año de muerte: %s                
                """.formatted(nombre,fechaNacimiento,fechaDeceso);
    }
}
