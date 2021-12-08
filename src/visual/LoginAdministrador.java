package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Administrador;
import logneg.Alumno;
import logneg.Factura;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Esta pantalla es
 *         para que el Administrador haga Login y pueda pasar a la siguiente
 *         pantalla.
 *
 */
public class LoginAdministrador extends JFrame {

	private JPanel contentPane;
	private ArrayList<Alumno> alumnosBD=new ArrayList<Alumno>();
	private ArrayList<Administrador> administradoresBD=new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD=new ArrayList<Factura>();
	private Inicio padre;

	/**
	 * Create the frame.
	 */
	public LoginAdministrador(ArrayList<Alumno> alumnos, ArrayList<Factura> facturas, ArrayList<Administrador> administradores, Inicio padre) {
		this.alumnosBD=alumnos;
		this.administradoresBD=administradores;
		this.facturasBD=facturas;
		this.padre=padre;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
