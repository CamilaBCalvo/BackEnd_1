package com.ComidasRapidas;

public abstract class Menu {

    Double precioBase = 10.0;

    public Double getPrecioBase() {
        return precioBase;
    }

    public abstract Double sumarPrecio ();

    public final void armarMenu(){
        consultarPedido();
        definirPrecio();
        prepararPedido();
        entregarPedido();
        System.out.println("Pedido entregado");
    }

    public void consultarPedido(){
        System.out.println("Que clase de Menu quiere?");
    }
    public void definirPrecio(){
        System.out.println("El precio de su pedido sera $"+ sumarPrecio());
    }
    public void prepararPedido(){
        System.out.println("Su pedido esta siendo preparado...");
    }
    public void entregarPedido(){
        System.out.println("Aqui esta su pedido. Gracias por confiar en nosotros!");
    }
}
