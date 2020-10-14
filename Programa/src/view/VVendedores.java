package view;

import java.awt.Color;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CVendedores;

public class VVendedores extends JInternalFrame implements ActionListener, IVendedores, ItemListener {

	private JPanel pde, piz, pinf;
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton aceptar, borrar, crear, limpiar, modificar, salir, lupa, exit;
	private JTextField tci, tnom, ttel, tzon, tidZon;
	private JLabel lci, lzonvc, lzonvc2;
	private JComboBox<?> czon;
	private ComboBoxModel cbm;
	CVendedores controlador;
	private Validacion val;
	private boolean validez;
	private boolean cerrado= true;

	public VVendedores() {

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
		limpiar.addActionListener(this);
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
		gbde.columnWidths = new int[] { 120, 530, 50 }; // Ancho
		gbde.rowHeights = new int[] { 100, 50, 50, 50, 50, 15, 235, 80 }; // Aqui colocas las filas que necesite tu
																			// panel
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);

		JLabel titulo = new JLabel("VENDEDORES");
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
		reglasde.gridx = 2;
		reglasde.anchor = GridBagConstraints.CENTER;

		pde.add(exit, reglasde);

		lci = new JLabel("Cédula:  ");
		lci.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lci.setForeground(white);
		lci.setBackground(darkblue);
		reglasde.gridx = 0;
		reglasde.gridy = 1;
		reglasde.gridwidth = 1;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		reglasde.anchor = GridBagConstraints.CENTER;
		pde.add(lci, reglasde);

		tci = new JTextField(100);
		tci.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridx = 1;
		reglasde.gridy = 1;
		pde.add(tci, reglasde);

		lupa = new JButton();
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.addActionListener(this);
		reglasde.gridx = 2;
		reglasde.gridy = 1;
		pde.add(lupa, reglasde);

		JLabel lnomvc = new JLabel("Nombre: ");
		lnomvc.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lnomvc.setForeground(white);
		lnomvc.setBackground(darkblue);
		reglasde.gridx = 0;
		reglasde.gridy = 2;
		pde.add(lnomvc, reglasde);

		tnom = new JTextField(100);
		tnom.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tnom.setEditable(false);
		reglasde.gridx = 1;
		reglasde.gridy = 2;
		pde.add(tnom, reglasde);

		JLabel ltelfvc = new JLabel("Teléfono: ");
		ltelfvc.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		ltelfvc.setForeground(white);
		ltelfvc.setBackground(darkblue);
		reglasde.gridx = 0;
		reglasde.gridy = 3;
		pde.add(ltelfvc, reglasde);

		ttel = new JTextField(10);
		ttel.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		ttel.setEditable(false);
		reglasde.gridx = 1;
		reglasde.gridy = 3;
		pde.add(ttel, reglasde);

		lzonvc = new JLabel("Zona asignada: ");
		lzonvc.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lzonvc.setForeground(white);
		lzonvc.setBackground(darkblue);
		reglasde.gridx = 0;
		reglasde.gridy = 4;
		pde.add(lzonvc, reglasde);

		lzonvc2 = new JLabel("Seleccione Zona: ");
		lzonvc2.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lzonvc2.setForeground(white);
		lzonvc2.setBackground(darkblue);
		lzonvc2.setVisible(false);
		pde.add(lzonvc2, reglasde);

		tzon = new JTextField(10);
		tzon.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tzon.setEditable(false);
		reglasde.gridx = 1;
		reglasde.gridy = 4;
		pde.add(tzon, reglasde);

		czon = new JComboBox<>();
		czon.addItemListener(this);
		czon.setVisible(false);
		pde.add(czon, reglasde);

		tidZon = new JTextField();
		tidZon.setVisible(false);
		pde.add(tidZon);

		JLabel adv = new JLabel("*El programa no diferenciará entre mayúsculas y minúsculas");
		adv.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv.setForeground(white);
		adv.setBackground(darkblue);
		adv.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridx = 1;
		reglasde.gridy = 5;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(adv, reglasde);

		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(piz, rules);

