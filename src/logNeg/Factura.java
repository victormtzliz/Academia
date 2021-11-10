package logneg;

import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @author Alumno
 *
 */
public class Factura {
	private ArrayList<String> nombreClase;
	private Date dia;
	private int precio;
	private int numeroCompraClase;
	
	public Factura (){
		
	}

	public Factura(ArrayList<String> nombreClase, Date dia, int precio, int numeroCompraClase) {
		super();
		this.nombreClase = nombreClase;
		this.dia = dia;
		this.precio = precio;
		this.numeroCompraClase = numeroCompraClase;
	}
	public Factura(int precio, int numeroCompraClase){
		this.precio=precio;
		this.numeroCompraClase= numeroCompraClase;
	}

	public ArrayList<String> getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(ArrayList<String> nombreClase) {
		this.nombreClase = nombreClase;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getNumeroCompraClase() {
		return numeroCompraClase;
	}

	public void setNumeroCompraClase(int numeroCompraClase) {
		this.numeroCompraClase = numeroCompraClase;
	}
	

}
