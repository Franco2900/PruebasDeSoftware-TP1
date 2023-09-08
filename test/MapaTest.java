package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import copControl.Mapa;
import copControl.Posicion;

public class MapaTest 
{

	private Mapa     mapa;
	private Posicion posicion;
	
	@Before 
	public void setUp() 
	{
		mapa = new Mapa();
	}
	
	@Test
	public void testGenerarPosicionExtremoAlAzar() 
	{	
		posicion = mapa.generarPosicionExtremoAlAzar();
		
		// Pruebo si la posición generada al azar esta entre las coodenadas 0 y las de la dimensión
		assertTrue("Fallo - Se generó una posición fuera de la dimension", 
				posicion.getCoordenadaX() >= 0 && 
				posicion.getCoordenadaY() >= 0 &&
				posicion.getCoordenadaX() <= mapa.getDimension() &&
				posicion.getCoordenadaY() <= mapa.getDimension() ); 
	}
	
	
	@Test
	public void testEsPosicionExtremo() 
	{
		posicion = new Posicion(200, 100000);
		System.out.println("Dimensión del mapa: " + mapa.getDimension() );
		
		// Se prueba si devuelve el valor correcto al poner de posición un valor que se sale de las dimensiones
		assertFalse("Fallo - Indica que una posición muy por fuera de la dimensión esta en una extremo de la dimensión", mapa.esPosicionExtremo(posicion) );
	}
	
}
