package com.aluraChallenge.librosAlura.principal;

import com.aluraChallenge.librosAlura.model.Autor;
import com.aluraChallenge.librosAlura.model.DatosLibro;
import com.aluraChallenge.librosAlura.model.DatosResultados;
import com.aluraChallenge.librosAlura.model.Libro;
import com.aluraChallenge.librosAlura.repository.AutorRepository;
import com.aluraChallenge.librosAlura.repository.LibroRepository;
import com.aluraChallenge.librosAlura.service.ConsumoApi;
import com.aluraChallenge.librosAlura.service.ConvierteDatos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Registro {
    private Scanner teclado = new Scanner(System.in);
    private String url = "https://gutendex.com/books/?search=";

    public Registro() {
        this.repository = repository;

    }
    @Autowired
    private LibroRepository repository;


    @Transactional
    public void registraLibro(LibroRepository repository){

        ConsumoApi consumoApi = new ConsumoApi();
        ConvierteDatos convierteDatos = new ConvierteDatos();
        System.out.println("Ingrese el nombre del libro a consultar");
        String consulta = teclado.nextLine();
        String json = consumoApi.obtenerDatos(url + consulta.replace(" ","+"));
        var datos = convierteDatos.obtenerDatos(json, DatosResultados.class);
        Set<DatosLibro> resultados = datos.libros().stream().map(e -> new DatosLibro(e.id(),e.titulo(),e.autor(),e.idioma())).collect(Collectors.toSet());
        List<Libro> libros = resultados.stream().map(e -> new Libro(e)).collect(Collectors.toList());
        Optional<Libro> coso = libros.stream().filter(e -> e.getNombre().equalsIgnoreCase(consulta)).findAny();

        if (coso.isPresent()){
            Libro libro = coso.get();
            libro.setAutorEnt(resultados.stream().map(e -> new Autor(e.autor().get(0))).collect(Collectors.toList()).get(0));
            repository.save(coso.get());
        }else{
            System.out.println("Libro no encontrado");
        }


    }
}
