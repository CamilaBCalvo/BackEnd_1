package com.Clase4_EjercicioMesa;

public abstract class ProductoHandler {

    protected ProductoHandler next;

    //set next --> this.next = next
    public void setNext(ProductoHandler next){
        this.next = next;
    }

    //get next --> return this.next
    public ProductoHandler getNext(ProductoHandler next){
        return this.next;

    }
    //procesamiento
    public abstract void procesar(String nombre, int lote, int peso, String envasado);
}
