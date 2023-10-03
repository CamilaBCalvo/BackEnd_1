package com.Clase2.Ejercicio.impl;

import com.Clase2.Ejercicio.Tarjeta;

import java.util.Date;

public class TarjetaCredito extends Tarjeta {

    private int limite;
    private int saldoUtilizado;

    public TarjetaCredito(Integer numFrente, int codigoSeguridad, Date fechaExpiracion, String tipoTarjeta) {
        super(numFrente, codigoSeguridad, fechaExpiracion, tipoTarjeta);
    }

    @Override
    protected void pedirAutorizacion(int r) {
        if (this.limite > r){
            System.out.println("Retiro autorizado. Usted retira $"+r);
        }else {
            System.out.println("El retiro no fue autorizado, ya que excede el limite posible para retiro.");
    }}

    @Override
    protected boolean checkFecha(Date today) {
        return false;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(int saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }


}
