package exceptions;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta clase se
 *         guardaran las excepciones que puedan surgir a lo largo del proyecto.
 *         En este caso, en caso de que en el Login no se encontrara al
 *         Administrador.
 */

public class AdministradorNoEcontrado extends Exception {

	public AdministradorNoEcontrado(String mensaje) {
		super(mensaje);
	}

}
