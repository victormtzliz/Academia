package logneg;

public class Administrador extends TrabajadorAcademia {

	private String nombreAdministrador;
	private String contrasenyaAdministrador;

	public Administrador() {
		super();
	}

	public Administrador(String dniTrabajadorAcademia, String emailTrabajadorAcademia, String nombreAdministrador,
			String contrasenyaAdministrador) {
		super(dniTrabajadorAcademia, emailTrabajadorAcademia);
		this.nombreAdministrador = nombreAdministrador;
		this.contrasenyaAdministrador = contrasenyaAdministrador;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getContrasenyaAdministrador() {
		return contrasenyaAdministrador;
	}

	public void setContrasenyaAdministrador(String contrasenyaAdministrador) {
		this.contrasenyaAdministrador = contrasenyaAdministrador;
	}

}
