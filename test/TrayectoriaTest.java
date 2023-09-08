package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import copControl.Mapa;
import copControl.Trayectoria;
import copControl.Posicion;

public class TrayectoriaTest {

	private Trayectoria trayectoria;
	
	@Before
	public void setUp() 
	{
		trayectoria = new Trayectoria(new Posicion(0, 0), new Mapa() );
	}
	
	@Test
	public void testAvanzar() 
	{
		// Pruebo si al ejecutar el método avanzar con una trayectoria sin destino, se genera un nuevo destino para la trayectoria o queda estancada
		trayectoria.avanzar();
		assertNotNull("Fallo - El destino de la trayectoria no cambio", trayectoria.getDestinoActual() );
	}
	
}