package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CTipoPersona;

public class VTipoPersona extends JInternalFrame implements ITipoPersona, ActionListener {

	private JTextField id, identificador, nombre, borrado;
	private JPanel pde, piz;
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton BCaceptar, BMaceptar, BBaceptar, borrar, crear, limpiar, modificar, salir, lupa, exit;
	private JButton bBuscar;
	private Validacion val;
	private boolean valIden, valNom, cerrado = true;

	public VTipoPersona() {
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

		BCaceptar = new JButton();
		BCaceptar.setContentAreaFilled(false);
		BCaceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
		BCaceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
		BCaceptar.setBackground(darkblue);
		BCaceptar.setBorder(null);
		BCaceptar.setVisible(false);
		reglasiz.gridy++;

		piz.add(BCaceptar, reglasiz);

		BMaceptar = new JButton();
		BMaceptar.setContentAreaFilled(false);
		BMaceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
		BMaceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
		BMaceptar.setBackground(darkblue);
		BMaceptar.setBorder(null);
		BMaceptar.setVisible(false);
		reglasiz.gridy = 4;

		piz.add(BMaceptar, reglasiz);

		BBaceptar = new JButton();
		BBaceptar.setContentAreaFilled(false);
		BBaceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
		BBaceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
		BBaceptar.setBackground(darkblue);
		BBaceptar.setBorder(null);
		BBaceptar.setVisible(false);
		reglasiz.gridy = 4;

		piz.add(BBaceptar, reglasiz);

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

		pde = new JPanel();
		pde.setBackground(darkblue);

		GridBagLayout gbde = new GridBagLayout();
		gbde.columnWidths = new int[] { 150, 500, 50 };
		gbde.rowHeights = new int[] { 150, 100, 100, 100, 34, 33, 50 };
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);

		JLabel titulo = new JLabel("TIPO PERSONA");
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

		JLabel lidentificador = new JLabel("Identificador");
		lidentificador.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lidentificador.setForeground(white);
		lidentificador.setBackground(darkblue);
		reglasde.gridy = 1;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(lidentificador, reglasde);

		identificador = new JTextField(8);
		identificador.setBackground(white);
		identificador.setForeground(Color.BLACK);
		identificador.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 1;
		reglasde.gridx = 1;

		pde.add(identificador, reglasde);

		bBuscar = new JButton();
		bBuscar.setContentAreaFilled(false);
		bBuscar.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		bBuscar.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		bBuscar.setBackground(darkblue);
		bBuscar.setBorder(null);
		bBuscar.addActionListener(this);
		bBuscar.setVisible(true);
		reglasde.gridx = 2;

		bBuscar.setActionCommand(ITipoPersona.BUSCAR);

		pde.add(bBuscar, reglasde);

		JLabel lnombre = new JLabel("Nombre");
		lnombre.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lnombre.setForeground(white);
		lnombre.setBackground(darkblue);
		reglasde.gridy = 2;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		lnombre.setVisible(true);

		pde.add(lnombre, reglasde);

		nombre = new JTextField(8);
		nombre.setBackground(white);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 2;
		reglasde.gridx = 1;
		nombre.setEditable(false);
		nombre.setVisible(true);

		pde.add(nombre, reglasde);

		id = new JTextField(2);
		id.setVisible(false);
		reglasde.gridx = 2;
		reglasde.gridy = 3;
		reglasde.gridwidth = 1;
		reglasde.gridheight = 1;
		reglasde.weighty = 1.0;
		reglasde.weightx = 1.0;
		pde.add(id, reglasde);

		borrado = new JTextField(2);
		borrado.setVisible(false);
		reglasde.gridx = 2;
		reglasde.gridy = 3;
		reglasde.gridwidth = 1;
		reglasde.gridheight = 1;
		reglasde.weighty = 1.0;
		reglasde.weightx = 1.0;
		pde.add(borrado, reglasde);

		JLabel adv1 = new JLabel("El programa distinguira entre mayúsculas y minúsculas");
		adv1.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv1.setForeground(white);
		adv1.setBackground(darkblue);
		adv1.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridy = 3;
		reglasde.gridx = 0;
		reglasde.gridwidth = 3;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(adv1, reglasde);

		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(piz, rules);

