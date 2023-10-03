package com.Clase4_EjercicioMesa;

public class Envase extends ProductoHandler{
    @Override
    public void procesar(String nombre, int lote, int peso, String envasado) {
        boolean e = (envasado.equals("sano") || envasado.equals("casi sano"));
        boolean p = (peso>1200 && peso<3000);
        boolean l = (lote>1000 && lote<2000);

        if (e == true && p == true
                || e == true && l == true) {
            System.out.println("El "+ nombre +" fue ACEPTADO");
        }else{
            System.out.println("El "+ nombre +" fue RECHAZADO");
        }
    }


}
