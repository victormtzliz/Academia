package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logneg.Administrador;
import logneg.Alumno;
import logneg.Factura;
import exceptions.AdministradorNoEcontrado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Esta pantalla es
 *         para que el Administrador haga Login y pueda pasar a la siguiente
 *         pantalla.
 *
 */
public class LoginAdministrador extends JFrame {

	private JPanel contentPane;
	private ArrayList<Alumno> alumnosBD = new ArrayList<Alumno>();
	private ArrayList<Administrador> administradoresBD = new ArrayList<Administrador>();
	private ArrayList<Factura> facturasBD = new ArrayList<Factura>();
	private Inicio padre;
	private JTextField nomAdmin;
	private JPasswordField passAdmin;

	/**
	 * Este frame contiene un TextField, un PasswordField y dos botones. Si el Login es correcto, le llevará a la siguiente pantalla del Administrador. Si cancela, se cerrara la pantalla.
	 * @param alumnos
	 * @param facturas
	 * @param administradores
	 * @param padre
	 */
	public LoginAdministrador(ArrayList<Alumno> alumnos, ArrayList<Factura> facturas,
			ArrayList<Administrador> administradores, Inicio padre) {
		this.alumnosBD = alumnos;
		this.administradoresBD = administradores;
		this.facturasBD = facturas;
		this.padre = padre;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * Aqui es donde el Administrador introduce su nombre de usuario.
		 */
		nomAdmin = new JTextField();
		nomAdmin.setBounds(62, 80, 146, 26);
		nomAdmin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(nomAdmin);
		nomAdmin.setColumns(10);
		/**
		 * Aqui es donde el Administrador introduce su contrasenya.
		 */
		passAdmin = new JPasswordField();
		passAdmin.setBounds(62, 151, 146, 26);
		passAdmin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		contentPane.add(passAdmin);

		JLabel lblUsuario = new JLabel("Usuario ");
		lblUsuario.setBounds(62, 59, 69, 20);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 16));
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrasenya ");
		lblContrasea.setBounds(62, 132, 146, 20);
		lblContrasea.setFont(new Font("Century Gothic", Font.BOLD, 16));
		contentPane.add(lblContrasea);
		/**
		 * Boton OK. Este boton comprueba el Login del Administrador. Si todo
		 * esta en orden, abrira la pantalla siguiente. En caso de que haya
		 * algun problema, emitira la excepcion.
		 */
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adminUser = nomAdmin.getText();
				String adminPass = passAdmin.getText();
				try {
					boolean comprobado = comprobarLogin(adminUser, adminPass);
					if (comprobado == true) {

						LoginAdministrador.this.dispose();
					}
				} catch (AdministradorNoEcontrado e1) {
					JOptionPane.showMessageDialog(LoginAdministrador.this, e1.getMessage());
				}
			}
		});
		btnOK.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnOK.setBounds(298, 35, 115, 29);
		contentPane.add(btnOK);
		/**
		 * Boton Cancelar. Uso de expresiones Lambda unicamente para reducir
		 * codigo.
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnCancelar.addActionListener(e -> LoginAdministrador.this.dispose());
		btnCancelar.setBounds(298, 188, 115, 29);
		contentPane.add(btnCancelar);
	}

	/**
	 * Este metodo realiza la comprobacion del login del Administrador.
	 * 
	 * @param usuario
	 *            Es el nombre de usuario del Administrador que pretende iniciar
	 *            sesion.
	 * @param pass
	 *            La contrasenya del Administrador que pretende iniciar sesion.
	 * @return True o False depende del exito o no de la comprobacion.
	 * @throws AdministradorNoEcontrado
	 *             Clase que contiene la excepcion.
	 */
	public boolean comprobarLogin(String usuario, String pass) throws AdministradorNoEcontrado {
		boolean comprobacion = false;
		for (Administrador admin : administradoresBD) {
			if (admin.getNombreAdministrador().equals(usuario) && admin.getContrasenyaAdministrador().equals(pass)) {
				comprobacion = true;
				break;
			}
		}
		if (comprobacion == true) {
			return true;
		} else {
			throw new AdministradorNoEcontrado("El usuario o la contrasenya son incorrectos");
		}
	}

}
