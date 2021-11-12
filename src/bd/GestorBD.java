package bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Gestor de la base de datos. Encontramos los metodos conectar, desconectar e
 * inicio (entre otros).
 * 
 * @author Anton y Victor.
 *
 */
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
	 * Este metodo inicia la BD con una serie de tablas y datos despues de
	 * haberla conectado previamente.
	 * 
	 * @throws SQLException
	 *             si ocurre algun problema con respecto a la base de datos
	 *             lanzara la SQLException.
	 */
	public void inicioBD() throws SQLException {

		AlumnoBD.crearTablaAlumno(this.con);
		AdministradorBD.crearTablaAdministrador(this.con);
		FacturaBD.crearTablaFactura(this.con);

		AdministradorBD.insertarAdministrador(this.con, "72601036H", "victormtzliz@opendeusto.es", "victor",
				"victor123");
		AdministradorBD.insertarAdministrador(this.con, "72601035H", "victormtzli@opendeusto.es", "vic", "victor12345");
		AdministradorBD.insertarAdministrador(this.con, "72601034H", "antonsangil@opendeusto.es", "antonio",
				"antonio123");
		AdministradorBD.insertarAdministrador(this.con, "72601033H", "antonsangi@opendeusto.es", "anton", "anton123");

		ArrayList<String> clases = new ArrayList<String>();
		clases.add("Economia");
		clases.add("Fisica");

		ArrayList<String> clases2 = new ArrayList<String>();
		clases2.add("Matematicas");
		clases2.add("Algebra");

		ArrayList<Integer> cantidadDeVezSolicitado = new ArrayList<Integer>();
		cantidadDeVezSolicitado.add(1);
		cantidadDeVezSolicitado.add(3);

		ArrayList<Integer> cantidadDeVezSolicitado2 = new ArrayList<Integer>();
		cantidadDeVezSolicitado2.add(4);
		cantidadDeVezSolicitado2.add(2);

		AlumnoBD.insertarAlumno(this.con, "73601035H", "Anton San Gil", clases, cantidadDeVezSolicitado);
		AlumnoBD.insertarAlumno(this.con, "74601034H", "Victor Martinez", clases2, cantidadDeVezSolicitado2);

		ArrayList<String> clases3 = new ArrayList<String>();
		clases.add("Economia");
		clases.add("Fisica");

		ArrayList<String> clases4 = new ArrayList<String>();
		clases2.add("Matematicas");
		clases2.add("Algebra");

		FacturaBD.facturaAlumno(this.con, 1, "12-11-2021", 34, clases3);
		FacturaBD.facturaAlumno(this.con, 2, "13-11-2021", 36, clases4);

		this.desconectarBD();
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
