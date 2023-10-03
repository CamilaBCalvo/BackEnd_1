package com.Clase2.Ejercicio.impl;

import com.Clase2.Ejercicio.Tarjeta;

import java.util.Date;

public class TarjetaDebito extends Tarjeta {
    private int saldoDisponible;


    public TarjetaDebito(Integer numFrente, int codigoSeguridad, Date fechaExpiracion, String tipoTarjeta) {
        super(numFrente, codigoSeguridad, fechaExpiracion, tipoTarjeta);
    }

    @Override
    protected void pedirAutorizacion(int r) {
        if (this.saldoDisponible > r) {
            System.out.println("Retiro autorizado. Usted retira $"+r);
        }else {
            System.out.println("El retiro no fue autorizado, ya que excede el saldo disponible en su cuenta.");
        }}

    @Override
    protected boolean checkFecha(Date today) {
        return false;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public void procesadorDebito(){

    }

}


