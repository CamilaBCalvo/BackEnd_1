package Clase1.Mesa;

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularArea (double radio) {
        this.radio = radio;
        return Math.PI * (radio * radio);
    }
}
