package logneg;

/**
 * Clase Recepcionista de la academia. Clase hija de TrabajadorAcademia.
 * 
 * @author Anton y Victor.
 *
 */
public class Recepcionista extends TrabajadorAcademia {

	private int numeroCompraClase;
	private int salario;

	public Recepcionista() {
		super();
	}

	/**
	 * Constructor de Recepcionista.
	 * 
	 * @param numeroCompraClase
	 * @param salario
	 */
	public Recepcionista(int numeroCompraClase, int salario) {
		super();
		this.numeroCompraClase = numeroCompraClase;
		this.salario = salario;
	}

	/**
	 * Getter de numeroCompraClase.
	 * 
	 * @return numeroCompraClase.
	 */
	public int getNumeroCompraClase() {
		return numeroCompraClase;
	}

	/**
	 * Setter de numeroCompraClase.
	 * 
	 * @param numeroCompraClase.
	 */
	public void setNumeroCompraClase(int numeroCompraClase) {
		this.numeroCompraClase = numeroCompraClase;
	}

	/**
	 * Getter de salario.
	 * 
	 * @return salario.
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * Setter de salario.
	 * 
	 * @param salario.
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}

}
