package bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBD {
	private Connection con;
	private final String localizador = "jdbc:sqlite:";
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

	/**
	 * Este metodo hace que se inicie la base de datos tras haberla conectado
	 * previamente.
	 */
	public void inicioBD() {
		try {

		} catch (SQLException e) {
			System.out.println("Error.");
		}
	}

	/**
	 * Gracias a este metodo logramos conectarnos con la base de datos.
	 */
	public void conectarBD() {
		try {
			this.con = DriverManager.getConnection(this.nombre);
		} catch (SQLException e) {
			System.out.println("Error. " + e.getMessage());
		}
	}

	/**
	 * Este metodo crea una nueva base de datos.
	 * 
	 * @param file
	 *            File es el nombre del archivo, que sumado a "jdbc:sqlite:"
	 *            forma la url.
	 */
	public static void nuevaBD(String file) {
		String url = "jdbc:sqlite:" + file;
		try (Connection con = DriverManager.getConnection(url)) {
			if (con != null) {
				DatabaseMetaData metaData = con.getMetaData();
				System.out.println("El nombre del driver es: " + metaData.getDriverName());
				System.out.println("Se ha creado la BBDD");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para desconectarse de la base de datos.
	 */
	public void desconectarBD() {
		try {
			if (this.con != null) {
				this.con.close();
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido desconectar.");
		}
	}

	/**
	 * Este metodo crea otra base de datos.
	 * 
	 * @param file
	 *            File es el nombre del archivo, que sumado a "jdbc:sqlite:"
	 *            forma la url.
	 */
	public void crearBase(String file) {
		String url2 = "jdbc:sqlite:" + file;
		try (Connection con = DriverManager.getConnection(url2)) {
			if (con != null) {
				DatabaseMetaData mD = con.getMetaData(); // base de datos creada
				System.out.println("Nueva BBDD creada con nombre: " + mD.getDriverName());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
