package genericos;

import logneg.Recepcionista;

/**
 * Clase genérica con el método de calcular salario neto para Objetos que
 * hereden de Recepcionista.
 * 
 * @author Victor y Anton para el proyecto de Programacion III.
 *
 * @param <T>
 *            Tomara diferentes formas de objetos que hereden de Recepcionista.
 */
public class SalarioNetoRecepcionista<T extends Recepcionista> {
	private T recep;

	public SalarioNetoRecepcionista(T recepcionista) {
		this.recep = recepcionista;
	}

	public T getRecep() {
		return recep;
	}

	/**
	 * Este es el metodo para calcular el salario neto.
	 * 
	 * @return Devuelve el salario.
	 */
	public double calcularSalarioNeto() {
		double salario = recep.getSalario() / 1.2;
		return salario;
	}

}
