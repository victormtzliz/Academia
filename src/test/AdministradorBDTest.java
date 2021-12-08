package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bd.AdministradorBD;
import bd.GestorBD;
import logneg.Administrador;

public class AdministradorBDTest {
	GestorBD gestor;

	/**
	 * Inicializamos la clase que queremos testear mediante este metodo.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		gestor = new GestorBD("Academy.db");
		gestor.conectarBD();
	}

	/**
	 * Indicamos que hacer despues del testeo de la clase
	 * 
	 * @throws Exception
	 */

	@After
	public void tearDown() throws Exception {

		gestor.desconectarBD();
	}

	/**
	 * Este metodo es el rimer test
	 * 
	 * @throws SQLException
	 */

	@Test
	public void test1() throws SQLException {
		AdministradorBD.insertarAdministrador(gestor.getCon(), "11111111S", "juangarcia@academy.es", "Juan Garcia",
				"juanAcademy");
		fail("Error con la tabla Administrador");
	}

	/**
	 * Mediante este metodo testeamos al hacer un insert
	 * 
	 * @throws SQLException
	 */

	@Test
	public void test2() throws SQLException {
		AdministradorBD.crearTablaAdministrador(gestor.getCon());
		AdministradorBD.insertarAdministrador(gestor.getCon(), "12121212Z", "jg@academy.es", "Juan", "juangarcia");
		ArrayList<Administrador> beenRead = AdministradorBD.todosLosAdmins(gestor.getCon());
		for (Administrador admin : beenRead) {
			if (admin.getDniTrabajadorAcademia().equals("12121212Z")) {
				assertEquals(admin.getContrasenyaAdministrador(), "juangarcia");
				assertEquals(admin.getEmailTrabajadorAcademia(), "jg@academy.es");
				assertEquals(admin.getNombreAdministrador(), "Juan");
			}
		}
	}

	/**
	 * Hacemos un test de select con este metodo
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test3() throws SQLException {
		AdministradorBD.crearTablaAdministrador(gestor.getCon());
		AdministradorBD.insertarAdministrador(gestor.getCon(), "12121212Z", "jg@academy.es", "Juan", "juangarcia");
		ArrayList<Administrador> beenRead = AdministradorBD.todosLosAdmins(gestor.getCon());
		for (Administrador admin : beenRead) {
			if (admin.getDniTrabajadorAcademia().equals("13121312Z")) {
				assertEquals(admin.getContrasenyaAdministrador(), "juang");
				assertEquals(admin.getEmailTrabajadorAcademia(), "jj@academy.es");
				assertEquals(admin.getNombreAdministrador(), "Juanito");

			}
		}

	}
}
