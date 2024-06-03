package com.aluraChallenge.librosAlura.repository;

import com.aluraChallenge.librosAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
