package Clase1.Mesa;

public class Cuadrado {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea (double lado) {
        return lado * lado;
    }
}
