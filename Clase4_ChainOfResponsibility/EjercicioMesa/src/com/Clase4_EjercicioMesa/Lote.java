package com.Clase4_EjercicioMesa;

public class Lote extends ProductoHandler{

    @Override
    public void procesar(String nombre, int lote, int peso, String envasado) {
        boolean l = (lote>1000 && lote<2000);
        if (l) {
            getNext(next).procesar(nombre, lote, peso, envasado);
        }else{
            getNext(next).procesar(nombre, lote, peso, envasado);
        }
    }
}
