import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class geometria {
	
	private Geometria g;
	
	@Before
	public void setUp() throws Exception {
		g = new Geometria();
	}

	@Test
	public void testCuadrado() {
		int resultado = g.areacuadrado(4);
		int expected = 16;
		assertEquals(expected, resultado);
	}
	
	@Test
	public void testFigura() {
		String resultado = g.figura(6);
		String expected = "Rombo";
		assertEquals(expected, resultado);
	}
	
	@Test
	public void testRectangulo() {
		int resultado = g.arearectangulo(10, 5);
		int expected = 50;
		assertEquals(expected, resultado);
	}

}