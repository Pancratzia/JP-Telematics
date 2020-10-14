package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CDepartamento;

public  class VDepartamento extends JInternalFrame implements ActionListener, IDepartamento {

	private JPanel pde, piz;
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton aceptar, borrar, crear, limpiar, modificar, salir, lupa, exit;
	private JTextField tcod, tnom;
	private Validacion val;
	private boolean validez, cerrado = true;

	public VDepartamento() {

		this.setSize(1000, 600);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);

		Container cp = getContentPane();
		cp.setBackground(darkblue);

		GridBagLayout gb = new GridBagLayout();
		gb.columnWidths = new int[] { 250, 750 };
		gb.rowHeights = new int[] { 600 };
		GridBagConstraints rules = new GridBagConstraints();

		cp.setLayout(gb);

		// PANEL IZQUIERDO - BOTONES//

		piz = new JPanel();
		piz.setBackground(white);
		GridBagLayout gbiz = new GridBagLayout();
		gbiz.rowHeights = new int[] { 175, 60, 60, 60, 60, 60, 60 };
		GridBagConstraints reglasiz = new GridBagConstraints();
		piz.setLayout(gbiz);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("recursos/img/logo.png"));
		logo.setBackground(darkblue);
		reglasiz.gridx = 0;
		reglasiz.gridy = 0;
		reglasiz.fill = GridBagConstraints.NONE;

		piz.add(logo, reglasiz);

		crear = new JButton();
		crear.setContentAreaFilled(false);
		crear.setIcon(new ImageIcon("recursos/img/crearON.png"));
		crear.setRolloverIcon(new ImageIcon("recursos/img/crearOFF.png"));
		crear.setBackground(darkblue);
		crear.setBorder(null);
		crear.addActionListener(this);

		reglasiz.gridy++;

		piz.add(crear, reglasiz);

		modificar = new JButton();
		modificar.setContentAreaFilled(false);
		modificar.setIcon(new ImageIcon("recursos/img/modificarON.png"));
		modificar.setRolloverIcon(new ImageIcon("recursos/img/modificarOFF.png"));
		modificar.setBackground(darkblue);
		modificar.setBorder(null);
		reglasiz.gridy++;
		modificar.addActionListener(this);

		piz.add(modificar, reglasiz);

		borrar = new JButton();
		borrar.setContentAreaFilled(false);
		borrar.setIcon(new ImageIcon("recursos/img/borrarON.png"));
		borrar.setRolloverIcon(new ImageIcon("recursos/img/borrarOFF.png"));
		borrar.setBackground(darkblue);
		borrar.setBorder(null);
		reglasiz.gridy++;
		borrar.addActionListener(this);

		piz.add(borrar, reglasiz);

		aceptar = new JButton();
		aceptar.setContentAreaFilled(false);
		aceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
		aceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
		aceptar.setBackground(darkblue);
		aceptar.setBorder(null);
		aceptar.setVisible(false);
		reglasiz.gridy++;

		piz.add(aceptar, reglasiz);

		limpiar = new JButton();
		limpiar.setContentAreaFilled(false);
		limpiar.setIcon(new ImageIcon("recursos/img/limpiarON.png"));
		limpiar.setRolloverIcon(new ImageIcon("recursos/img/limpiarOFF.png"));
		limpiar.setBackground(darkblue);
		limpiar.setBorder(null);
		limpiar.setVisible(false);
		reglasiz.gridy++;

		piz.add(limpiar, reglasiz);

		salir = new JButton();
		salir.setContentAreaFilled(false);
		salir.setIcon(new ImageIcon("recursos/img/salirON.png"));
		salir.setRolloverIcon(new ImageIcon("recursos/img/salirOFF.png"));
		salir.setBackground(darkblue);
		salir.setBorder(null);
		salir.setVisible(false);
		reglasiz.gridy++;
		salir.addActionListener(this);

		piz.add(salir, reglasiz);

		// PANEL DERECHO//
		pde = new JPanel();
		pde.setBackground(darkblue);

		GridBagLayout gbde = new GridBagLayout();
		gbde.columnWidths = new int[] { 100, 550, 50 };
		gbde.rowHeights = new int[] { 100, 50, 50, 50, 15, 15, 350 }; // Aqui colocas las filas que necesite tu panel
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);

		JLabel titulo = new JLabel("DEPARTAMENTOS");
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 30));
		titulo.setForeground(white);
		titulo.setBackground(darkblue);
		reglasde.gridy = 0;
		reglasde.gridx = 1;

		pde.add(titulo, reglasde);

		exit = new JButton();
		exit.setContentAreaFilled(false);
		exit.setIcon(new ImageIcon("recursos/img/exitON.png"));
		exit.setRolloverIcon(new ImageIcon("recursos/img/exitOFF.png"));
		exit.setBackground(darkblue);
		exit.setBorder(null);
		exit.addActionListener(this);
		reglasde.gridx = 2;

		pde.add(exit, reglasde);

		JLabel codigo = new JLabel("Código: ");
		codigo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		codigo.setForeground(white);
		codigo.setBackground(darkblue);
		reglasde.gridy = 1;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(codigo, reglasde);

		tcod = new JTextField(4);
		tcod.setBackground(white);
		tcod.setForeground(Color.BLACK);
		tcod.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 1;
		reglasde.gridx = 1;
		pde.add(tcod, reglasde);

		lupa = new JButton();
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.addActionListener(this);
		reglasde.gridx = 2;

		pde.add(lupa, reglasde);

		JLabel nombre = new JLabel("Nombre: ");
		nombre.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		nombre.setForeground(white);
		nombre.setBackground(darkblue);
		reglasde.gridy = 2;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(nombre, reglasde);

		tnom = new JTextField(4);
		tnom.setBackground(white);
		tnom.setForeground(Color.BLACK);
		tnom.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 2;
		reglasde.gridx = 1;
		tnom.setEditable(false);
		pde.add(tnom, reglasde);


		JLabel adv1 = new JLabel("*El código debe tener 4 caracteres");
		adv1.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv1.setForeground(white);
		adv1.setBackground(darkblue);
		adv1.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridy = 4;
		reglasde.gridx = 0;
		reglasde.gridwidth = 3;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(adv1, reglasde);

		JLabel adv2 = new JLabel("*El programa no diferenciará entre mayúsculas y minúsculas");
		adv2.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv2.setForeground(white);
		adv2.setBackground(darkblue);
		adv2.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridy = 5;
		reglasde.gridx = 0;
		reglasde.gridwidth = 3;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(adv2, reglasde);

		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(piz, rules);

		rules.gridx = 1;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pde, rules);

		// VALIDACIONES//

		val = new Validacion();
		val.ValidarCantidad(tnom, 100);
		val.ValidarCantidad(tcod, 4);

		// ActionCommand

		lupa.setActionCommand(IDepartamento.BUSCAR);
		aceptar.setActionCommand(IDepartamento.ACEPTAR);
		limpiar.setActionCommand(IDepartamento.LIMPIAR);
		exit.setActionCommand(IDepartamento.EXIT);
		salir.setActionCommand(IDepartamento.SALIR);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.toFront();
		this.show();
		cerrado = false;
		try {
			this.setClosed(false);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton bt = (JButton) e.getSource();

		if (bt == crear) {
			crear.setVisible(true);
			modificar.setVisible(false);
			borrar.setVisible(false);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			crear.setEnabled(false);
			modificar.setEnabled(true);
			borrar.setEnabled(true);
			tnom.setEditable(true);
			tnom.setText("");
			tcod.setText("");
			lupa.setVisible(false);
		}
		if (bt == modificar) {
			crear.setVisible(false);
			modificar.setVisible(true);
			borrar.setVisible(false);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			modificar.setEnabled(false);
			crear.setEnabled(true);
			borrar.setEnabled(true);
			tnom.setEditable(true);
			lupa.setVisible(true);
		}
		if (bt == borrar) {
			crear.setVisible(false);
			modificar.setVisible(false);
			borrar.setVisible(true);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			borrar.setEnabled(false);
			crear.setEnabled(true);
			modificar.setEnabled(true);
			tnom.setEditable(false);
			lupa.setVisible(true);
		}
		if (bt == salir) {
			crear.setVisible(true);
			modificar.setVisible(true);
			borrar.setVisible(true);
			aceptar.setVisible(false);
			limpiar.setVisible(false);
			salir.setVisible(false);
			crear.setEnabled(true);
			modificar.setEnabled(true);
			borrar.setEnabled(true);
			tnom.setEditable(false);
			tnom.setText("");
			tcod.setText("");
			lupa.setVisible(true);
		}


	}

	@Override
	public void salir() {
		// TODO Auto-generated method stub
		try {
			this.setClosed(true);
			cerrado = true;
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	
	@Override
	public int getOperacion() {
		// TODO Auto-generated method stub
		int operacion = 0;

		if (crear.isEnabled() == false) {
			operacion = 0;
		}
		else if (modificar.isEnabled() == false) {
			operacion = 1;
		}
		else if (borrar.isEnabled() == false) {
			operacion = 2;
		}
		else {
			operacion = 3;
		}

		return operacion;
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		tnom.setText("");
		tcod.setText("");
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		if (tnom.getText().toString().equals("")) {
			validez = false;
			MensajeError("DEBE INGRESAR UN NOMBRE VALIDO");
		} else {
			validez = true;
		}
		return tnom.getText().toUpperCase();
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		if (tcod.getText().length() < 4) {
			validez = false;
			MensajeError("EL CÓDIGO DEBE TENER CUATRO (4) CARACTERES");
		} else {
			validez = true;
		}
		return tcod.getText().toUpperCase();
	}

	
	public void MensajeError(String mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public boolean getValidez() {
		// TODO Auto-generated method stub
		return validez;
	}

	

	@Override
	public void VolverAlMenu() {
		// TODO Auto-generated method stub
		crear.setVisible(true);
		modificar.setVisible(true);
		borrar.setVisible(true);
		aceptar.setVisible(false);
		limpiar.setVisible(false);
		salir.setVisible(false);
		crear.setEnabled(true);
		modificar.setEnabled(true);
		borrar.setEnabled(true);
		tnom.setEditable(false);
		tnom.setText("");
		tcod.setText("");
		lupa.setVisible(true);
	}

	@Override
	public int Preguntar(String pregunta) {
		// TODO Auto-generated method stub

		if (JOptionPane.showConfirmDialog(null, pregunta, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			return 1;
		} else
			return 0;
	}



	@Override
	public void escribir(String tcod,String tnom) {
		// TODO Auto-generated method stub
		this.tcod.setText(tcod);
		this.tnom.setText(tnom);
	}

	

	@Override
	public void setcontroller(CDepartamento c) {
		// TODO Auto-generated method stub
		aceptar.addActionListener(c);
		limpiar.addActionListener(c);
		lupa.addActionListener(c);
		exit.addActionListener(c);
		salir.addActionListener(c);
	}

	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}

	

	

}