		rules.gridx = 1;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pde, rules);
		cp.add(pde);

		bBuscar.setActionCommand(ITipoPersona.BUSCAR);
		BCaceptar.setActionCommand(ITipoPersona.CREAR);
		BMaceptar.setActionCommand(ITipoPersona.MODIFICAR);
		BBaceptar.setActionCommand(ITipoPersona.BORRAR);
		limpiar.setActionCommand(ITipoPersona.LIMPIAR);
		exit.setActionCommand(ITipoPersona.EXIT);

		val = new Validacion();
		val.ValidarCantidad(identificador, 1);
		val.ValidarCantidad(nombre, 100);
	}

	@Override
	public void setControlador(CTipoPersona c) {
		// TODO Auto-generated method stub
		BCaceptar.addActionListener(c);
		BMaceptar.addActionListener(c);
		BBaceptar.addActionListener(c);
		limpiar.addActionListener(c);
		bBuscar.addActionListener(c);
		exit.addActionListener(c);
	}

	@Override
	public void escribir(String id, String identificador, String nombre, String borrado) {
		// TODO Auto-generated method stub
		this.id.setText(id);
		this.identificador.setText(identificador);
		this.nombre.setText(nombre);
		this.borrado.setText(borrado);
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return Integer.parseInt(id.getText().toUpperCase());
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return identificador.getText().toUpperCase();
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stu
		return nombre.getText().toUpperCase();
	}

	@Override
	public boolean getborr() {
		// TODO Auto-generated method stub
		return false;
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
			BCaceptar.setVisible(true);
			BMaceptar.setVisible(false);
			BBaceptar.setVisible(false);
			limpiar.setVisible(true);
			salir.setVisible(true);
			nombre.setEditable(true);
			bBuscar.setVisible(false);

			identificador.setText("");
			nombre.setText("");
		}
		if (bt == modificar) {
			crear.setVisible(false);
			modificar.setVisible(true);
			borrar.setVisible(false);
			BCaceptar.setVisible(false);
			BMaceptar.setVisible(true);
			BBaceptar.setVisible(false);
			limpiar.setVisible(true);
			salir.setVisible(true);
			bBuscar.setVisible(false);

			nombre.setEditable(true);
		}

		if (bt == borrar) {
			crear.setVisible(false);
			modificar.setVisible(false);
			borrar.setVisible(true);
			BCaceptar.setVisible(false);
			BMaceptar.setVisible(false);
			BBaceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			bBuscar.setVisible(false);
			identificador.setEditable(false);
		}

		if (bt == salir) {

			crear.setVisible(true);
			modificar.setVisible(true);
			borrar.setVisible(true);
			BCaceptar.setVisible(false);
			BMaceptar.setVisible(false);
			BBaceptar.setVisible(false);
			limpiar.setVisible(false);
			salir.setVisible(false);
			bBuscar.setVisible(true);
			identificador.setEditable(true);
			identificador.setText("");
			nombre.setText("");

			nombre.setEditable(false);
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
	public boolean getValIdentificador() {
		// TODO Auto-generated method stub
		if (identificador.getText().length() < 1) {
			return valIden = false;
		} else {
			return valIden = true;
		}
	}

	@Override
	public boolean getValNombre() {
		// TODO Auto-generated method stub
		if (nombre.getText().length() < 5) {
			return valNom = false;
		} else {
			return valNom = true;
		}
	}

	@Override
	public void volveralmenu() {
		// TODO Auto-generated method stub
		crear.setVisible(true);
		modificar.setVisible(true);
		borrar.setVisible(true);
		BCaceptar.setVisible(false);
		BMaceptar.setVisible(false);
		BBaceptar.setVisible(false);
		limpiar.setVisible(false);
		salir.setVisible(false);
		bBuscar.setVisible(true);
		identificador.setEditable(true);
		identificador.setText("");
		nombre.setText("");

		nombre.setEditable(false);
	}

	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}
}
