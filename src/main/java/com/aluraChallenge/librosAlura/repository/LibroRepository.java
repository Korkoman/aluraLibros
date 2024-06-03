package com.aluraChallenge.librosAlura.repository;

import com.aluraChallenge.librosAlura.model.Autor;
import com.aluraChallenge.librosAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT s FROM Libro s")
    List<Libro> todosLosLibros();

    @Query("SELECT s FROM Autor s")
    List<Autor> todoLosAutores();

    @Query("SELECT s.nombre FROM Autor s WHERE s.fechaDeceso > :añoConsulta")
    List<String> autoresVivesAño(Integer añoConsulta);

    @Query("SELECT s FROM Libro s WHERE s.idioma = :idiomaConsulta")
    List<Libro> librosPorIdioma(String idiomaConsulta);
}
