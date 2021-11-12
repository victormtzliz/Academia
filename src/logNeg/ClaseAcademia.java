package logneg;

/**
 * Clase que puede haber en una academia universitaria.
 * 
 * @author Anton y Victor.
 *
 */
public class ClaseAcademia {

	private String nombreTema;
	private String asignatura;
	private int precio;

	public ClaseAcademia() {
		super();
	}

	/**
	 * Constructor de ClaseAcademia.
	 * 
	 * @param nombreTema
	 * @param asignatura
	 * @param precio
	 */
	public ClaseAcademia(String nombreTema, String asignatura, int precio) {
		super();
		this.nombreTema = nombreTema;
		this.asignatura = asignatura;
		this.precio = precio;
	}

	/**
	 * Getter de nombreTema.
	 * 
	 * @return nombreTema.
	 */
	public String getNombreTema() {
		return nombreTema;
	}

	/**
	 * Setter del nombreTema.
	 * 
	 * @param nombreTema.
	 */
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	/**
	 * Getter de la asignatura.
	 * 
	 * @return asignatura.
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * Setter de la asignatura.
	 * 
	 * @param asignatura.
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
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

}
