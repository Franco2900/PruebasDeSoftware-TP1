package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import copControl.Posicion;

public class PosicionTest {

	private Posicion posicion1;
	private Posicion posicion2;
	
	@Before
	public void setUp() 
	{
		posicion1  = new Posicion(0  , 0);
		posicion2  = new Posicion(100, 0);
	}
	
	@Test
	public void testerDistanciaHasta() 
	{
		// Calculo la distancia manualmente
		double px				 = posicion2.getCoordenadaX() - posicion1.getCoordenadaX();
		double py 				 = posicion2.getCoordenadaY() - posicion1.getCoordenadaY();
		double distanciaEsperada = Math.sqrt(px * px + py * py);
		
		// Pruebo si el resultado que devuelve el método es el correcto
		assertTrue("Fallo - No estan bien calculadas las distancias entre las posiciones", 
				   distanciaEsperada == posicion1.distanciaHasta(posicion2));
	}
	
}
