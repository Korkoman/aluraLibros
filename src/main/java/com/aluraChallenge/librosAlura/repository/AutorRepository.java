package com.aluraChallenge.librosAlura.repository;

import com.aluraChallenge.librosAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
