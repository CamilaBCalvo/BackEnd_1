package com.Clase14_Video1;

public class Main {
    public static void main(String[] args) {

        //vinculacion dinamica
        Cuenta cuenta = new CuentaCajaAhorro();
        cuenta.setSaldo(1000);
        cuenta.extraer(500);
        //polimorfismo
        cuenta.extraer(1100);

        Cuenta cuenta2 = new CuentaCorriente();
        cuenta2.setSaldo(cuenta.getSaldo());
        cuenta = cuenta2;

        cuenta.extraer(1100);
        System.out.println(cuenta.getSaldo());

        Cuenta cuenta3 = new Cuenta();
        cuenta3.setSaldo(2000);
        cuenta3.setNumero(1101);
        //como lo que instanciamos es una cuenta, tenemos que definir la estrategia que esa cuenta va a tener
        cuenta3.setEstrategia(new EstrategiaCajaAhorro());

        cuenta3.extraer(2100);

        cuenta3.setEstrategia(new EstrategiaCuentaCorriente());
        cuenta3.extraer(2100);

        System.out.println(cuenta3.getSaldo());

    }
}
