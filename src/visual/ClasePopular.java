package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import logneg.Alumno;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Esta pantalla
 *         muestra la clase mas solicitada por los alumnos.
 *
 */
public class ClasePopular extends JFrame {

	private JPanel contentPane;
	private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	private PantallaAdministrador papa;

	/**
	 * Create the frame.
	 */
	public ClasePopular(ArrayList<Alumno> alumnosBD, PantallaAdministrador padre) {
		this.listaAlumnos = alumnosBD;
		this.papa = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("Volver");
		btn.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClasePopular.this.dispose();
				papa.setVisible(true);
			}
		});
		btn.setBounds(237, 197, 110, 30);
		contentPane.add(btn);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClasePopular.this.dispose();
			}
		});
		
		JLabel lblPopular = new JLabel ("Curso mas solicitado");
		lblPopular.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPopular.setBounds(114, 33, 350, 50);
		contentPane.add(lblPopular);
		btnSalir.setBounds(69, 199, 115, 29);
		contentPane.add(btnSalir);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.menu);
		textPane.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textPane.setBounds(5, 5, 418, 234);
		contentPane.add(textPane);
		
		LinkedList<String> clase = clasePopCalcular();
		String c = null;
		for (int i = 0; i < clase.size(); i++) {
			c = clase.get(i) + "\n";
		}
		textPane.setText(c);
	}

	private LinkedList<String> clasePopCalcular() {
		LinkedList<String> clases = new LinkedList<String>();
		
		clases.add("Economia");
		clases.add("Fisica");
		clases.add("Matematicas");
		clases.add("Algebra");
		
		LinkedList<Integer> cuantos = new LinkedList<Integer>();
		int contadorEconomia = 0;
		int contadorFisica = 0;
		int contadorMatematicas =0;
		int contadorAlgebra = 0;
		
		for (Alumno u : listaAlumnos) {
			for (int i=0; i<u.getNombreClase().size(); i++){
				if (u.getNombreClase().get(i).equals("Economia")){
					contadorEconomia = contadorEconomia + u.getCantidadClasesSolicitadas().get(i);
					
				}
				else if (u.getNombreClase().equals("Pilates")){
					contadorFisica = contadorFisica + u.getCantidadClasesSolicitadas().get(i);
				}
				else if (u.getNombreClase().equals("Zumba")){
					contadorMatematicas = contadorMatematicas + u.getCantidadClasesSolicitadas().get(i);
				}
				else if (u.getNombreClase().equals("Spinning")){
					contadorAlgebra = contadorAlgebra + u.getCantidadClasesSolicitadas().get(i);
			}
			}
	}
		cuantos.add(contadorEconomia);
		cuantos.add(contadorFisica);
		cuantos.add(contadorMatematicas);
		cuantos.add(contadorAlgebra);
		
		//Streams
		
		int cursoMasSolicitado = cuantos.stream().mapToInt(e -> e).max().getAsInt();
		int pos=0;
				
		LinkedList <Integer> mas = new LinkedList<Integer>();
		LinkedList<String> mas1 = new LinkedList<String>();
				
				String curso = null;
				for (int i = 0; i < cuantos.size(); i++){
					if (cuantos.get(i)== cursoMasSolicitado){
						pos= i +1;
						mas.add(pos);
						
					}
				}
				
				for (int i = 0; i < mas.size(); i++){
					if (mas.get(i)== 1){
						curso= "Economia";
						mas1.add(curso);
						
					}else if (mas.get(i)==2){
						curso = "Fisica";
						mas1.add(curso);
						
					}else if (mas.get(i)==3){
						curso = "Matematicas";
						mas1.add(curso);
						
					}else if (mas.get(i)==4){
						curso = "Algebra";
						mas1.add(curso);
					}
				}
				return mas1;
		
	}

}
