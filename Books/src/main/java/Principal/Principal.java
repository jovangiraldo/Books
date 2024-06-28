package Principal;

import models.Datos;
import models.DatosLibro;
import service.ConsumoApi;
import service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner entrada = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private  final  String URL_BASE = "https://gutendex.com/books/?search=";
    private  final  String API_KEY = "";
    private ConvierteDatos  convierteDatos = new ConvierteDatos();


    public void MuestraMenu(){

        var json = consumoApi.obtenerDatos(URL_BASE);
      //  System.out.println(json);

        var Datos = convierteDatos.ObtenerDatos(json,Datos.class);


        // top 10 libros mas descargados
        System.out.println("10 Libros mas descargados");

        Datos.resultados().
                stream().
                sorted(Comparator.comparing(DatosLibro::numeroDeDescargas).
                        reversed()).
                limit(10).map(e -> e.title().toUpperCase()).
                forEach(System.out::println);


        //Busqueda por nombre

        System.out.println("Escribe el nombre del libro que deseas buscar");
        var NombreLibro = entrada.nextLine();
         json = consumoApi.obtenerDatos(URL_BASE+NombreLibro.replace(" ","+"));
         var DatosB = convierteDatos.ObtenerDatos(json, models.Datos.class);

        Optional<DatosLibro> datosLibro = DatosB.resultados().
                stream().
                filter(e -> e.title().toUpperCase().
                        contains(NombreLibro.toUpperCase())).findFirst();

        if (datosLibro.isPresent()){
            System.out.println("libro encontrado");
            System.out.println(datosLibro.get());
        }else{
            System.out.println("Libro no encontrado");

        }

        //Estadisticas


        DoubleSummaryStatistics est  = DatosB.resultados().
                stream().filter(l -> l.numeroDeDescargas() > 0.0).
                collect(Collectors.
                        summarizingDouble(DatosLibro::numeroDeDescargas));

        System.out.println("Numero media de descargas "+ est.getAverage());
        System.out.println("Numero max de descargas "+ est.getMax());
        System.out.println("Numero min de descargas "+ est.getMin());
        System.out.println("Numero evaluados de descargas "+ est.getCount());










    }


}
