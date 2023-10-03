package com.Clase19_Serializacion.clase;

import java.io.Serializable;

public class Can implements Serializable {
    private String nombre;
    private Integer edad;

    public Can(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Can{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
