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

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    Registro registro = new Registro();
    LibroRepository repository;
public void menu(LibroRepository repository){
    this.repository = repository;


    System.out.println("""
            Elija la opción a través de su número
            
            
            1- Buscar libro por título
            2- Listar libros registrados
            3- Listar autores registrados
            4- Listar autores vivos en un determinado año
            5- Listar libros por idioma
            0- Salir
            """);
    String opcion = teclado.next();

    switch (opcion){
        case "1":
            registro.registraLibro(repository);
            System.out.println("""
                                  Quiere realizar otra consulta?
                                  1- Sí
                                  2- No
                                  """);
            if (teclado.next().equalsIgnoreCase("1")){
                menu(repository);
            }else{
                System.out.println("Hasta pronto");
            }
            break;
        default:
            System.out.println(opcion + " no es una opción válida. Intente de nuevo");
            break;
    }


}
}
