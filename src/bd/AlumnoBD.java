package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logneg.Alumno;
/**
 * Clase que contiene los metodos relacionados con la base de datos de los alumnos.
 * @author Victor y Anton
 *
 */
public class AlumnoBD {
	
	/**
	 * Este metodo crea la tabla Alumno.
	 * @param con Con es la url de la base de datos.
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
	 * Este metodo nos vale para insertar alumnos de la academia en la base de datos.
	 * @param con Con es la url de la base de datos.
	 * @param dniAlumno
	 * @param nombreAlumno
	 * @param nombreClase lista con todas las clases que pide el mismo alumno.
	 * @param cantidadClasesSolicitadas el numero de clases que solicita un alumno de la misma asignatura.
	 */
	public static void insertarAlumno(Connection con, String dniAlumno, String nombreAlumno, ArrayList<String> nombreClase,
			ArrayList <Integer>cantidadClasesSolicitadas){
		String sql= "INSERT INTO ALUMNO(dniAlumno,nombreAlumno,nombreClase) VALUES(?,?,?)";
		String clases=null;
		String contador= null;
		
		try(PreparedStatement pstm=con.prepareStatement(sql)){
			for(int i=0;i<nombreClase.size();i++){
				if(i==nombreClase.size()-1){
					clases+=nombreClase.get(i);
				}
				clases+=nombreClase.get(i)+",";
			}
			for(int i=0;i<cantidadClasesSolicitadas.size();i++){
				if(i==cantidadClasesSolicitadas.get(i)-1){
					contador+=cantidadClasesSolicitadas.get(i);
				}
				contador+=cantidadClasesSolicitadas.get(i)+",";
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
	
	public static ArrayList<Alumno> todosLosAlumnos(Connection con){
		String sql = "SELECT dniAlumno, nombreAlumno, nombreClase, cantidadClasesSolicitadas FROM ALUMNO";
		ArrayList<Alumno> listaAlumnos=new ArrayList<Alumno>();
		try(Statement stmt= con.createStatement(); ResultSet rset=stmt.executeQuery(sql)){
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}
