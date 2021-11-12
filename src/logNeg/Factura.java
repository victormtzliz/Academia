package logneg;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase factura que se le pasa al alumno al comprar clases.
 * 
 * @author Anton y Victor.
 *
 */
public class Factura {
	private ArrayList<String> nombreClase;
	private Date dia;
	private int precio;
	private int numeroCompraClase;

	public Factura() {

	}

	/**
	 * Constructor de factura.
	 * 
	 * @param nombreClase
	 * @param dia
	 * @param precio
	 * @param numeroCompraClase
	 */
	public Factura(ArrayList<String> nombreClase, Date dia, int precio, int numeroCompraClase) {
		super();
		this.nombreClase = nombreClase;
		this.dia = dia;
		this.precio = precio;
		this.numeroCompraClase = numeroCompraClase;
	}

	/**
	 * Otro constructor de factura.
	 * 
	 * @param precio
	 * @param numeroCompraClase
	 */
	public Factura(int precio, int numeroCompraClase) {
		this.precio = precio;
		this.numeroCompraClase = numeroCompraClase;
	}

	/**
	 * Getter del nombreClase.
	 * 
	 * @return nombreClase.
	 */
	public ArrayList<String> getNombreClase() {
		return nombreClase;
	}

	/**
	 * Setter del nombreClase.
	 * 
	 * @param nombreClase.
	 */
	public void setNombreClase(ArrayList<String> nombreClase) {
		this.nombreClase = nombreClase;
	}

	/**
	 * Getter del dia.
	 * 
	 * @return dia.
	 */
	public Date getDia() {
		return dia;
	}

	/**
	 * Setter del dia.
	 * 
	 * @param dia.
	 */
	public void setDia(Date dia) {
		this.dia = dia;
	}

	/**
	 * Getter del precio.
	 * 
	 * @return precio.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Setter del precio.
	 * 
	 * @param precio.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Getter del numeroCompraClase.
	 * 
	 * @return numeroCompraClase.
	 */
	public int getNumeroCompraClase() {
		return numeroCompraClase;
	}

	/**
	 * Setter del numeroCompraClase.
	 * 
	 * @param numeroCompraClase.
	 */
	public void setNumeroCompraClase(int numeroCompraClase) {
		this.numeroCompraClase = numeroCompraClase;
	}

}
