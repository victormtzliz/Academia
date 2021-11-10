package logneg;

import java.util.ArrayList;

public class Alumno {
	private ArrayList<String> nombreClase;
	private String nombreAlumno;
	private String dniAlumno;
	private ArrayList<Integer> cantidadClasesSolicitadas;

	public Alumno() {

	}

	public Alumno(ArrayList<String> nombreClase, String nombreAlumno, String dniAlumno,
			ArrayList<Integer> cantidadClasesSolicitadas) {
		super();
		this.nombreClase = nombreClase;
		this.nombreAlumno = nombreAlumno;
		this.dniAlumno = dniAlumno;
		this.cantidadClasesSolicitadas = cantidadClasesSolicitadas;
	}

	public ArrayList<String> getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(ArrayList<String> nombreClase) {
		this.nombreClase = nombreClase;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public ArrayList<Integer> getCantidadClasesSolicitadas() {
		return cantidadClasesSolicitadas;
	}

	public void setCantidadClasesSolicitadas(ArrayList<Integer> cantidadClasesSolicitadas) {
		this.cantidadClasesSolicitadas = cantidadClasesSolicitadas;
	}

}
