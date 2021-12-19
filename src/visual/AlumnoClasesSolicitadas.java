package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import exceptions.AdministradorNoEcontrado;
import logneg.Alumno;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. En esta ventana
 *         el Administrador introduce un DNI de un Alumno y se muestran sus
 *         clases solicitadas.
 *
 */
public class AlumnoClasesSolicitadas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Alumno> listaAlumnos=new ArrayList<Alumno>();
	private Alumno usuarioObjetivo=new Alumno();
	private static ArrayList<String> clases=new ArrayList<>();
	private PantallaAdministrador papa;
	
	
	
	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}



	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}



	/**
	 * Create the frame.
	 */
	public AlumnoClasesSolicitadas(ArrayList<Alumno> alumnosBD, PantallaAdministrador padre) {
		this.listaAlumnos = alumnosBD;
		this.papa = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("info"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDniUsuario = new JLabel("DNI:");
		lblDniUsuario.setForeground(Color.BLACK);
		lblDniUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblDniUsuario.setBounds(83, 100, 72, 20);
		contentPane.add(lblDniUsuario);
		
		textField = new JTextField();
		textField.setBounds(145, 97, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBusquedaUsuario = new JLabel("Busqueda usuario:");
		lblBusquedaUsuario.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblBusquedaUsuario.setBounds(117, 47, 246, 26);
		contentPane.add(lblBusquedaUsuario);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dni=textField.getText();
				ArrayList<String> clases=new ArrayList<String>();
				ArrayList<Integer> cantidadClases=new ArrayList<Integer>();
				try{
					boolean foundy=comprobarUsuario(dni);
					clases=usuarioObjetivo.getNombreClase();
					cantidadClases=usuarioObjetivo.getCantidadClasesSolicitadas();
					
					cantidadClases=mergeSort(cantidadClases, clases);
					
					String textoObjetivo=null;
					for (int i=0;i<clases.size();i++){
						for (int j=0;j<cantidadClases.size();j++){
							textoObjetivo +="-> "+ clases.get(i) + " " + cantidadClases.get(j) + " veces\n";
						}
					}
					JOptionPane.showInputDialog(textoObjetivo);
					}catch (AdministradorNoEcontrado e) {

					JOptionPane.showMessageDialog(AlumnoClasesSolicitadas.this, e.getMessage());
				}
			
			}});
		
		JButton btn = new JButton("Volver");
		btn.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AlumnoClasesSolicitadas.this.dispose();
				padre.setVisible(true);
			}
		});
		btn.setBounds(145, 159, 99, 35);
		contentPane.add(btn);
	}
	/**
	 * Ordena de menor a mayor las clases a las que se han apuntado los alumnos y la cantidad
	 * @param arrayInput arrayList de la cantidad de veces de cada clase a la que se han apuntado
	 * @param clases arrayList de las clases a las que se han apuntado los alumnos
	 * @return devuelve ordenada la cantidad, es un arrayList
	 */		
	public ArrayList<Integer> mergeSort(ArrayList<Integer> arrayInput, ArrayList<String> clases) {
		if (arrayInput.size()==1){
			return arrayInput;
		}else{
			int middle=arrayInput.size()/2;
			ArrayList<Integer> left = new ArrayList<Integer>(middle);
			ArrayList<Integer> right = new ArrayList<Integer>(arrayInput.size() - middle);
			ArrayList<String> leftC = new ArrayList<String>(middle);
			ArrayList<String> rightC = new ArrayList<String>(arrayInput.size() - middle);
			
			for (int i=0;i<middle;i++){
				left.add(arrayInput.get(i));
				leftC.add(clases.get(i));
			}
			for (int i=middle;i< arrayInput.size();i++){
				right.add(arrayInput.get(i));
				rightC.add(clases.get(i));
			}
			left=mergeSort(left,leftC);
			right=mergeSort(right,rightC);
			return merge(left,right,leftC,rightC);
		}
	}
	/**
	 * Ordena de menor a mayor las clases a las que se han apuntado los alumnos y la cantidad
	 * @param left parte izda del arrayList de la cantidad de clases de los alumnos
	 * @param right parte dcha del arrayList de la cantidad de clases de los alumnos
	 * @param leftC parte izda del arrayList de las clases a las que se han apuntado los alumnos
	 * @param rightC parte dcha del arrayList de las clases a las que se han apuntado los alumnos
	 * @return devuelve ordenada la cantidad, es un arrayList
	 */
	
	private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<String> leftC,
			ArrayList<String> rightC) {
		ArrayList<Integer> ayu=new ArrayList<>();
		ArrayList<String> ayuClases=new ArrayList<>();
		
		while (!left.isEmpty() && !right.isEmpty()){
			if (left.get(0)>right.get(0)){
				ayu.add(right.get(0));
				right.remove(0);
				ayuClases.add(rightC.get(0));
				rightC.remove(0);
			}else{
				ayu.add(left.get(0));
				left.remove(0);
				ayuClases.add(leftC.get(0));
				leftC.remove(0);
			}
		}
		
		while (!left.isEmpty()){
			ayu.add(left.get(0));
			left.remove(0);
			ayuClases.add(leftC.get(0));
			leftC.remove(0);
			
		}
		while (!right.isEmpty()){
			ayu.add(right.get(0));
			right.remove(0);
			ayuClases.add(rightC.get(0));
			rightC.remove(0);
			
		}
		
		clases=ayuClases;
		return ayu;
	}
	/**
	 * Nos dira si el DNI esta o no.
	 * @param dni  el dni del Alumno
	 * @return si no existe el dni devolvera false y si existe true
	 * @throws AdiministradorNoEcontrado la clase que salta la excepcion si el usuario no existe
	 */
	public boolean comprobarUsuario(String dni)throws AdministradorNoEcontrado {
		
		boolean found=false;
		for(Alumno u:listaAlumnos){
			if (u.getDniAlumno().equals(dni)){
				found=true;
				usuarioObjetivo=u;
			}
		}
		if (found=true){
			return true;
		}else{
			throw new AdministradorNoEcontrado("Dni no existe");
		}
	}

}
