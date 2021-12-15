package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bd.GestorBD;
import logneg.Alumno;
import logneg.ClaseAcademia;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta pantalla
 *         se muestra la factura de las clases que el usuario va a comprar.
 *
 */
public class PantallaFacturaClases extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumFactura;
	private JTextField txtFechaFactura;
	private JTextField txtPrecio;
	private JTextField txtDni;
	private JTextField nombreAlumno;

	private static ArrayList<Alumno> alumnosBD = new ArrayList<Alumno>();
	private static ArrayList<ClaseAcademia> compra = new ArrayList<ClaseAcademia>();
	private static ArrayList<String> nombreClases = new ArrayList<String>();
	private static ArrayList<Integer> cantidadClases = new ArrayList<Integer>();
	private static String dniAlumno;
	private static int cuentaMatematicas = 0;
	private static int cuentaFisica = 0;

	/**
	 * Pantalla que muestra la factura de las clases que ha comprado el alumno.
	 * 
	 * @param precioTotal
	 * @param clases
	 * @param alumnosBD
	 */
	public PantallaFacturaClases(int precioTotal, ArrayList<ClaseAcademia> clases, ArrayList<Alumno> alumnosBD) {
		this.alumnosBD = alumnosBD;
		this.compra = clases;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel Factura = new JLabel("FACTURA");
		Factura.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Factura.setBounds(208, 33, 117, 38);
		contentPane.add(Factura);

		JLabel NumeroFactura = new JLabel("Numero Factura:");
		NumeroFactura.setFont(new Font("Century Gothic", Font.BOLD, 18));
		NumeroFactura.setBounds(33, 211, 160, 20);
		contentPane.add(NumeroFactura);

		txtNumFactura = new JTextField();
		txtNumFactura.setBounds(208, 208, 144, 26);
		contentPane.add(txtNumFactura);
		txtNumFactura.setColumns(10);
		// ponemos aleatoriamente un numero de factura
		int n = 100;
		int numero = (int) (Math.random() * n) + 1;
		txtNumFactura.setText("" + numero);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblFecha.setBounds(33, 273, 69, 20);
		contentPane.add(lblFecha);

		txtFechaFactura = new JTextField();
		txtFechaFactura.setBounds(206, 270, 146, 26);
		contentPane.add(txtFechaFactura);
		txtFechaFactura.setColumns(10);
		Date fecha = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFac = formatter.format(fecha);
		// Anyadimos la fecha de hoy
		txtFechaFactura.setText(fechaFac);

		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPedido.setBounds(33, 346, 69, 20);
		contentPane.add(lblPedido);

		JLabel lblPrecioTotal = new JLabel("Coste total:");
		lblPrecioTotal.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblPrecioTotal.setBounds(45, 523, 127, 20);
		contentPane.add(lblPrecioTotal);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(208, 520, 69, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		// anyadir el coste total
		String total = " " + precioTotal;
		txtPrecio.setText(total);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblDni.setBounds(33, 114, 69, 20);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(206, 111, 146, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		JLabel lblAl = new JLabel("ALUMNO:");
		lblAl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAl.setBounds(33, 168, 93, 20);
		contentPane.add(lblAl);

		nombreAlumno = new JTextField();
		nombreAlumno.setBounds(206, 165, 146, 26);
		contentPane.add(nombreAlumno);
		nombreAlumno.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(208, 346, 327, 158);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textPane);
		scroll.setBounds(208, 346, 327, 158);
		contentPane.add(scroll);

		String pedido = "";
		for (int i = 0; i < compra.size(); i++) {
			pedido += "-> " + compra.get(i).getAsignatura() + ", tema: " + compra.get(i).getNombreTema() + " ---> "
					+ compra.get(i).getPrecio() + "\n";
		}
		textPane.setText(pedido);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaFacturaClases.this.dispose();
			}
		});
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCancelar.setBounds(103, 576, 133, 29);
		contentPane.add(btnCancelar);

		JButton btnConfirmarPedido = new JButton("CONFIRMAR PEDIDO");
		btnConfirmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = null;
				String alumno = null;
				dni = txtDni.getText();
				alumno = nombreAlumno.getText();
				dniAlumno = dni;

				if (dni != null && alumno != null) {
					contarClases();
					for (Alumno al : alumnosBD) {
						if (al.getDniAlumno().equals(dniAlumno)) {
							ArrayList<String> nombreClasesPrevio = al.getNombreClase();
							ArrayList<Integer> cantidadClasesPrevio = al.getCantidadClasesSolicitadas();
							GestorBD myBD1 = new GestorBD("Academia.db");
							myBD1.conectarBD();
							bd.AlumnoBD.eliminarAlumno(myBD1.getCon(), dniAlumno);
							myBD1.desconectarBD();

							juntarArray(nombreClasesPrevio, cantidadClasesPrevio);
						}
					}

					GestorBD myBD = new GestorBD("Academia.bd");
					myBD.conectarBD();
					bd.AlumnoBD.insertarAlumno(myBD.getCon(), dni, alumno, nombreClases, cantidadClases);
					myBD.desconectarBD();

					GestorBD myBD2 = new GestorBD("Academia.bd");
					myBD2.conectarBD();
					bd.FacturaBD.facturaAlumno(myBD2.getCon(), numero, fechaFac, precioTotal, nombreClases);
					myBD2.desconectarBD();

					JOptionPane.showMessageDialog(PantallaFacturaClases.this,
							"Su pedido se ha procesado correctamente, muchas gracias!!");
					PantallaFacturaClases.this.dispose();

				}
			}
		});
		btnConfirmarPedido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnConfirmarPedido.setBounds(276, 576, 216, 29);
		contentPane.add(btnConfirmarPedido);
	}

	/**
	 * Cuenta, a través de streams y expresiones Lambda, las clases de cada
	 * asignatura que se han comprado para luego anyadirlos a los dos arrays el
	 * nombre de la asignatura junto con su respectivo conteo.
	 */
	public static void contarClases() {
		cuentaMatematicas = (int) compra.stream().filter(w -> w.getAsignatura().equals("Matematicas")).count();
		cuentaFisica = (int) compra.stream().filter(w -> w.getAsignatura().equals("Fisica")).count();
		if (cuentaMatematicas != 0) {
			nombreClases.add("Matematicas");
			cantidadClases.add(cuentaMatematicas);
		}
		if (cuentaFisica != 0) {
			nombreClases.add("Fisica");
			cantidadClases.add(cuentaFisica);
		}
	}

	/**
	 * Junta los dos pares de arrays de clases con sus respectivas cantidades
	 * para tener uno conjunto.
	 * 
	 * @param nombreClasesPrevio
	 * @param cantidadClasesPrevio
	 */
	public static void juntarArray(ArrayList<String> nombreClasesPrevio, ArrayList<Integer> cantidadClasesPrevio) {
		for (int i = 0; i < nombreClasesPrevio.size(); i++) {
			if (nombreClasesPrevio.get(i).equals("Matematicas")) {
				cuentaMatematicas += cantidadClasesPrevio.get(i);
			}
			if (nombreClasesPrevio.get(i).equals("Fisica")) {
				cuentaFisica += cantidadClasesPrevio.get(i);
			}
		}
		if (cuentaMatematicas != 0) {
			nombreClases.add("Matematicas");
			cantidadClases.add(cuentaMatematicas);
		}
		if (cuentaFisica != 0) {
			nombreClases.add("Fisica");
			cantidadClases.add(cuentaFisica);
		}

	}

}
