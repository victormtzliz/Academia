package genericos;

import java.util.ArrayList;

import logneg.TrabajadorAcademia;

/**
 * Interfaz que contiene un metodo abstracto.
 * 
 * @author Victor y Anton para el proyecto de Programacion III.
 *
 * @param <T>
 *            Tomara diferentes formas de objetos que hereden de Recepcionista.
 */
public interface InterfaceCalcu<T extends TrabajadorAcademia> {
	public abstract ArrayList<Integer> calcu(ArrayList<T> arrayT);

}
