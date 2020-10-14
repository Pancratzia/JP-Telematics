package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CUsuarios;
import model.MPreguntas;
import model.ObtenerPreguntas;

public class VUsuarios extends JInternalFrame implements ActionListener, IUsuarios, ItemListener {

	private JPanel pde, piz, botones;
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton aceptar, borrar, crear, limpiar, modificar, salir, lupa, exit, lupa1;
	private JTextField tuser, tname, tres, tcod, tdep, tpreg, tid;
	private JComboBox<String> cbp;
	private ComboBoxModel cbm;
	CUsuarios controlador;
	private JPasswordField tpass;
	private JRadioButton rbadmin, rbnonadmin;
	private ButtonGroup grupo;
	private Validacion val;
	private JLabel contra, ladmin, RESP;
	private boolean validez, cerrado = true;

	public VUsuarios() {

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
		modificar.setVisible(false);

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
		gbde.rowHeights = new int[] { 100, 50, 50, 50, 50, 50, 50, 50, 50,130}; // Aqui colocas las filas que necesite tu panel
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);

		JLabel titulo = new JLabel("USUARIOS");
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

		JLabel usuario = new JLabel("Usuario: ");
		usuario.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		usuario.setForeground(white);
		usuario.setBackground(darkblue);
		reglasde.gridy = 1;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(usuario, reglasde);

		tuser = new JTextField(8);
		tuser.setBackground(white);
		tuser.setForeground(Color.BLACK);
		tuser.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 1;
		reglasde.gridx = 1;
		pde.add(tuser, reglasde);
		
		lupa1 = new JButton();
		lupa1.setContentAreaFilled(false);
		lupa1.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa1.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa1.setBackground(darkblue);
		lupa1.setBorder(null);
		lupa1.addActionListener(this);
		lupa1.setVisible(true);
		reglasde.gridx = 2;
		
		pde.add(lupa1, reglasde);

		contra = new JLabel("Contraseña: ");
		contra.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		contra.setForeground(white);
		contra.setBackground(darkblue);
		contra.setVisible(false);
		reglasde.gridy = 2;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(contra, reglasde);

		tpass = new JPasswordField(8);
		tpass.setBackground(white);
		tpass.setForeground(Color.BLACK);
		tpass.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tpass.setVisible(false);
		reglasde.gridy = 2;
		reglasde.gridx = 1;
		pde.add(tpass, reglasde);

		JLabel nom = new JLabel("Nombre: ");
		nom.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		nom.setForeground(white);
		nom.setBackground(darkblue);
		reglasde.gridy = 3;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(nom, reglasde);

		tname = new JTextField();
		tname.setBackground(white);
		tname.setForeground(Color.BLACK);
		tname.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tname.setEditable(false);
		reglasde.gridy = 3;
		reglasde.gridx = 1;
		pde.add(tname, reglasde);
		
		JLabel pregu = new JLabel("Pregunta: ");
		pregu.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		pregu.setForeground(white);
		pregu.setBackground(darkblue);
		reglasde.gridy = 4;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(pregu, reglasde);
		
		tpreg = new JTextField();

		tpreg.setBackground(white);
		tpreg.setForeground(Color.BLACK);
		tpreg.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tpreg.setEditable(false);
		tpreg.setVisible(true);
		
		reglasde.gridy = 4;
		reglasde.gridx = 1;
		
		pde.add(tpreg,reglasde);
		
		cbp = new JComboBox<>();
		reglasde.gridy = 4;
		reglasde.gridx = 1;
		cbp.setVisible(false);
		pde.add(cbp, reglasde);
		cbp.addItemListener(this);;
		
		tid = new JTextField(10);
		tid.setVisible(false);
		pde.add(tid, reglasde);

		RESP = new JLabel("Respuesta: ");
		RESP.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		RESP.setForeground(white);
		RESP.setBackground(darkblue);
		RESP.setVisible(false);
		reglasde.gridy = 5;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(RESP, reglasde);

		tres = new JTextField();
		tres.setBackground(white);
		tres.setForeground(Color.BLACK);
		tres.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tres.setVisible(false);
		tres.setEditable(false);
		reglasde.gridy = 5;
		reglasde.gridx = 1;
		pde.add(tres, reglasde);
		
