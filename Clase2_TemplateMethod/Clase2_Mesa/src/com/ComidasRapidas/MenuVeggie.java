package com.ComidasRapidas;

public class MenuVeggie extends Menu{

    boolean especias;

    public MenuVeggie(boolean especias) {
        this.especias = especias;
    }

    public Double sumaEspecias(){
        if(especias){
          return precioBase + 2.0;
      }else {
          return precioBase;
      }
    };

    @Override
    public Double sumarPrecio() {
        return this.sumaEspecias() * 1.1 ;
    }
}
