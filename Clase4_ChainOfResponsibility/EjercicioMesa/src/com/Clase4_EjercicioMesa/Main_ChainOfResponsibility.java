package com.Clase4_EjercicioMesa;

public class Main_ChainOfResponsibility {
    public static void main(String[] args) {

        ProductoHandler lote = new Lote();
        ProductoHandler peso = new Peso();
        ProductoHandler envase = new Envase();
        lote.setNext(peso);
        peso.setNext(envase);

        lote.procesar("Paquete1",1050,1250,"sano");
        System.out.println("-------");
        lote.procesar("Paquete2",1250,135000,"no sano");
        System.out.println("-------");
        lote.procesar("Paquete3",10,1150,"casi sano");

    }


}
