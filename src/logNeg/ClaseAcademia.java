package logneg;

public class ClaseAcademia {

	private String nombreTema;
	private String asignatura;
	private int precio;

	public ClaseAcademia() {
		super();
	}

	public ClaseAcademia(String nombreTema, String asignatura, int precio) {
		super();
		this.nombreTema = nombreTema;
		this.asignatura = asignatura;
		this.precio = precio;
	}

	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
