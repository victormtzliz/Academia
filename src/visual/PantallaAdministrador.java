package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Administrador;
import logneg.Alumno;
import logneg.Factura;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Una vez hace el
 *         Login, al Administrador le salen una serie de opciones.
 *
 */
public class PantallaAdministrador extends JFrame {

	private JPanel contentPane;
	private JList lista;
	private ArrayList<Alumno> alumnosBD = new ArrayList<Alumno>();
	private ArrayList<Administrador> administradoresBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private String usuario;
	private String password;
	private Inicio papa;

	/**
	 * Pantalla que le sale al Administrador una vez inicia sesion.
	 * 
	 * @param user
	 * @param pass
	 * @param alumnos
	 * @param administradores
	 * @param facturas
	 * @param padre
	 */
	public PantallaAdministrador(String user, String pass, ArrayList<Alumno> alumnos,
			ArrayList<Administrador> administradores, ArrayList<Factura> facturas, Inicio padre) {
		this.usuario = user;
		this.password = pass;
		this.alumnosBD = alumnos;
		this.administradoresBD = administradores;
		this.facturasBD = facturas;
		this.papa = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Buscar una factura", "Clase mas solicitada",
				"Clase: cantidad de solicitudes por alumno", "Enviar email" }));
		comboBox.setBounds(99, 62, 223, 26);
		contentPane.add(comboBox);

		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblBienvenido.setBounds(99, 34, 223, 20);
		contentPane.add(lblBienvenido);

		JList list = new JList();
		list.setBounds(99, 104, 234, 94);
		contentPane.add(list);
		/**
		 * Boton aceptar. Segun la opcion que se escoja del comboBox, llevara al
		 * Administrador a una pantalla o a otra.
		 */
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String eleccion = (String) comboBox.getSelectedItem();

				if (eleccion.equals("Buscar una factura")) {
					BuscarFactura buscarFac = new BuscarFactura(facturasBD, PantallaAdministrador.this);
					buscarFac.setVisible(true);
					PantallaAdministrador.this.setVisible(false);

				} else if (eleccion.equals("Clase mas solicitada")) {
					ClasePopular clasePop = new ClasePopular(alumnos, PantallaAdministrador.this);
					clasePop.setVisible(true);
					PantallaAdministrador.this.setVisible(false);

				} else if (eleccion.equals("Enviar email")) {
					EnviarCorreo correo = new EnviarCorreo(PantallaAdministrador.this, usuario, password);
					correo.setVisible(true);
					PantallaAdministrador.this.setVisible(false);

				} else if (eleccion.equals("Clase: cantidad de solicitudes por alumno")) {
					AlumnoClasesSolicitadas acs = new AlumnoClasesSolicitadas(alumnos, PantallaAdministrador.this);
					acs.setVisible(true);
					PantallaAdministrador.this.setVisible(false);

				}
			}
		});
		btnAceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAceptar.setBounds(109, 214, 115, 29);
		contentPane.add(btnAceptar);
	}

}
