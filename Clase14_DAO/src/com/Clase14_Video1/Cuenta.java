package com.Clase14_Video1;

public  class Cuenta {
    private int numero;
    private double saldo;
    private EstrategiaExtraccion estrategia;

    public void setEstrategia(EstrategiaExtraccion estrategia) {
        this.estrategia = estrategia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean extraer(double monto){
        //al dejar de ser abstracta el metodo extraer va a delegarle al responsabilidad a "estrategia"
        return estrategia.extraer(this,monto);
    };
}
