
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ejercicio1 {
	
	@Test
	public void testFactorial() {
		int resultado = Calculadora.factorial(5);
		int expected = 120;
		assertEquals(resultado, expected);
	}
	
	@Test
	public void testEsEntero() {
		boolean resultado = Calculadora.esEntero("56");
		boolean expected = true;
		assertEquals(resultado, expected);
	}
	
	@Test
	public void testOperar() {
		double resultado = Calculadora.operar(3, 10, "*");
		double expected = 30;
		double delta = 1;
		assertEquals(expected, resultado, delta);
	}

}