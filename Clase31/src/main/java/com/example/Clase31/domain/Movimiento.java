package com.example.Clase31.domain;

import javax.persistence.*;

@Entity
@Table(name = "movimientos") //Le podemos agregar el nombre de la tabla
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Aca le decimos que el Id va a ser autoincrement
    private Long id;
    @Column
    private String descripcion;
    @Column
    private Double moto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMoto() {
        return moto;
    }

    public void setMoto(Double moto) {
        this.moto = moto;
    }
}
