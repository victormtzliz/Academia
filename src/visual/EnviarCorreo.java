package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author Anton y Victor para el proyecto de Programacion III. Esta pantalla
 *         permite enviar un correo.
 *
 */
public class EnviarCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoEnvia;
	private JTextField txtDestino;
	private JTextField txtCuerpoMensaje;
	private JLabel lblEmisor;
	private JLabel lblReceptor;
	private JLabel lblCuerpo;

	/**
	 * Esta clase permitira al Admin enviar correos
	 * 
	 * @param padre
	 *            es la clase anterior, en nuestro caso PantallaAdmin
	 * @param usuario
	 *            nombre del Admin
	 * @param password
	 *            su contrasena
	 */

	/**
	 * Create the frame.
	 */
	public EnviarCorreo(PantallaAdministrador padre, String usuario, String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnviarCorreo = new JLabel("Enviar Email");
		lblEnviarCorreo.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblEnviarCorreo.setForeground(new Color(0, 0, 0));
		lblEnviarCorreo.setBounds(144, 29, 348, 49);
		contentPane.add(lblEnviarCorreo);

		txtLoEnvia = new JTextField();
		txtLoEnvia.setBounds(133, 113, 289, 33);
		contentPane.add(txtLoEnvia);
		txtLoEnvia.setColumns(10);

		txtDestino = new JTextField();
		txtDestino.setBounds(133, 162, 289, 33);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		txtCuerpoMensaje = new JTextField();
		txtCuerpoMensaje.setBounds(132, 215, 290, 113);
		txtCuerpoMensaje.setColumns(10);

		// Convertimos el scrollpane en txt para facilitar

		JScrollPane scroll = new JScrollPane();
		scroll.setColumnHeaderView(txtCuerpoMensaje);
		scroll.setBounds(132, 215, 290, 113);
		contentPane.add(scroll);

		JButton btnEnviar = new JButton("Send");
		btnEnviar.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aCCION ENVIAR

				String loEnvia = txtLoEnvia.getText();
				String destino = txtDestino.getText();
				String cuerpoMensaje = txtCuerpoMensaje.getText();

				if (loEnvia != null || destino != null || cuerpoMensaje != null) {

					JOptionPane.showMessageDialog(null, "No se puede enviar el correo si no rellenas todos los campos");

				} else {

					if (EnviarCorreo.enviarEmail(usuario, password, destino, cuerpoMensaje) == true) {

						JOptionPane.showMessageDialog(null, "Email enviado con exito");

						padre.setVisible(true);
						EnviarCorreo.this.dispose();

					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido enviar el email");
					}

				}

			}
		});
		btnEnviar.setBounds(407, 366, 115, 29);
		contentPane.add(btnEnviar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Century Gothic", Font.BOLD, 17));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				padre.setVisible(true);
				EnviarCorreo.this.dispose();
			}
		});
		btnCancelar.setBounds(42, 366, 115, 29);
		contentPane.add(btnCancelar);

		lblEmisor = new JLabel("From: ");
		lblEmisor.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblEmisor.setBounds(27, 118, 91, 20);
		contentPane.add(lblEmisor);

		lblReceptor = new JLabel("To: ");
		lblReceptor.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblReceptor.setBounds(27, 171, 105, 20);
		contentPane.add(lblReceptor);

		lblCuerpo = new JLabel("Body: ");
		lblCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblCuerpo.setBounds(27, 215, 90, 70);
		contentPane.add(lblCuerpo);
	}

public static boolean enviarEmail(String usuario, String password, String destino, String cuerpoMensaje) {
	
	Properties emailProperties = new Properties();
	emailProperties.put("mail.smtp.host", "smtp.gmail.com");
	emailProperties.put("mail.smtp.auth", "true");
	emailProperties.put("mail.smtp.port", "465");
	emailProperties.put("mail.smtp.socketFactory.port", "465");
	emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	emailProperties.put("mail.debug", "true");
	emailProperties.put("mail.smtp.user", usuario);
	emailProperties.put("mail.smtp.clave", password);
	
	Session session = Session.getDefaultInstance(emailProperties);
	MimeMessage message = new MimeMessage(session);
	try {
		BodyPart texto = new MimeBodyPart();
		texto.setText(cuerpoMensaje);

		MimeMultipart m = new MimeMultipart();
		m.addBodyPart(texto);

		message.setFrom(new InternetAddress(usuario));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
		message.setContent(m);

		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", usuario, password);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
		return true;

	} catch (MessagingException me) {

		return false;
		

	}

}
