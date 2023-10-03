package com.Clase4_EjercicioClase;

public abstract class FileHandler {
    protected FileHandler next;

    public void setNext(FileHandler next){
        this.next = next;
    }
    public FileHandler getNext (FileHandler next){
        return this.next;
    }

    public abstract void process(String contenido, int tipo);

}
