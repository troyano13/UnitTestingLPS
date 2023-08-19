package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Cuadrado;

public class CuadradoTest {

	@Test
	public void testCalcularAreaCuadrado() {
		double lado = 5.0;
		double areaEsperada = 25.0;

		double resultado = Cuadrado.calcularAreaCuadrado(lado);

		assertEquals(areaEsperada, resultado, 0.0001);
	}
}
