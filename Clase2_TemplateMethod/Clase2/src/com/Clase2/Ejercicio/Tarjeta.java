package com.Clase2.Ejercicio;

import java.util.Date;

public abstract class Tarjeta {
    private Integer numFrente;
    private int codigoSeguridad;
    private Date fechaExpiracion;
    private String tipoTarjeta;

    public Tarjeta(Integer numFrente, int codigoSeguridad, Date fechaExpiracion, String tipoTarjeta) {
        this.numFrente = numFrente;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
        this.tipoTarjeta = tipoTarjeta;
    }

    public Integer getNumFrente() {
        return numFrente;
    }

    public void setNumFrente(Integer numFrente) {
        this.numFrente = numFrente;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    protected abstract void pedirAutorizacion(int r);
    protected abstract boolean checkFecha(Date today);
}