		rules.gridx = 1;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pde, rules);

		val = new Validacion();
		val.ValidarCantidad(tci, 8);
		val.ValidarCantidad(tnom, 100);
		val.ValidarCantidad(ttel, 11);
		val.ValidarCantidad(tzon, 6);

		lupa.setActionCommand(IVendedores.BUSCAR);
		aceptar.setActionCommand(IVendedores.ACEPTAR);
		limpiar.setActionCommand(IVendedores.LIMPIAR);
		salir.setActionCommand(IVendedores.SALIR);
		exit.setActionCommand(IVendedores.EXIT);
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
			lupa.setVisible(false);
			tzon.setVisible(false);
			czon.setVisible(true);
			lzonvc.setVisible(false);
			lzonvc2.setVisible(true);

			tnom.setEditable(true);
			ttel.setEditable(true);
			tzon.setEditable(true);

			tci.setText("");
			tnom.setText("");
			ttel.setText("");
			tzon.setText("");

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

			tnom.setEditable(false);
			ttel.setEditable(false);
			tzon.setEditable(false);

			lupa.setVisible(true);
			lzonvc.setVisible(true);
			lzonvc2.setVisible(false);

			tci.setText("");
			tnom.setText("");
			ttel.setText("");
			tzon.setText("");

		}

		if (bt == lupa && modificar.isEnabled() == false) {
			tnom.setEditable(true);
			ttel.setEditable(true);
			tzon.setEditable(true);
			tzon.setVisible(false);
			czon.setVisible(true);
			lzonvc.setVisible(false);
			lzonvc2.setVisible(true);
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

			lzonvc.setVisible(true);
			lzonvc2.setVisible(false);
			lupa.setVisible(true);

			tnom.setEditable(false);
			ttel.setEditable(false);
			tzon.setEditable(false);

			tci.setText("");
			tnom.setText("");
			ttel.setText("");
			tzon.setText("");

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
			ttel.setEditable(false);
			tzon.setEditable(false);
			tci.setText("");
			tnom.setText("");
			ttel.setText("");
			tzon.setText("");
			lupa.setVisible(true);
			tzon.setVisible(true);
			czon.setVisible(false);
			lzonvc.setVisible(true);
			lzonvc2.setVisible(false);
		}

	}

	@Override
	public void salir() {
		try {
			this.setClosed(true);
			cerrado = true;
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setController(CVendedores c) {
		// TODO Auto-generated method stub

		controlador = c;
		lupa.addActionListener(c);
		aceptar.addActionListener(c);
		limpiar.addActionListener(c);
		salir.addActionListener(c);
		exit.addActionListener(c);
	}

	@Override
	public int getOperacion() {
		// TODO Auto-generated method stub
		int operacion = 0;

		if (crear.isEnabled() == false) {
			operacion = 0;
		} else if (modificar.isEnabled() == false) {
			operacion = 1;
		} else if (borrar.isEnabled() == false) {
			operacion = 2;
		} else {
			operacion = 3;
		}

		return operacion;
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		tci.setText("");
		tnom.setText("");
		ttel.setText("");
		tzon.setText("");
		czon.setSelectedIndex(0);

	}

	@Override
	public String getCi() {

		int valor;
		try {
			valor = Integer.parseInt(tci.getText());
			validez = true;
		} catch (Exception e) {
			MensajeError("ERROR. LA CÉDULA SOLO DEBE ESTAR COMPUESTA DE CARACTERES NUMERICOS");
			validez = false;
			tci.setText("");
		}

		if (validez) {
			if (tci.getText().length() < 7) {
				validez = false;
				tci.setText("");
				MensajeError("LA CÉDULA DEBE TENER OCHO (8) O SIETE (7) CARACTERES");
			} else {
				validez = true;
			}
		}

		return tci.getText().toUpperCase();

	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		if (tnom.getText().toString().equals("")) {
			validez = false;
			MensajeError("DEBE INGRESAR UN NOMBRE VÁLIDO");
		} else {
			validez = true;
		}
		return tnom.getText().toUpperCase();
	}

	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub

		long valor2;
		
		try {
			valor2 = Long.parseLong(ttel.getText());
			validez = true;
		} catch (Exception e) {
			MensajeError("DEBE INGRESAR UN NÚMERO DE TELÉFONO VÁLIDO");
			validez = false;
			ttel.setText("");
		}

		if (validez) {
			if (ttel.getText().toString().equals("")) {
				validez = false;
				ttel.setText("");
				MensajeError("DEBE INGRESAR UN NÚMERO DE TELÉFONO VÁLIDO");
			} else {
				validez = true;
			}

		}

		return ttel.getText().toUpperCase();
	}

	@Override
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
	public void escribir(String tnom, String ttel, String tzon) {
		// TODO Auto-generated method stub
		this.tnom.setText(tnom);
		this.ttel.setText(ttel);
		this.tzon.setText(tzon);

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
		ttel.setEditable(false);
		tzon.setEditable(false);
		tci.setText("");
		tnom.setText("");
		ttel.setText("");
		tzon.setText("");
		lupa.setVisible(true);

		lzonvc.setVisible(true);
		lzonvc2.setVisible(false);
		czon.setVisible(false);
		czon.setSelectedIndex(0);
		tzon.setVisible(true);

	}

	public int Preguntar(String pregunta) {
		// TODO Auto-generated method stub

		if (JOptionPane.showConfirmDialog(null, pregunta, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			return 1;
		} else
			return 0;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED)
			controlador.actionPerformed(new ActionEvent(this, 1, IVendedores.COMBOI));

	}

	@Override
	public void setCombo(DefaultComboBoxModel<?> dcbm) {
		// TODO Auto-generated method stub
		this.cbm = dcbm;
	}

	@Override
	public void setIdZona(String id) {
		// TODO Auto-generated method stub
		tidZon.setText(id);
	}

	@Override
	public void desplegar() {
		// TODO Auto-generated method stub
		controlador.actionPerformed(new ActionEvent(this, 2, IVendedores.COMBO));
		czon.setModel(cbm);
	}

	@Override
	public Object getComboItem() {
		// TODO Auto-generated method stub
		return czon.getSelectedItem();
	}

	@Override
	public int getIdZona() {
		// TODO Auto-generated method stub
		int id = 0;
		if (czon.getSelectedIndex() == 0) {
			return 0;
		} else {
			return Integer.parseInt(tidZon.getText());
		}
	}

	@Override
	public void ValCombo() {
		// TODO Auto-generated method stub
		if (czon.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA ZONA EXISTENTE", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		} else if (czon.getSelectedIndex() == -1) {
			czon.getSelectedItem();
		}
	}
	
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}
}