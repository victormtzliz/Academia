package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logneg.Alumno;
import logneg.ClaseAcademia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta pantalla
 *         le salen las clases disponibles al Alumno.
 *
 */
public class PantallaAlumno extends JFrame {

	private JPanel contentPane;
	private ArrayList<ClaseAcademia> clases = null;
	ArrayList<Alumno> alumnosBD = new ArrayList<Alumno>();
	private Inicio padre;

	/**
	 * En esta pantalla, al Alumno le saldran multiples clases a las que poder
	 * inscribirse.
	 * 
	 * @param alumnos
	 * @param padre
	 */
	public PantallaAlumno(ArrayList<Alumno> alumnos, Inicio padre) {
		this.alumnosBD = alumnos;
		this.padre = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClasesAcademia = new JLabel("CLASES - UNIVERSITY ACADEMY");
		lblClasesAcademia.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblClasesAcademia.setBounds(29, 16, 272, 20);
		contentPane.add(lblClasesAcademia);

		JLabel lblMatematicas = new JLabel("Matematicas");
		lblMatematicas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblMatematicas.setBounds(88, 52, 113, 20);
		contentPane.add(lblMatematicas);

		JLabel label = new JLabel("15");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label.setBounds(88, 73, 49, 20);
		contentPane.add(label);

		JComboBox temasMate = new JComboBox();
		temasMate.setModel(new DefaultComboBoxModel(new String[] { "Derivadas", "Integrales" }));
		temasMate.setBounds(115, 71, 100, 26);
		contentPane.add(temasMate);

		JButton btnInscribirme = new JButton("Inscribirme");
		btnInscribirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String precioString = label.getText();
				int precio = Integer.parseInt(precioString);
				String temaMate = (String) temasMate.getSelectedItem();
				ClaseAcademia claseMate = new ClaseAcademia(temaMate, "Matematicas", precio);
				clases.add(claseMate);
			}
		});
		btnInscribirme.setBorder(new LineBorder(new Color(0, 51, 102), 1, true));
		btnInscribirme.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnInscribirme.setBounds(37, 99, 105, 27);
		contentPane.add(btnInscribirme);

		JLabel lblFisica = new JLabel("Fisica");
		lblFisica.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblFisica.setBounds(88, 156, 125, 20);
		getContentPane().add(lblFisica);

		JLabel label_2 = new JLabel("12");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_2.setBounds(88, 180, 49, 20);
		getContentPane().add(label_2);

		JComboBox temasFisica = new JComboBox();
		temasFisica.setModel(new DefaultComboBoxModel(new String[] { "Fisica", "Quimica" }));
		temasFisica.setBounds(115, 178, 100, 26);
		getContentPane().add(temasFisica);

		JButton button = new JButton("Inscribirme");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String precioString = label_2.getText();
				int precio = Integer.parseInt(precioString);
				String temaFisica = (String) temasFisica.getSelectedItem();
				ClaseAcademia claseMate = new ClaseAcademia(temaFisica, "Fisica", precio);
				clases.add(claseMate);
			}
		});
		button.setFont(new Font("Century Gothic", Font.BOLD, 13));
		button.setBorder(new LineBorder(new Color(0, 51, 102), 1, true));
		button.setBounds(37, 207, 105, 27);
		getContentPane().add(button);
		/**
		 * Al darle al boton y si se ha seleccionado alguna clase para comprar,
		 * suma los precios de todas las clases y abre una pantalla nueva de
		 * PantallaFacturaClases, donde se desglosa la compra de dichas clases
		 * en forma de factura.
		 */
		JButton btnRealizarCompra = new JButton("Realizar compra");
		btnRealizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clases != null) {
					int precioTotal = 0;
					for (int i = 0; i < clases.size(); i++) {
						precioTotal += clases.get(i).getPrecio();
					}
					PantallaFacturaClases pantallaFacClases = new PantallaFacturaClases(precioTotal, clases, alumnosBD);
					pantallaFacClases.setVisible(true);
				}
			}
		});
		btnRealizarCompra.setBounds(265, 98, 155, 29);
		getContentPane().add(btnRealizarCompra);
		/**
		 * Al cancelar, cierra esta pantalla y abre la anterior.
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAlumno.this.dispose();
				padre.setVisible(true);
			}
		});
		btnCancelar.setBounds(265, 153, 155, 29);
		getContentPane().add(btnCancelar);
	}

}
