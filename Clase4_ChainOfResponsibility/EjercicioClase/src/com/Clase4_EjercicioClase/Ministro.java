package com.Clase4_EjercicioClase;

public class Ministro extends FileHandler {


    @Override
    public void process(String contenido, int tipo) {
        if (tipo==1||tipo==2){
            System.out.println("Usted es ministro tiene categoria para leer el siguiente documento: " + contenido);
            getNext(next).process(contenido,tipo);
        }else if (tipo==3){
            System.out.println("Usted es ministro y no tiene suficiente categoria para leer este contenido.");
            getNext(next).process(contenido,tipo);
        }else {
            System.out.println("Ese no es ningun tipo de documento. Numero erroneo.");
        }
    }
}
