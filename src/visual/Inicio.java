package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bd.AdministradorBD;
import bd.AlumnoBD;
import bd.FacturaBD;
import bd.GestorBD;
import logneg.Administrador;
import logneg.Alumno;
import logneg.Factura;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Es la primera
 *         pantalla que le saldrá a cualquiera que acceda al programa. Le da dos
 *         opciones, elegir si es Alumno o Administrador. Dependiendo de la
 *         decision le abrira una pantalla u otra.
 *
 */
public class Inicio extends JFrame {

	private JPanel contentPane;
	private ArrayList<Administrador> administradores;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Factura> facturas;

	/**
	 * Ejecuta la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame Inicio. Primero, conectara con la BD y la iniciara. Gracias
	 * a esto podremos llenar los ArrayList que hemos inicializado antes con los
	 * datos que contenga la BD. Luego, añadimos los elementos correspondientes
	 * para que el Frame realice lo que se le requiere.
	 * 
	 * @throws SQLException
	 *             En caso de que hubiera cualquier problema, se lanzara una
	 *             excepcion.
	 */
	public Inicio() throws SQLException {

		GestorBD bd = new GestorBD("Academia.db");
		bd.conectarBD();
		bd.inicioBD();
		administradores = AdministradorBD.todosLosAdmins(bd.getCon());
		alumnos = AlumnoBD.todosLosAlumnos(bd.getCon());
		facturas = FacturaBD.todasFacturas(bd.getCon());

		bd.desconectarBD();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Boton Administrador. Para reducir codigo, hemos hecho uso de las
		 * Expresiones Lambda.
		 */
		JButton botonAdministrador = new JButton("Administrador");
		botonAdministrador.addActionListener(e -> {
			LoginAdministrador login = new LoginAdministrador(alumnos, facturas, administradores, Inicio.this);
			login.setVisible(true);
			Inicio.this.setVisible(false);
		});

		botonAdministrador.setBorder(new LineBorder(new Color(176, 196, 222), 3));
		botonAdministrador.setFont(new Font("Century Gothic", Font.BOLD, 16));
		botonAdministrador.setBounds(48, 94, 162, 29);
		contentPane.add(botonAdministrador);

		/**
		 * Boton Alumno. Para reducir codigo, hemos hecho uso de las Expresiones
		 * Lambda.
		 */
		JButton botonAlumno = new JButton("Alumno");
		botonAlumno.addActionListener(e -> {
			PantallaAlumno pantallaAlumno = new PantallaAlumno(alumnos, Inicio.this);
			pantallaAlumno.setVisible(true);
			Inicio.this.setVisible(false);

		});

		botonAlumno.setBorder(new LineBorder(new Color(176, 196, 222), 3));
		botonAlumno.setFont(new Font("Century Gothic", Font.BOLD, 16));
		botonAlumno.setBounds(234, 95, 162, 29);
		contentPane.add(botonAlumno);

		/**
		 * Boton Salir. Para reducir codigo, hemos hecho uso de las Expresiones
		 * Lambda.
		 */
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBorder(new LineBorder(new Color(176, 196, 222), 3));
		botonSalir.setFont(new Font("Century Gothic", Font.BOLD, 16));
		botonSalir.addActionListener(e -> Inicio.this.dispose());
		botonSalir.setBounds(154, 172, 115, 29);
		contentPane.add(botonSalir);
		/**
		 * Label Academia.
		 */
		JLabel labelAcademia = new JLabel("University Academy");
		labelAcademia.setFont(new Font("Tahoma", Font.BOLD, 19));
		labelAcademia.setBounds(112, 16, 216, 49);
		contentPane.add(labelAcademia);
	}

}
