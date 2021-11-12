package logneg;

import java.util.ArrayList;

/**
 * Clase profesor de la academia. Es hija de TrabajadorAcademia.
 * 
 * @author Anton y Victor.
 *
 */
public class Profesor extends TrabajadorAcademia {

	private ArrayList<String> clases;

	public Profesor() {
		super();
	}

	/**
	 * Constructor de Profesor.
	 * 
	 * @param dniTrabajadorAcademia
	 *            hereda de TrabajadorAcademia.
	 * @param emailTrabajadorAcademia
	 *            hereda de TrabajadorAcademia.
	 * @param clases
	 */
	public Profesor(String dniTrabajadorAcademia, String emailTrabajadorAcademia, ArrayList<String> clases) {
		super(dniTrabajadorAcademia, emailTrabajadorAcademia);
		this.clases = clases;
	}

	/**
	 * Getter de clases.
	 * 
	 * @return clases.
	 */
	public ArrayList<String> getClases() {
		return clases;
	}

	/**
	 * Setter de clases.
	 * 
	 * @param clases.
	 */
	public void setClases(ArrayList<String> clases) {
		this.clases = clases;
	}

}
