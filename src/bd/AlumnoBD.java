package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import logneg.Alumno;

/**
 * Clase que contiene los metodos relacionados con la base de datos de los
 * alumnos.
 * 
 * @author Victor y Anton
 *
 */
public class AlumnoBD {

	/**
	 * Este metodo crea la tabla Alumno.
	 * 
	 * @param con
	 *            Con es la url para hacer conexion con la base de datos.
	 */
	public static void crearTablaAlumno(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS ALUMNO (\n" + "    dniAlumno text PRIMARY KEY,\n"
				+ "    nombreAlumno text NOT NULL,\n" + "    nombreClase text NOT NULL,\n"
				+ "	   cantidadClasesSolicitadas text NOT NULL\n" + ");";
		try (Statement stmt = con.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	/**
	 * Este metodo nos vale para insertar alumnos de la academia en la base de
	 * datos.
	 * 
	 * @param con
	 *            Con es la url para hacer conexion con la base de datos.
	 * @param dniAlumno
	 * @param nombreAlumno
	 * @param nombreClase
	 *            lista con todas las clases que pide el mismo alumno.
	 * @param cantidadClasesSolicitadas
	 *            el numero de clases que solicita un alumno de la misma
	 *            asignatura.
	 */
	public static void insertarAlumno(Connection con, String dniAlumno, String nombreAlumno,
			ArrayList<String> nombreClase, ArrayList<Integer> cantidadClasesSolicitadas) {
		String sql = "INSERT INTO ALUMNO(dniAlumno,nombreAlumno,nombreClase,cantidadClasesSolicitadas) VALUES(?,?,?,?)";
		String clases = null;
		String contador = null;

		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			for (int i = 0; i < nombreClase.size(); i++) {
				if (i == nombreClase.size() - 1) {
					clases += nombreClase.get(i);
				}
				clases += nombreClase.get(i) + ",";
			}
			for (int i = 0; i < cantidadClasesSolicitadas.size(); i++) {
				if (i == cantidadClasesSolicitadas.get(i) - 1) {
					contador += cantidadClasesSolicitadas.get(i);
				}
				contador += cantidadClasesSolicitadas.get(i) + ",";
			}
			pstm.setString(1, dniAlumno);
			pstm.setString(2, nombreAlumno);
			pstm.setNString(3, clases);
			pstm.setString(4, contador);
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este metodo sirve para hacer un select de la base de datos con los datos
	 * de todos los alumnos.
	 * 
	 * @param con
	 *            Con es la url para hacer conexion con la base de datos.
	 * @return Nos devolvera la lista con todos los alumnos y sus respectivos
	 *         datos.
	 */
	public static ArrayList<Alumno> todosLosAlumnos(Connection con) {
		String sql = "SELECT dniAlumno, nombreAlumno, nombreClase, cantidadClasesSolicitadas FROM ALUMNO";
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		try (Statement stmt = con.createStatement(); ResultSet rset = stmt.executeQuery(sql)) {
			while (rset.next()) {
				String dniAlumno = rset.getString("dniAlumno");
				String nombreAlumno = rset.getString("nombreAlumno");

				String[] clases = rset.getString("nombreClase").split(",");
				ArrayList<String> listaClases = new ArrayList<String>(Arrays.asList(clases));

				String[] numVeces = rset.getString("cantidadClasesSolicitadas").split(",");
				ArrayList<Integer> vecesPedidas = new ArrayList<Integer>();
				for (int i = 0; i < numVeces.length; i++) {
					String obtenido = numVeces[i];
					int obt = Integer.parseInt(obtenido);
					vecesPedidas.add(obt);

					Alumno al = new Alumno(listaClases, nombreAlumno, dniAlumno, vecesPedidas);
					listaAlumnos.add(al);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaAlumnos;

	}

	/**
	 * Con este metodo eliminamos el Alumno cuyo dni se pasa como parametro.
	 * 
	 * @param con
	 *            Con es la url para hacer conexion con la base de datos.
	 * @param dniAlumno
	 *            Sera el dni del Alumno que se pretende eliminar.
	 */
	public static void eliminarAlumno(Connection con, String dniAlumno) {
		String sql = "DELETE FROM ALUMNO WHERE dniAlumno = ?";
		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, dniAlumno);
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
