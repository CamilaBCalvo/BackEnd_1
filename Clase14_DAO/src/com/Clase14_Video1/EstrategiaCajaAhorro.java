package com.Clase14_Video1;

public class EstrategiaCajaAhorro implements EstrategiaExtraccion{
    @Override
    public boolean extraer(Cuenta cuenta, double monto) {
        boolean resultado = false;
        if (cuenta.getNumero() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            resultado=true;
        };
        return resultado;
    }
}
