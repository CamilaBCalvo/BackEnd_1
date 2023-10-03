package com.ComidasRapidas;


public class Main {
    public static void main(String[] args) {

        Menu menuClasico = new MenuClasico();
        menuClasico.armarMenu();

        Menu menuVeggie1 = new MenuVeggie(true);
        menuVeggie1.armarMenu();

        Menu menuVeggie2 = new MenuVeggie(false);
        menuVeggie2.armarMenu();

        Menu menuInfantil1 = new MenuInfantil(0.0);
        menuInfantil1.armarMenu();

        Menu menuInfantil2 = new MenuInfantil(1.0);
        menuInfantil2.armarMenu();

        Menu menuInfantil3 = new MenuInfantil(3.0);
        menuInfantil3.armarMenu();

    }
}