package com.example.Clase32.entity;

import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
}
