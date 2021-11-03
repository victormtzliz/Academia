package logneg;

public class Recepcionista extends TrabajadorAcademia {

	private int numeroCompraClase;
	private int salario;

	public Recepcionista() {
		super();
	}

	public Recepcionista(int numeroCompraClase, int salario) {
		super();
		this.numeroCompraClase = numeroCompraClase;
		this.salario = salario;
	}

	public int getNumeroCompraClase() {
		return numeroCompraClase;
	}

	public void setNumeroCompraClase(int numeroCompraClase) {
		this.numeroCompraClase = numeroCompraClase;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

}
