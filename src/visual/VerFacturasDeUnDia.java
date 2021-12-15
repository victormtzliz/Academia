package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import logneg.Factura;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Aqui se pueden
 *         ver todas las facturas de un dia concreto.
 *
 */
public class VerFacturasDeUnDia extends JFrame {

	private JPanel contentPane;
	private BuscarFactura papa;
	private String fechaFac;
	private ArrayList<Factura> seleccionada;
	private JLabel lblFactura;

	/**
	 * Pantalla que muestra las facturas de un dia concreto.
	 * 
	 * @param padre
	 * @param fechaF
	 * @param selection
	 */
	public VerFacturasDeUnDia(BuscarFactura padre, String fechaF, ArrayList<Factura> selection) {
		this.papa = padre;
		this.fechaFac = fechaF;
		this.seleccionada = selection;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFactura = new JLabel("FACTURAS: ");
		lblFactura.setForeground(new Color(0, 0, 0));
		lblFactura.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblFactura.setBounds(25, 33, 258, 57);
		contentPane.add(lblFactura);

		JLabel lblFecha = new JLabel(fechaFac);
		lblFecha.setBounds(313, 39, 132, 51);
		contentPane.add(lblFecha);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(48, 103, 421, 222);

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(48, 103, 421, 222);
		contentPane.add(scrollPane);

		String facturitas = null;

		for (Factura fac : seleccionada) {
			facturitas = fac.getNumeroCompraClase() + " ->" + fac.getPrecio() + "\n";
		}
		textPane.setText(facturitas);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerFacturasDeUnDia.this.dispose();
				papa.setVisible(true);
			}
		});
		btnSalir.setBounds(438, 364, 115, 29);
		contentPane.add(btnSalir);
	}

}
