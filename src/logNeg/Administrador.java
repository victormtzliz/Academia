package logneg;

/**
 * Clase Administrador de la academia. Es hija de la clase TrabajadorAcademia.
 * 
 * @author Anton y Victor.
 *
 */
public class Administrador extends TrabajadorAcademia {

	private String nombreAdministrador;
	private String contrasenyaAdministrador;

	public Administrador() {
		super();
	}

	/**
	 * Constructor del Administrador.
	 * 
	 * @param dniTrabajadorAcademia
	 *            hereda de TrabajadorAcademia.
	 * @param emailTrabajadorAcademia
	 *            hereda de TrabajadorAcademia.
	 * @param nombreAdministrador
	 * @param contrasenyaAdministrador
	 */
	public Administrador(String dniTrabajadorAcademia, String emailTrabajadorAcademia, String nombreAdministrador,
			String contrasenyaAdministrador) {
		super(dniTrabajadorAcademia, emailTrabajadorAcademia);
		this.nombreAdministrador = nombreAdministrador;
		this.contrasenyaAdministrador = contrasenyaAdministrador;
	}

	/**
	 * Getter del NombreAdministrador.
	 * 
	 * @return nombreAdministrador
	 */
	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	/**
	 * Setter del NombreAdministrador.
	 * 
	 * @param nombreAdministrador
	 */
	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	/**
	 * Getter de la contrasenyaAdministrador.
	 * 
	 * @return contrasenyaAdministrador
	 */
	public String getContrasenyaAdministrador() {
		return contrasenyaAdministrador;
	}

	/**
	 * Setter de la contrasenyaAdministrador
	 * 
	 * @param contrasenyaAdministrador
	 */
	public void setContrasenyaAdministrador(String contrasenyaAdministrador) {
		this.contrasenyaAdministrador = contrasenyaAdministrador;
	}

}
