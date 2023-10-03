package com.Clase10.ejercicioClase;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    //Esta linea cuando uses logger va a ser siempre igual, solo cambia el nombre de la clase, en este caso "App".
    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        this.listaEnteros = new ArrayList<>();
    }
    public void agregarEntero(Integer num){
        listaEnteros.add(num);
        // Al hacerlos separados va a darme los dos en el caso de un 11 por ejemplo.
        if(listaEnteros.size()>5){
            logger.info("La longitud de la lista es mayor a 5");
        }
        if (listaEnteros.size()>10){
            logger.info("La longitud de la lista es mayor a 10");
        }
    }
    public void igualCero(){
        if (listaEnteros.size()==0){
            logger.error("La lista es igual a cero");
        }
    }
    public void promediar(List<Integer> listaEnteros){
        Integer acumulador = 0;
        Integer suma = 0;
        for (Integer num : listaEnteros) {
            suma = (acumulador + num);
        };
        Integer total = suma / listaEnteros.size();
        logger.info("El promedio es: "+ total);
    }
}
