package bd;

import java.sql.Connection;

public class GestorBD {
	private Connection con;
	private final String localizador="jdbc:sqlite:";
	private String nombre;
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public GestorBD(String nombre) {
		super();
		this.nombre = this.localizador + nombre;
	}
	
	
}
