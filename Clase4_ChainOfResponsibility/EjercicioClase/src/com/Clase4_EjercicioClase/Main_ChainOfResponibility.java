package com.Clase4_EjercicioClase;

public class Main_ChainOfResponibility {
    public static void main(String[] args) {

        FileHandler diputado = new Diputado();
        FileHandler ministro = new Ministro();
        FileHandler presidente = new Presidente();
        diputado.setNext(ministro);
        ministro.setNext(presidente);

        diputado.process("Lo leen los tres",1);
        diputado.process("Lo leen Min y Presi",2);
        diputado.process("Lo lee Presi",3);
        diputado.process(" ",4);

    }
}
