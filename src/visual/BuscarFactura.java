package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logneg.Factura;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta pantalla
 *         establece el Administrador un dia y se le abre la pantalla
 *         VerFacturasDeUnDia con las facturas de ese dia.
 *
 */
public class BuscarFactura extends JFrame {

	private JPanel contentPane;
	private JTextField txtFecFac;
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	private PantallaAdministrador papa;
	private JLabel lblBuscarFactura;

	/**
	 * Pantalla donde el usuario introduce una fecha para que se le abra otra
	 * pantalla con las facturas de ese dia en concreto.
	 * 
	 * @param facturasBD
	 * @param padre
	 */
	public BuscarFactura(ArrayList<Factura> facturasBD, PantallaAdministrador padre) {
		this.facturas = facturasBD;
		this.papa = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblBuscarFactura = new JLabel("BUSCAR UNA FACTURA POR FECHA");
		lblBuscarFactura.setForeground(Color.BLACK);
		lblBuscarFactura.setFont(new Font("Century Gothic", Font.BOLD, 21));
		lblBuscarFactura.setBounds(35, 16, 378, 38);
		contentPane.add(lblBuscarFactura);

		txtFecFac = new JTextField();
		txtFecFac.setBounds(146, 91, 209, 31);
		contentPane.add(txtFecFac);
		txtFecFac.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fechaFactura = txtFecFac.getText();
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				ArrayList<Factura> seleccionada = facturas.stream()
						.filter(w -> (formatter.format(w.getDia())).equals(fechaFactura))
						.collect(Collectors.toCollection(() -> new ArrayList<Factura>()));
				if (seleccionada.isEmpty()) {
					JOptionPane.showMessageDialog(BuscarFactura.this, "No hay ninguna factura para dicho dia");
				} else {
					BuscarFactura.this.dispose();
					VerFacturasDeUnDia verFac = new VerFacturasDeUnDia(BuscarFactura.this, fechaFactura, seleccionada);
					verFac.setVisible(true);
				}
			}
		});
		btnOk.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnOk.setBounds(82, 165, 103, 30);
		contentPane.add(btnOk);

		JLabel lblFecha = new JLabel("FECHA: ");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblFecha.setBounds(45, 70, 103, 70);
		contentPane.add(lblFecha);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarFactura.this.dispose();
				papa.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnSalir.setBounds(216, 166, 126, 29);
		contentPane.add(btnSalir);
	}

}
