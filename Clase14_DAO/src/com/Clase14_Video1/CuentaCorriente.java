package com.Clase14_Video1;

public class CuentaCorriente extends Cuenta{

    @Override
    public boolean extraer(double monto) {
        setSaldo(getSaldo() - monto);
        return true;
    }
}