		JLabel cdep = new JLabel("C. Departamento: ");
		cdep.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 17));
		cdep.setForeground(white);
		cdep.setBackground(darkblue);
		reglasde.gridy = 6;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(cdep, reglasde);

		tcod = new JTextField();
		tcod.setBackground(white);
		tcod.setForeground(Color.BLACK);
		tcod.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 6;
		reglasde.gridx = 1;
		tcod.setEditable(false);
		pde.add(tcod, reglasde);
		
		lupa = new JButton();
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.addActionListener(this);
		lupa.setVisible(false);
		reglasde.gridx = 2;

		pde.add(lupa, reglasde);
		
		JLabel ndep = new JLabel("N. Departamento: ");
		ndep.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 17));
		ndep.setForeground(white);
		ndep.setBackground(darkblue);
		reglasde.gridy = 7;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(ndep, reglasde);

		tdep = new JTextField();
		tdep.setBackground(white);
		tdep.setForeground(Color.BLACK);
		tdep.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 7;
		reglasde.gridx = 1;
		tdep.setEditable(false);
		pde.add(tdep, reglasde);
		
		JLabel adm = new JLabel("Administrador: ");
		adm.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		adm.setForeground(white);
		adm.setBackground(darkblue);
		reglasde.gridy = 8;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(adm, reglasde);
		
		botones = new JPanel();
		botones.setOpaque(false);
		
		rbadmin = new JRadioButton("Administrador");
		rbadmin.setBackground(darkblue);
		rbadmin.setForeground(Color.WHITE);
		rbadmin.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 18));
		rbadmin.setSelected(false);
		botones.add(rbadmin);
		
		rbnonadmin = new JRadioButton("No Administrador");
		rbnonadmin.setBackground(darkblue);
		rbnonadmin.setForeground(Color.WHITE);
		rbnonadmin.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 18));
		rbnonadmin.setSelected(false);
		botones.add(rbnonadmin);
		
		grupo = new ButtonGroup();
		grupo.add(rbadmin);
		grupo.add(rbnonadmin);
		
		reglasde.gridy = 8;
		reglasde.gridx = 1;
		botones.setVisible(false);
		pde.add(botones, reglasde);
		
		ladmin = new JLabel("");
		pde.add(ladmin, reglasde);
		

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
		val.ValidarCantidad(tpass, 8);
		val.ValidarCantidad(tuser, 8);
		val.ValidarCantidad(tname, 100);
		val.ValidarCantidad(tres, 100);
		val.ValidarCantidad(tcod, 4);

		// ActionCommand

		lupa1.setActionCommand(IUsuarios.BUSCAR1);
		lupa.setActionCommand(IUsuarios.BUSCAR);
		aceptar.setActionCommand(IUsuarios.ACEPTAR);
		limpiar.setActionCommand(IUsuarios.LIMPIAR);
		exit.setActionCommand(IUsuarios.EXIT);
		salir.setActionCommand(IUsuarios.SALIR);

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
			
			lupa.setVisible(true);
			lupa1.setVisible(false);
			
			RESP.setVisible(true);
			contra.setVisible(true);
			botones.setVisible(true);
			ladmin.setVisible(false);
			tpass.setVisible(true);
			tres.setVisible(true);
			tpreg.setVisible(false);
			
			//Hacer visible el comboBox
			
			tuser.setEditable(true);
			tpass.setEditable(true);
			tname.setEditable(true);
			tres.setEditable(true);
			tcod.setEditable(true);
			
			tuser.setVisible(true);
			tpass.setVisible(true);
			tname.setVisible(true);
			tres.setVisible(true);
			tcod.setVisible(true);
			
			tuser.setText("");
			tpass.setText("");
			tname.setText("");
			tres.setText("");
			tcod.setText("");
			tpreg.setText("");
			
			rbadmin.setSelected(true);
			cbp.setVisible(true);

			modificar.setVisible(false);
			
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
			lupa.setVisible(true);
			lupa1.setVisible(true);
			
			RESP.setVisible(true);
			contra.setVisible(true);
			botones.setVisible(true);
			ladmin.setVisible(false);
			tpass.setVisible(true);
			tres.setVisible(true);
			tpreg.setVisible(false);
			
			//Hacer visible el comboBox
			
			tuser.setEditable(true);
			tpass.setEditable(true);
			tname.setEditable(true);
			tres.setEditable(true);
			tcod.setEditable(true);
			
			tuser.setVisible(true);
			tpass.setVisible(true);
			tname.setVisible(true);
			tres.setVisible(true);
			tcod.setVisible(true);
			
			tpass.setText("");
			tname.setText("");
			tres.setText("");
			tcod.setText("");
			tpreg.setText("");
			
			cbp.setVisible(true);

			modificar.setVisible(false);
		
		}
		if (bt == borrar) {
			ladmin.setText("");
			
			crear.setVisible(false);
			modificar.setVisible(false);
			borrar.setVisible(true);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			borrar.setEnabled(false);
			crear.setEnabled(true);
			modificar.setEnabled(true);
			
			lupa.setVisible(false);
			lupa1.setVisible(true);
			
			RESP.setVisible(false);
			contra.setVisible(false);
			botones.setVisible(false);
			ladmin.setVisible(false);
			tpass.setVisible(true);
			tres.setVisible(true);
			tpreg.setVisible(true);
			
			cbp.setVisible(false);
			
			//Hacer visible el comboBox
			
			tuser.setEditable(true);
			tpass.setEditable(false);
			tname.setEditable(false);
			tres.setEditable(false);
			tcod.setEditable(false);
			
			tuser.setVisible(true);
			tpass.setVisible(false);
			tname.setVisible(true);
			tres.setVisible(false);
			tcod.setVisible(true);
			
			tpass.setText("");
			tname.setText("");
			tres.setText("");
			tcod.setText("");
			tpreg.setText("");
			cbp.setVisible(false);
			ladmin.setVisible(true);
			ladmin.setText("");
			botones.setVisible(false);
			tdep.setText("");

			modificar.setVisible(false);
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
			tcod.setText("");
			lupa.setVisible(true);
			
			lupa.setVisible(false);
			lupa1.setVisible(true);
			
			RESP.setVisible(false);
			contra.setVisible(false);
			botones.setVisible(false);
			ladmin.setVisible(false);
			tpass.setVisible(true);
			tres.setVisible(false);
			tpreg.setVisible(true);
			
			//Hacer invisible el comboBox
			
			tuser.setEditable(true);
			tpass.setEditable(false);
			tname.setEditable(false);
			tres.setEditable(false);
			tcod.setEditable(false);
			
			tuser.setVisible(true);
			tpass.setVisible(false);
			tname.setVisible(true);
			tres.setVisible(false);
			tcod.setVisible(true);
			
			tuser.setText("");
			tpass.setText("");
			tname.setText("");
			tres.setText("");
			tcod.setText("");
			tpreg.setText("");
			
			cbp.setVisible(false);
			ladmin.setVisible(true);
			ladmin.setText("");
			botones.setVisible(false);
			tdep.setText("");

			modificar.setVisible(false);
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
	public void setController(CUsuarios c) {
		// TODO Auto-generated method stub
		aceptar.addActionListener(c);
		limpiar.addActionListener(c);
		lupa.addActionListener(c);
		exit.addActionListener(c);
		salir.addActionListener(c);
		lupa1.addActionListener(c);

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
		tuser.setText("");
		tpass.setText("");
		tname.setText("");
		tres.setText("");
		tcod.setText("");
		tdep.setText("");
		tpreg.setText("");
		ladmin.setText("");
		
		rbadmin.setSelected(true);
		cbp.setSelectedIndex(0);

		modificar.setVisible(false);
		
	}

	////////LOS METODOS DE ABAJO SON DE PRODUCTO. ARREGLEN ESO OMG
	
	
	
	
	
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		if (tname.getText().toString().equals("")) {
			validez = false;
			MensajeError("DEBE INGRESAR UN NOMBRE VALIDO");
		} else {
			validez = true;
		}
		return tname.getText().toUpperCase();
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
		tcod.setText("");
		tdep.setText("");
		lupa.setVisible(true);
		
		lupa.setVisible(false);
		lupa1.setVisible(true);
		
		RESP.setVisible(false);
		contra.setVisible(false);
		botones.setVisible(false);
		ladmin.setVisible(true);
		tpass.setVisible(true);
		tres.setVisible(false);
		tpreg.setVisible(true);
		
		//Hacer invisible el comboBox
		
		tuser.setEditable(true);
		tpass.setEditable(false);
		tname.setEditable(false);
		tres.setEditable(false);
		tcod.setEditable(false);
		
		tuser.setVisible(true);
		tpass.setVisible(false);
		tname.setVisible(true);
		tres.setVisible(false);
		tcod.setVisible(true);
		
		tuser.setText("");
		tpass.setText("");
		tname.setText("");
		tres.setText("");
		tcod.setText("");
		tpreg.setText("");
		ladmin.setText("");
		
		cbp.setVisible(false);

		modificar.setVisible(false);
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
	public String getUsuario() {
		// TODO Auto-generated method stub
		if(tuser.getText().length()<8) {
			validez = false;
			MensajeError("El usuario debe tener 8 caracteres");
		}
		else {
			validez = true;
		}
		
		return tuser.getText();
	}

	@Override
	public String getClave() {
		// TODO Auto-generated method stub
		if(tpass.getText().length()<8) {
			validez = false;
			MensajeError("La contraseña debe tener 8 caracteres");
		}
		else {
			validez = true;
		}
		
		return tpass.getText();
	}

	@Override
	public String getRespuesta() {
		// TODO Auto-generated method stub
		if(tres.getText().equals("")) {
			validez = false;
			MensajeError("La respuesta no debe estar vacía");
		}
		else {
			validez = true;
		}
		
		return tres.getText();
	}

	public String getCod() {
		// TODO Auto-generated method stub
		return tcod.getText();
	}
	
	public void setDepartamento(String depa) {
		// TODO Auto-generated method stub
		tdep.setText(depa);
	}

	@Override
	public void setCombo(DefaultComboBoxModel<?> dcbm) {
		// TODO Auto-generated method stub
		this.cbm = dcbm;
	}

	@Override
	public Object getComboItem() {
		// TODO Auto-generated method stub
		return cbp.getSelectedItem();
	}


	@Override
	public int getIdPregunta() {
		// TODO Auto-generated method stub
		return Integer.parseInt(tid.getText());
	}

	public void cargarCB() {
		// TODO Auto-generated method stub
		cbp.removeAllItems();
		  ObtenerPreguntas preg = new ObtenerPreguntas();
		  ArrayList < MPreguntas > listap = preg.consultarListapreguntas();


		  for (int i = 0; i < listap.size(); i++) {
		   cbp.addItem(listap.get(i).getPregunta());
		   tid.setText(listap.get(i).getId()+"");
		  }
		 
		}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int seleccion = 0;
		if(e.getStateChange()== ItemEvent.SELECTED) {
			seleccion = cbp.getSelectedIndex()+1;
			tid.setText(seleccion +"");
		}
	}

	@Override
	public int getAdmin() {
		// TODO Auto-generated method stub
		int admin = 0;
		
		if(rbadmin.isSelected()) {
			admin = 1;
		}
		if(rbnonadmin.isSelected()) {
			admin = 2;
		}
		
		return admin;
	}

	@Override
	public void escribir1(String departamento) {
		// TODO Auto-generated method stub
		tdep.setText(departamento);
	}

	@Override
	public void escribir(String nombre, String pregunta, String departamento, String code, int i) {
		// TODO Auto-generated method stub
		tname.setText(nombre);
		tpreg.setText(pregunta);
		tdep.setText(departamento);
		tcod.setText(code);
		if(i==1) {ladmin.setText("Administrador"); rbadmin.setSelected(true);}
		if(i==0) {ladmin.setText("No Administrador");rbnonadmin.setSelected(true);}
		
		cbp.setSelectedItem(pregunta);

		ladmin.setForeground(Color.WHITE);
		ladmin.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 18));
	}
	
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}

}