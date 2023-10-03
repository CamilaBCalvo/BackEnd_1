package com.Clase4_EjercicioClase;

public class Diputado extends FileHandler {


    @Override
    public void process(String contenido, int tipo) {
        if (tipo==1){
            System.out.println("Usted es diputado y tiene categoria para leer el siguiente documento: " + contenido);
            getNext(next).process(contenido,tipo);
        }else if (tipo==2 || tipo==3){
            System.out.println("Usted es diputado y no tiene suficiente categoria para leer este contenido.");
            getNext(next).process(contenido,tipo);
        }else{
            System.out.println("Ese no es ningun tipo de documento. Numero erroneo.");
        }
    }
}
