package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bd.GestorBD;

public class GestorBDTest {

	GestorBD gestorBD;

	/**
	 * Inicializamos con este metodo la clase que queremos testear
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		gestorBD = new GestorBD("Academia.bd");
		gestorBD.crearBase("Academia.bd");
		gestorBD.conectarBD();
	}

	@After
	public void tearDown() throws Exception {
		gestorBD.desconectarBD();
	}

	/**
	 * Testea la clase GestorBD
	 */

	@Test
	public void testGestor() {
		fail("Not yet implemented");
	}

}
