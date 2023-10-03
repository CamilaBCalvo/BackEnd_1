package com.Clase4_EjercicioMesa;

public class Peso extends ProductoHandler{

        @Override
        public void procesar(String nombre, int lote, int peso, String envasado) {
            boolean p = (peso>1200 && peso<3000);
            boolean l = (lote>1000 && lote<2000);

            if (p) {
                getNext(next).procesar(nombre, lote, peso, envasado);
            }else if(l == false && p == false){
                System.out.println("El "+ nombre +" fue RECHAZADO");
            }else {
                getNext(next).procesar(nombre, lote, peso, envasado);
            }
        }
}
