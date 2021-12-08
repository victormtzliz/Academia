package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logneg.Alumno;
import logneg.ClaseAcademia;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta pantalla
 *         le salen las clases disponibles al Alumno.
 *
 */
public class PantallaAlumno extends JFrame {
	
	private JPanel contentPane;
	private ArrayList<ClaseAcademia> clases=null;
	ArrayList<Alumno> alumnosBD=new ArrayList<Alumno>();
	private Inicio padre;


	/**
	 * Create the frame.
	 */
	public PantallaAlumno(ArrayList<Alumno> alumnos,Inicio padre) {
		this.alumnosBD=alumnos;
		this.padre=padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
