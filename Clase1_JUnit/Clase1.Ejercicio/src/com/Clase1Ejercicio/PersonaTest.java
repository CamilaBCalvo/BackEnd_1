package com.Clase1Ejercicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersonaTest {
    @Test
    public void checkEdad(){
        Persona persona1 = new Persona("Juan","Perez","juan@yahoo.com",34);
        Persona persona2 = new Persona("Ana","Gonzalez","ana@yahoo.com",26);
        Persona persona3 = new Persona("Maria","Suarez","maria@yahoo.com",16);
        Persona persona4 = new Persona("Pedro","Garcia","pedro@yahoo.com",13);

        boolean esMayorDeEdad1 = persona1.esMayorDe18();
        boolean esMayorDeEdad2 = persona2.esMayorDe18();
        boolean esMayorDeEdad3 = persona3.esMayorDe18();
        boolean esMayorDeEdad4 = persona4.esMayorDe18();

        assertEquals(true, persona1.esMayorDe18());
        assertFalse(esMayorDeEdad3);
        assertEquals(true, persona2.esMayorDe18());
        assertFalse(esMayorDeEdad4);
    }

    @Test
    public void checkNombre(){
        Persona persona1 = new Persona("Juan","Perez","juan@yahoo.com",34);
        Persona persona2 = new Persona("Ana","Gonzalez","ana@yahoo.com",26);
        Persona persona3 = new Persona("Maria","Suarez","maria@yahoo.com",16);
        Persona persona4 = new Persona("Pedro","Garcia","pedro@yahoo.com",13);

        String checkNombre1 = persona1.mostrarNombreCompleto();
        String checkNombre2 = persona2.mostrarNombreCompleto();
        String checkNombre3 = persona3.mostrarNombreCompleto();
        String checkNombre4 = persona4.mostrarNombreCompleto();

        assertEquals("Juan Perez", persona1.mostrarNombreCompleto());
        assertEquals("Ana Gonzalez", persona2.mostrarNombreCompleto());
        assertEquals("Maria Suarez", persona3.mostrarNombreCompleto());
        assertEquals("Pedro Garcia", persona4.mostrarNombreCompleto());


    }
}
