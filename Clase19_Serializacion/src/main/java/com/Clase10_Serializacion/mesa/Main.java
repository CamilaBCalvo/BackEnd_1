package com.Clase10_Serializacion.mesa;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// 1. Preparar la coleccion de cannes

        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Juan","Perez",43214321));
        contactos.add(new Contacto("Ana","Garcia",45678905));
        contactos.add(new Contacto("Jose","Gonzalez",48769876));
        contactos.add(new Contacto("Emma","Pereyra",43236765));
        contactos.add(new Contacto("Roberto","Rodriguez",40980912));
        contactos.add(new Contacto("Cecilia","Suarez",45446876));

// 2. Guardar archivo

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("ContactosArchivo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactos);
            oos.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

// 3. Recuperar datos del archivo

        List<Contacto> ContactosArchivos = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("ContactosArchivo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ContactosArchivos = (List<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//Hay que castearlo como un ArrayList

        for(Contacto contacto:ContactosArchivos){
            System.out.println(contacto);
        }
    }
}

