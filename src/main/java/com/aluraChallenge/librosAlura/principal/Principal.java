package com.aluraChallenge.librosAlura.principal;

import com.aluraChallenge.librosAlura.repository.LibroRepository;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private final Registro registro = new Registro();

public void menu(LibroRepository repository){
    System.out.println("""
      ****** Bienvenidos a Alura Libros **********
            
            Elija la opción a través de su número ☻
            
            
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

        case "2":
            registro.listaDeLibros(repository).forEach(e -> System.out.println(e.toString()));
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

        case "3":
            registro.listaAutores(repository).forEach(e -> System.out.println(e.toString()));
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
        case "4":
            registro.listaAutoresVivos(repository).forEach(e -> System.out.println("Nombre: " + e));
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
        case "5":
            registro.librosPorIdioma(repository).forEach(System.out::println);
            break;
        default:
            System.out.println(opcion + " no es una opción válida. Intente de nuevo");
            break;
    }
  }
}
