package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logneg.Administrador;
/**
 * Contiene los metodos crearTablaAdministrador, insertarAdministrador y todosLosAdmins.
 * @author Anton y Victor
 *
 */
public class AdministradorBD {
	/**
	 * Consiste en crear la tabla ADMINISTRADOR en la base de datos. 
	 * @param con Con es la url para hacer conexion con la base de datos.
	 */
	public static void crearTablaAdministrador(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS ADMINISTRADOR (\n" + "    dniTrabajadorAcademia text PRIMARY KEY,\n"
				+ "    emailTrabajadorAcademia text NOT NULL,\n" + "    nombreAdministrador text NOT NULL,\n"
				+ "    contrasenyaAdministrador text NOT NULL\n" + ");";
		try (Statement stmt = con.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Sirve para insertar un nuevo administrador en la base de datos.
	 * @param con Con es la url para hacer conexion con la base de datos.
	 * @param dniTrabajadorAcademia
	 * @param emailTrabajadorAcademia
	 * @param nombreAdministrador
	 * @param contrasenyaAdministrador
	 */
	public static void insertarAdministrador(Connection con, String dniTrabajadorAcademia,
			String emailTrabajadorAcademia, String nombreAdministrador, String contrasenyaAdministrador) {
		String sql = "INSERT INTO ADMINISTRADOR(dniTrabajadorAcademia, emailTrabajadorAcademia, nombreAdministrador, contrasenyaAdministrador)	VALUES(?,?,?,?)";
		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, dniTrabajadorAcademia);
			pstm.setString(2, emailTrabajadorAcademia);
			pstm.setString(3, nombreAdministrador);
			pstm.setString(4, contrasenyaAdministrador);

			pstm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Gracias a este metodo obtenemos una lista con todos los administradores de la base de datos.
	 * @param con Con es la url para hacer conexion con la base de datos.
	 * @return tutsAdmins que es la lista de todos los administradores de la base de datos.
	 */
	public static ArrayList<Administrador> todosLosAdmins(Connection con) {
		String sql = "SELECT dniTrabajadorAcademia,emailTrabajadorAcademia,nombreAdministrador,contrasenyaAdministrador FROM ADMINISTRADOR";
		ArrayList<Administrador> tutsAdmins=new ArrayList<Administrador>();
		try(Statement stmt=con.createStatement(); ResultSet rset=stmt.executeQuery(sql)){
			while(rset.next()){
				Administrador admin=new Administrador(rset.getString("dniTrabajadorAcademia"),rset.getString("emailTrabajadorAcademia"),rset.getString("nombreAdministrador"),rset.getString("contrasenyaAdministrador"));
				tutsAdmins.add(admin);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tutsAdmins;

	}
}
