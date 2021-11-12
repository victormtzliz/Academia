package logneg;

/**
 * Esta clase es abstracta pues va a ser la clase padre tanto de la clase
 * Administrador como de Profesor y de Recepcionista La clase abstracta contiene
 * varios atributos que seran comunes para todos sus hijos Tambien contiene los
 * getters y los setters
 * 
 * @author Victor y Anton para el proyecto de Programacion III
 *
 */

public abstract class TrabajadorAcademia {
	private String dniTrabajadorAcademia;
	private String emailTrabajadorAcademia;

	public TrabajadorAcademia() {

	}

	/**
	 * Constructor de TrabajadorAcademia.
	 * 
	 * @param dniTrabajadorAcademia
	 * @param emailTrabajadorAcademia
	 */

	public TrabajadorAcademia(String dniTrabajadorAcademia, String emailTrabajadorAcademia) {
		super();
		this.dniTrabajadorAcademia = dniTrabajadorAcademia;
		this.emailTrabajadorAcademia = emailTrabajadorAcademia;
	}

	/**
	 * El metodo obtiene el DNI del trabajador
	 * 
	 * @return
	 */

	public String getDniTrabajadorAcademia() {
		return dniTrabajadorAcademia;
	}

	/**
	 * El metodo establece el DNI del trabajador
	 * 
	 * @param dniTrabajadorAcademia
	 */

	public void setDniTrabajadorAcademia(String dniTrabajadorAcademia) {
		this.dniTrabajadorAcademia = dniTrabajadorAcademia;
	}

	/**
	 * El metodo obtiene el EMAIL del trabajador
	 * 
	 * @return
	 */

	public String getEmailTrabajadorAcademia() {
		return emailTrabajadorAcademia;
	}

	/**
	 * El metodo establece el EMAIL del trabajador
	 * 
	 * @param emailTrabajadorAcademia
	 */

	public void setEmailTrabajadorAcademia(String emailTrabajadorAcademia) {
		this.emailTrabajadorAcademia = emailTrabajadorAcademia;
	}

}
