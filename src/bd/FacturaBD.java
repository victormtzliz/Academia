package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import logneg.Factura;

/**
 * 
 * @author Victor y Anton
 *
 */

public class FacturaBD {
	/**
	 * Este metodo crea la tabla facturaAlumno
	 * @param con
	 */
	public static void crearTablaFactura(Connection con){
		
		String sql = "CREATE TABLE IF NOT EXISTS facturaAlumno (\n" 
				+ "    numercoCompraClase text PRIMARY KEY,\n"
				+ "    dia text NOT NULL,\n" 
				+ "    precio integer NOT NULL,\n"
				+ "	   nombreClase text NOT NULL\n" + ");";
		try(Statement s = con.createStatement()){
			s.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Este metodo inserta las facturas en la tabla facturasAlumno
	 * @param con
	 * @param numeroCompraClase
	 * @param dia
	 * @param precio
	 * @param clases
	 */
	public static void facturaAlumno(Connection con, int numeroCompraClase, String dia, int precio, ArrayList<String> clases){
		String sql="INSERT INTO facturaAlumno(numeroCompraClase,dia,precio,clases) VALUES(?,?,?,?)";

		String nombreClase = null;
		
		try(PreparedStatement ps=con.prepareStatement(sql)){
			for(int i=0;i<clases.size();i++){
				if(i==clases.size()-1){
					nombreClase+=clases.get(i);
				}
				nombreClase+=clases.get(i)+",";
			}
			ps.setInt(1, numeroCompraClase);
			ps.setString(2, dia);
			ps.setInt(3, precio);
			ps.setString(4, nombreClase);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Este metodo seleciona y devuelve la lista de facturas
	 * @param con
	 * @return
	 */
	public static ArrayList<Factura> todasFacturas(Connection con){
		String sql="SELECT numeroCompraClase,dia,precio,clases FROM facturaAlumno";
		ArrayList<Factura> listadoFacturas=new ArrayList<Factura>();
		String dia=null;
		int numeroCompraClase=0;
		int precio=0;
		ArrayList<String> listadoClases=new ArrayList<String>();
		
		try(Statement s=con.createStatement(); ResultSet rset=s.executeQuery(sql)){
			while (rset.next()){
				numeroCompraClase=rset.getInt("numCompraClase");
				dia=rset.getString("dia");
				precio=rset.getInt("precio");
				
				String[] clases=rset.getString("clases").split(",");
				listadoClases=(ArrayList<String>) Arrays.asList(clases);
			}
			Date diaFac=null;
			try{
				
				diaFac=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(dia);
			} catch(ParseException e){
				
				e.printStackTrace();
				
			}
			Factura factura=new Factura(listadoClases, diaFac, precio, numeroCompraClase);
			listadoFacturas.add(factura);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listadoFacturas;
	}


	
}
