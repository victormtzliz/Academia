package logneg;

import java.util.ArrayList;

/**
 * Clase Alumno de la academia.
 * 
 * @author Anton y Victor.
 *
 */
public class Alumno {
	private ArrayList<String> nombreClase;
	private String nombreAlumno;
	private String dniAlumno;
	private ArrayList<Integer> cantidadClasesSolicitadas;

	public Alumno() {

	}

	/**
	 * Constructor del Alumno.
	 * 
	 * @param nombreClase
	 * @param nombreAlumno
	 * @param dniAlumno
	 * @param cantidadClasesSolicitadas
	 */
	public Alumno(ArrayList<String> nombreClase, String nombreAlumno, String dniAlumno,
			ArrayList<Integer> cantidadClasesSolicitadas) {
		super();
		this.nombreClase = nombreClase;
		this.nombreAlumno = nombreAlumno;
		this.dniAlumno = dniAlumno;
		this.cantidadClasesSolicitadas = cantidadClasesSolicitadas;
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
	 * Getter del nombreAlumno.
	 * 
	 * @return nombreAlumno.
	 */
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	/**
	 * Setter del nombreAlumno.
	 * 
	 * @param nombreAlumno.
	 */
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	/**
	 * Getter del dniAlumno.
	 * 
	 * @return dniAlumno.
	 */
	public String getDniAlumno() {
		return dniAlumno;
	}

	/**
	 * Setter del dniAlumno.
	 * 
	 * @param dniAlumno.
	 */
	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	/**
	 * Getter del cantidadClasesSolicitadas.
	 * 
	 * @return cantidadClasesSolicitadas.
	 */
	public ArrayList<Integer> getCantidadClasesSolicitadas() {
		return cantidadClasesSolicitadas;
	}

	/**
	 * Setter del cantidadClasesSolicitadas.
	 * 
	 * @param cantidadClasesSolicitadas.
	 */
	public void setCantidadClasesSolicitadas(ArrayList<Integer> cantidadClasesSolicitadas) {
		this.cantidadClasesSolicitadas = cantidadClasesSolicitadas;
	}

}
