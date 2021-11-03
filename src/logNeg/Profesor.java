package logneg;

import java.util.ArrayList;

public class Profesor extends TrabajadorAcademia {

	private ArrayList<String> clases;

	public Profesor() {
		super();
	}

	public Profesor(String dniTrabajadorAcademia, String emailTrabajadorAcademia, ArrayList<String> clases) {
		super(dniTrabajadorAcademia, emailTrabajadorAcademia);
		this.clases = clases;
	}

	public ArrayList<String> getClases() {
		return clases;
	}

	public void setClases(ArrayList<String> clases) {
		this.clases = clases;
	}

}
