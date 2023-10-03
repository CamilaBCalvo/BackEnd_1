package com.Clase4_EjercicioClase;

import java.util.logging.Handler;

public class Presidente extends FileHandler {

    @Override
    public void process(String contenido, int tipo) {
        if (tipo==1 || tipo==2 || tipo==3){
            System.out.println("Usted es presidente y tiene categoria para leer el siguiente documento: "+contenido);
        }else{
            System.out.println("Ese no es ningun tipo de documento. Numero erroneo.");
        }
}}
