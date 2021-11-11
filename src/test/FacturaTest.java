package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logneg.Factura;

/**
 * En esta clase testearemos algunos metodos de la clase Factura
 * @author Anton
 * @author Victor
 *
 */
public class FacturaTest {
	
	Factura factura1;
	Factura factura2;
	
	/**
	 * Inicializamos la clase a testear
	 * @throws Exception
	 */

	@Before
	public void setUp(){
		factura1 = new Factura(10, 5);
		factura2 = new Factura(12, 3);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * Metodo para testear los getters de la clase Factura
	 * Devolvera los atributos pedidos
	 */
	@Test
	public void testGetters() {
		assertEquals(10, factura1.getPrecio());
		assertEquals(5, factura1.getNumeroCompraClase());
		
		assertEquals(12, factura2.getPrecio());
		assertEquals(3, factura2.getNumeroCompraClase());
	}
	/**
	 * Metodo para testear los setters de la clase Factura
	 * Modificara los valores y vera si se han actualizado correctamente
	 */
	@Test
	public void testSetters(){
		factura1.setPrecio(15);
		factura1.setNumeroCompraClase(4);
		assertEquals(15, factura1.getPrecio());
		assertEquals(4, factura1.getNumeroCompraClase());
		
		factura2.setPrecio(8);
		factura2.setNumeroCompraClase(2);
		assertEquals(8, factura2.getPrecio());
		assertEquals(2, factura2.getNumeroCompraClase());
	}
	

}
