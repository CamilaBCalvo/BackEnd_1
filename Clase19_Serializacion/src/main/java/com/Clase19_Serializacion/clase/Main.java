package com.Clase19_Serializacion.clase;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

// 1. Preparar la coleccion de cannes
        List<Can> canes = new ArrayList<>();
        canes.add(new Can("Tommy", 4));
        canes.add(new Can("Lazaro", 3));
        canes.add(new Can("Pimpinela", 5));
        canes.add(new Can("Salem", 1));
        canes.add(new Can("Shaggy", 18));
        canes.add(new Can("Firulais", 25));
        canes.add(new Can("Moly", 16));
        canes.add(new Can("Toby", 5));
        canes.add(new Can("Blue", 2));
        canes.add(new Can("Luna", 13));
        canes.add(new Can("Cheta", 4));
        canes.add(new Can("Bruno", 4));
        canes.add(new Can("Jack", 2));

// 2. Guardar archivo
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("CanesSalvados.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(canes);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

// 3. Recuperar datos del archivo
        List<Can> canesSalvados = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("CanesSalvados.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            canesSalvados = (List<Can>) ois.readObject();

//Hay que castearlo como un ArrayList
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    // 4. Mostrar a los perritos
        for(
            Can can:canesSalvados){
                System.out.println(can);
        }
    }
}
