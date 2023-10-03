package Clase1.Mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FigurasTest {

    @Test

    public void calculoFiguras(){
        Cuadrado cuadrado = new Cuadrado(5);
        Circulo circulo = new Circulo(20);

        Assertions.assertEquals(25,cuadrado.calcularArea(cuadrado.getLado()));
        Assertions.assertEquals(1256,circulo.calcularArea(circulo.getRadio()));
        //El circulo da con error porque no redondea el numero

    }

}
