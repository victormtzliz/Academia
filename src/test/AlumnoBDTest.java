package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bd.AlumnoBD;
import bd.GestorBD;

/**
 * Esta clase testea la clase AlumnoBD
 * 
 * @author Alumno
 *
 */
public class AlumnoBDTest {

	private GestorBD gestorBD = null;

	/**
	 * Inicializamos la clase que queremos testear
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		gestorBD = new GestorBD("Academy.db");
		gestorBD.conectarBD();
	}

	/**
	 * Nos indica que ocurrira despues de hacer el testeo
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {
		gestorBD.desconectarBD();
	}

	// @Test
	// public void test() throws SQLException{
	// AlumnoBD.crearTablaAlumno(gestorBD.getCon());
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testInsertarAlumno(){
	// AlumnoBD.crearTablaAlumno(gestorBD.getCon());
	// ArrayList<String> clase = new ArrayList<>();
	// clase.add("Matematicas");
	// clase.add("Quimica");
	// clase.add("Fisica");
	// ArrayList
	//

	// }

}
