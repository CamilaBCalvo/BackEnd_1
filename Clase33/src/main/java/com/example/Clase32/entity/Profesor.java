package com.example.Clase32.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String titulo;
    @OneToMany(mappedBy = "profesor") // es el nombre del atributo del join en la otra tabla
    private Set<Alumno> alumnos = new HashSet<>();
}
