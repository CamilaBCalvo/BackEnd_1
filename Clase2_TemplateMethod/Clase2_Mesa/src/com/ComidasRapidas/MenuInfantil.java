package com.ComidasRapidas;

public class MenuInfantil extends Menu{

    Double cantidadJuguete;

    public MenuInfantil( Double cantidadJuguete) {
        this.cantidadJuguete = cantidadJuguete;
    }

    public MenuInfantil(Boolean juguete) {
        juguete = juguete;
    }

    public Double sumaJuguete(){
        if(cantidadJuguete > 0){
            return precioBase + (3.0 * cantidadJuguete);
        }else {
            return precioBase;
        }
    };

    @Override
    public Double sumarPrecio() {
        return this.sumaJuguete();
    }
}
