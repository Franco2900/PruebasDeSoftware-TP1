package test;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import copControl.Nivel;
import copControl.Mapa;
import copControl.Posicion;
import copControl.Dificultad;

import pista.Pista;
import pista.PistaLarga;
import pista.PistaSimple;

import avion.AvionSimple;
import avion.Helicoptero;

public class NivelTest {

	private Nivel nivel;
	private Nivel nivel2;
	
	@Before
	public void setUp() 
	{
		try 
		{
			PistaLarga  pistaLarga  = new PistaLarga (new Posicion(0  , 0) );
			PistaSimple pistaSimple = new PistaSimple(new Posicion(200, 0) );
			List<Pista> pistas      = new ArrayList<Pista>();
			pistas.add(pistaSimple);
			pistas.add(pistaLarga);
			
			Mapa mapa = new Mapa(pistas);
			AvionSimple avionSimple = new AvionSimple(new Posicion(0, 0)  , new Posicion(0, 0), mapa);
			Helicoptero helicoptero = new Helicoptero(new Posicion(200, 0), new Posicion(200, 0), mapa);
			mapa.colocarAvionEnAire(avionSimple);
			mapa.colocarAvionEnAire(helicoptero);
			
			Mapa mapa2 = new Mapa(pistas);
			AvionSimple avionSimple2 = new AvionSimple(new Posicion(300, 300)  , new Posicion(0, 0), mapa2);
			AvionSimple avionSimple3 = new AvionSimple(new Posicion(300, 300)  , new Posicion(0, 0), mapa2);
			mapa2.colocarAvionEnAire(avionSimple2);
			mapa2.colocarAvionEnAire(avionSimple3);
			
			Dificultad dificultad = new Dificultad(2, 5, 5);
			
			nivel  = new Nivel(mapa , dificultad);
			nivel2 = new Nivel(mapa2, dificultad);
		}
		catch(Exception e) 
		{
			System.out.println(e.toString() );
		}
		
	}
	
	@Test
	public void testAterrizarAviones()
	{
		// Se prueba se aterrizan todos los aviones para los cuales hay pistas disponibles
		// El helicoptero no debería aterrizar porque no hay un helipuerto
		assertTrue("Fallo - Debería aterrizar solo el avion simple", nivel.aterrizarAviones() == 1);
	}
	
	@Test
	public void testHuboChoque() 
	{
		// Se prueba si detecta un choque cuando se pone a dos aviones en la misma posición
		assertTrue("Fallo - No se detecto el choque de los aviones", nivel2.huboChoque() );
	}
}
