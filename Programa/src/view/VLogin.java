package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CLogin;

public class VLogin extends JFrame implements ILogin, ActionListener {

	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JTextField tuser, tpregunta, trespuesta;
	private JButton olvido, ingresar, aceptar, volver, lupa;
	private JLabel pass, pregunta, respuesta, newpass;
	private JPasswordField tpass, tnewpass;
	private boolean validez;
	private Validacion val = new Validacion();

	public VLogin() {
		// TODO Auto-generated constructor stub
		this.setSize(260, 600);
		// this.setUndecorated(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salir();
			}
		});

		Container cp = getContentPane();
		cp.setBackground(white);

		GridBagLayout gb = new GridBagLayout();

		gb.columnWidths = new int[] { 30, 200, 30 };
		gb.rowHeights = new int[] { 175, 25, 25, 25, 25, 25, 25, 25, 25, 25, 50, 10, 50, 90 };
		GridBagConstraints reglas = new GridBagConstraints();

		cp.setLayout(gb);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("recursos/img/logo.png"));
		logo.setBackground(darkblue);
		reglas.gridx = 0;
		reglas.gridy = 0;
		reglas.gridwidth = 3;
		reglas.fill = GridBagConstraints.NONE;

		cp.add(logo, reglas);

		JLabel usuario = new JLabel("Usuario:");
		usuario.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		usuario.setBackground(darkblue);
		usuario.setVisible(true);

		reglas.gridx = 1;
		reglas.gridy++;
		reglas.gridwidth = 1;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		cp.add(usuario, reglas);

		lupa = new JButton();
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setCursor(new Cursor(HAND_CURSOR));
		lupa.setBorder(null);
		lupa.addActionListener(this);
		lupa.setVisible(false);
		lupa.setHorizontalAlignment(SwingConstants.LEFT);
		reglas.gridy = 2;
		reglas.gridx = 2;

		cp.add(lupa, reglas);

		tuser = new JTextField(8);
		tuser.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		tuser.setBackground(white);
		tuser.setVisible(true);

		reglas.gridy = 2;
		reglas.gridx = 1;
		cp.add(tuser, reglas);

		pass = new JLabel("Contraseña:");
		pass.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		pass.setBackground(darkblue);
		pass.setVisible(true);

		reglas.gridx = 1;
		reglas.gridy++;
		reglas.gridwidth = 1;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		cp.add(pass, reglas);

		tpass = new JPasswordField();
		tpass.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		tpass.setBackground(white);
		tpass.setVisible(true);

		reglas.gridy++;
		cp.add(tpass, reglas);

		olvido = new JButton();
		olvido.setContentAreaFilled(false);
		olvido.setIcon(new ImageIcon("recursos/img/olvidoON.png"));
		olvido.setRolloverIcon(new ImageIcon("recursos/img/olvidoOFF.png"));
		olvido.setBackground(white);
		olvido.setBorder(null);
		olvido.addActionListener(this);
		olvido.setEnabled(true);
		olvido.setVisible(true);

		reglas.gridy++;
		cp.add(olvido, reglas);

		pregunta = new JLabel("Pregunta De Seguridad:");
		pregunta.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		pregunta.setBackground(darkblue);
		pregunta.setVisible(false);

		reglas.gridx = 1;
		reglas.gridy = 3;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		cp.add(pregunta, reglas);

		tpregunta = new JTextField(8);
		tpregunta.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		tpregunta.setBackground(white);
		tpregunta.setEditable(false);
		tpregunta.setVisible(false);

		reglas.gridy++;
		cp.add(tpregunta, reglas);

		respuesta = new JLabel("Respuesta: ");
		respuesta.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		respuesta.setBackground(darkblue);
		respuesta.setVisible(false);

		reglas.gridx = 1;
		reglas.gridy++;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		cp.add(respuesta, reglas);

		trespuesta = new JTextField(8);
		trespuesta.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		trespuesta.setBackground(white);
		trespuesta.setEditable(false);
		trespuesta.setVisible(false);

		reglas.gridy++;
		cp.add(trespuesta, reglas);

		newpass = new JLabel("Nueva Contraseña:");
		newpass.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		newpass.setBackground(darkblue);
		newpass.setVisible(false);

		reglas.gridx = 1;
		reglas.gridy++;
		reglas.gridwidth = 1;
		reglas.fill = GridBagConstraints.HORIZONTAL;
		cp.add(newpass, reglas);

		tnewpass = new JPasswordField();
		tnewpass.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 14));
		tnewpass.setBackground(white);
		tnewpass.setVisible(false);
		tnewpass.setEditable(false);

		reglas.gridy++;
		cp.add(tnewpass, reglas);

		ingresar = new JButton();
		ingresar.setContentAreaFilled(false);
		ingresar.setIcon(new ImageIcon("recursos/img/ingresarMDI.png"));
		ingresar.setRolloverIcon(new ImageIcon("recursos/img/ingresarMDI2.png"));
		ingresar.setBackground(white);
		ingresar.setCursor(new Cursor(HAND_CURSOR));
		ingresar.setBorder(null);
		ingresar.addActionListener(this);
		ingresar.setVisible(true);
		ingresar.setEnabled(true);

		reglas.gridy = 10;
		cp.add(ingresar, reglas);

		aceptar = new JButton();
		aceptar.setContentAreaFilled(false);
		aceptar.setIcon(new ImageIcon("recursos/img/aceptarMDI.png"));
		aceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarMDI2.png"));
		aceptar.setBackground(white);
		aceptar.setCursor(new Cursor(HAND_CURSOR));
		aceptar.setBorder(null);
		aceptar.addActionListener(this);
		aceptar.setVisible(false);
		aceptar.setEnabled(false);

		reglas.gridy = 10;
		cp.add(aceptar, reglas);

		volver = new JButton();
		volver.setContentAreaFilled(false);
		volver.setIcon(new ImageIcon("recursos/img/volverMDI.png"));
		volver.setRolloverIcon(new ImageIcon("recursos/img/volver2.png"));
		volver.setBackground(white);
		volver.setCursor(new Cursor(HAND_CURSOR));
		volver.setBorder(null);
		volver.addActionListener(this);
		volver.setVisible(false);
		volver.setEnabled(false);

		reglas.gridy = 12;
		cp.add(volver, reglas);

		ingresar.setActionCommand(ILogin.INGRESAR);
		lupa.setActionCommand(ILogin.BUSCAR);
		aceptar.setActionCommand(ILogin.ACEPTAR);

		val.ValidarCantidad(tuser, 8);
		val.ValidarCantidad(tpass, 8);
		val.ValidarCantidad(tnewpass, 8);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton bt = (JButton) e.getSource();

		if (bt == olvido) {

			pass.setVisible(false);
			pregunta.setVisible(true);
			respuesta.setVisible(true);

			tpass.setVisible(false);
			tpregunta.setVisible(true);
			trespuesta.setVisible(true);

			olvido.setVisible(false);
			ingresar.setVisible(false);
			ingresar.setEnabled(false);
			olvido.setEnabled(false);

			aceptar.setVisible(true);
			volver.setVisible(true);
			volver.setEnabled(true);
			aceptar.setEnabled(true);

			lupa.setVisible(true);

			tnewpass.setVisible(true);
			newpass.setVisible(true);

		}

		if (bt == volver) {

			pass.setVisible(true);
			pregunta.setVisible(false);
			respuesta.setVisible(false);

			tpass.setVisible(true);
			tpregunta.setVisible(false);
			trespuesta.setVisible(false);

			olvido.setVisible(true);
			ingresar.setVisible(true);
			ingresar.setEnabled(true);
			olvido.setEnabled(true);

			aceptar.setVisible(false);
			volver.setVisible(false);
			volver.setEnabled(false);
			aceptar.setEnabled(false);

			tnewpass.setVisible(false);
			newpass.setVisible(false);

			lupa.setVisible(false);

			tnewpass.setText("");
			tuser.setText("");
			tpregunta.setText("");
			trespuesta.setText("");

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	private void salir() {
		Toolkit.getDefaultToolkit().beep();
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "SALIDA DEL SISTEMA",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub

		if (tuser.getText().equals("") || tuser.getText().length() < 8) {
			validez = false;
			MensajeError("El nombre de usuario debe tener 8 caracteres");
		} else
			validez = true;

		return tuser.getText();
	}

	@Override
	public String getContraseña() {
		// TODO Auto-generated method stub

		char[] arrayC = tpass.getPassword();
		String pass = new String(arrayC);

		if (pass.equals("") || pass.length() < 8) {
			validez = false;
			MensajeError("La contraseña debe tener 8 caracteres");
		} else
			validez = true;

		return pass;
	}

	@Override
	public void setController(CLogin c) {
		// TODO Auto-generated method stub
		ingresar.addActionListener(c);
		lupa.addActionListener(c);
		aceptar.addActionListener(c);
		volver.addActionListener(c);
	}

	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public boolean getValidez() {
		// TODO Auto-generated method stub
		return validez;
	}

	public void MensajeError(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void habilitar() {
		// TODO Auto-generated method stub
		trespuesta.setEditable(true);
		tnewpass.setEditable(true);
	}

	@Override
	public void setPregunta(String pregunta) {
		// TODO Auto-generated method stub
		tpregunta.setText(pregunta);
	}

	@Override
	public String getRespuesta() {
		// TODO Auto-generated method stub
		return trespuesta.getText();
	}

	@Override
	public String getNewPass() {
		// TODO Auto-generated method stub
		char[] arrayC = tnewpass.getPassword();
		String Npass = new String(arrayC);

		if (pass.equals("") || Npass.length() < 8) {
			validez = false;
			MensajeError("La contraseña debe tener 8 caracteres");
		} else
			validez = true;

		return Npass;
	}

	@Override
	public void LimpiarR() {
		// TODO Auto-generated method stub
		tnewpass.setText("");
		trespuesta.setText("");

	}

	@Override
	public void LimpiarUP() {
		// TODO Auto-generated method stub
		tuser.setText("");
		tpregunta.setText("");
		trespuesta.setText("");
		tnewpass.setText("");

	}

	public void volver() {
		// TODO Auto-generated method stub
		pass.setVisible(true);
		pregunta.setVisible(false);
		respuesta.setVisible(false);

		tpass.setVisible(true);
		tpregunta.setVisible(false);
		trespuesta.setVisible(false);

		olvido.setVisible(true);
		ingresar.setVisible(true);
		ingresar.setEnabled(true);
		olvido.setEnabled(true);

		aceptar.setVisible(false);
		volver.setVisible(false);
		volver.setEnabled(false);
		aceptar.setEnabled(false);

		tnewpass.setVisible(false);
		newpass.setVisible(false);

		lupa.setVisible(false);

		tnewpass.setText("");
		tuser.setText("");
		tpregunta.setText("");
		trespuesta.setText("");
		tpass.setText("");
	}

}
