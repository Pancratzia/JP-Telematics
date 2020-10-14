package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.CZona;

public class VZona extends JInternalFrame implements ActionListener, ItemListener, IZona {

	private JPanel pde, piz, pnt1, pnt2, paneltitulo, panelzonas, pn1, pn2;
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton aceptar, borrar, crear, limpiar, modificar, salir, lupa, verif, exit;
	private JTextField tcodigo, tnomzona, id;
	private Validacion val;
	private boolean validez;
	private JList estadoslista;
	private DefaultListModel elementos;
	private int estado1, estado2, estado3;
	public JCheckBox[] checkList;
	private int max = 3;
	private int contador;
	private boolean cerrado = true;
	

	public VZona() {

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
		gbde.columnWidths = new int[] { 100, 550, 50 }; // ANCHO DE LAS COLUMNAS
		gbde.rowHeights = new int[] { 100, 50, 50, 70, 250, 15, 15, 80 }; // ALTO DE LAS FILAS
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);

		JLabel titulo = new JLabel("ZONAS"); // TITULO
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 30));
		titulo.setForeground(white);
		titulo.setBackground(darkblue);
		reglasde.gridy = 0;
		reglasde.gridx = 1;

		pde.add(titulo, reglasde);

		exit = new JButton(); // BOTN DE SALIR ( "X" )
		exit.setContentAreaFilled(false);
		exit.setIcon(new ImageIcon("recursos/img/exitON.png"));
		exit.setRolloverIcon(new ImageIcon("recursos/img/exitOFF.png"));
		exit.setBackground(darkblue);
		exit.setBorder(null);
		exit.addActionListener(this);
		reglasde.gridx = 2;

		pde.add(exit, reglasde);

		JLabel lcodigo = new JLabel("Código: "); // JLABEL DEL CODIGO
		lcodigo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
		lcodigo.setForeground(white);
		lcodigo.setBackground(darkblue);
		reglasde.gridy = 1;
		reglasde.gridx = 0;
		reglasde.fill = GridBagConstraints.HORIZONTAL;

		pde.add(lcodigo, reglasde);

		tcodigo = new JTextField(4); // DONDE ESCRIBIRAN EL CODIGO
		tcodigo.setBackground(white);
		tcodigo.setForeground(Color.BLACK);
		tcodigo.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		reglasde.gridy = 1;
		reglasde.gridx = 1;
		pde.add(tcodigo, reglasde);

		lupa = new JButton(); // BOTON DE BUSQUEDA O LUPA
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.addActionListener(this);
		reglasde.gridx = 2;

		pde.add(lupa, reglasde);

		JLabel lnomzona = new JLabel("Nombre: "); // JLABEL DE NOMBRE
		lnomzona.setFont(new Font("Arial Rounded TM Bold", Font.BOLD + Font.ITALIC, 20));
		lnomzona.setForeground(white);
		lnomzona.setBackground(darkblue);
		reglasde.gridx = 0;
		reglasde.gridy = 2;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(lnomzona, reglasde);

		tnomzona = new JTextField(10); // DONDE INTRODUCIRAN EL NOMBRE
		tnomzona.setBackground(white);
		tnomzona.setForeground(Color.BLACK);
		tnomzona.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tnomzona.setBorder(null);
		reglasde.gridx = 1;
		tnomzona.setEditable(false);
		pde.add(tnomzona, reglasde);

		verif = new JButton(); // BOTON DE VERIFICACION PARA QUE SALGA EL PANEL DE ESTADOS
		verif.setContentAreaFilled(false);
		verif.setIcon(new ImageIcon("recursos/img/verifON.png"));
		verif.setRolloverIcon(new ImageIcon("recursos/img/verifOFF.png"));
		verif.setBackground(darkblue);
		verif.setBorder(null);
		verif.addActionListener(this);
		verif.setVisible(false);
		reglasde.gridx = 2;

		pde.add(verif, reglasde);

		paneltitulo = new JPanel(); // PNAEL DE CARDLAYOUT PARA EL TITULO DE LOS PANELES DE ESTADOS
		paneltitulo.setBackground(darkblue);
		paneltitulo.setLayout(new CardLayout());

		pnt1 = new JPanel();
		pnt1.setBackground(darkblue);

		JLabel lconforestado = new JLabel("Estado(s) que conforman la Zona:"); // PRIMER TITULO, se hara visible solo
																			   // cuando se necesite saber los estados
																			   // de la zona
		lconforestado.setForeground(white);
		lconforestado.setBackground(darkblue);
		pnt1.add(lconforestado);

		paneltitulo.add(pnt1);

		pnt2 = new JPanel();
		pnt2.setBackground(darkblue);

		JLabel lseleccestado = new JLabel("Estado(s) a seleccionar: "); // SEGUNDO TITULO, se hara visible al momento de
																		// registrar los estados
		lseleccestado.setFont(new Font("Arial Rounded MT Bold", 2, 20));
		lseleccestado.setForeground(white);
		lseleccestado.setBackground(darkblue);
		pnt2.add(lseleccestado);

		paneltitulo.add(pnt2);
		paneltitulo.setVisible(false);

		reglasde.gridx = 0;
		reglasde.gridy = 3;
		reglasde.gridwidth = 3;
		reglasde.fill = GridBagConstraints.NONE;
		reglasde.anchor = GridBagConstraints.CENTER;
		pde.add(paneltitulo, reglasde);

		panelzonas = new JPanel(); // PANEL DE CARD LAYOUT PARA LOS ESTADOS
		panelzonas.setBackground(darkblue);
		panelzonas.setLayout(new CardLayout());

		pn1 = new JPanel();
		pn1.setBackground(darkblue);

		estadoslista = new JList(); // PRIMER PANEL DONDE SE MOSTRARAN LOS ESTADOS DE LAS ZONAS
		elementos = new DefaultListModel();
		
		estadoslista.setModel(elementos);
		estadoslista.setForeground(white);
		estadoslista.setBackground(darkblue);
		estadoslista.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		pn1.add(estadoslista);

		panelzonas.add(pn1);

		pn2 = new JPanel(); // SEGUNDO PANEL DONDE ESTAN LOS JCHECKBOX
		pn2.setLayout(new GridLayout(8, 3));
		pn2.setBorder(BorderFactory.createTitledBorder(null, "Estados: ", TitledBorder.CENTER, TitledBorder.TOP, null,
				Color.WHITE));

		pn2.setForeground(white);
		pn2.setBackground(darkblue);


		
		checkList = new JCheckBox[24]; //ARREGLO DE CHECKBOX PARA LOS 24 ESTADOS

	        checkList[0] = new JCheckBox("Amazonas");
	        checkList[1] = new JCheckBox("Anzoátegui");
	        checkList[2] = new JCheckBox("Apure");
	        checkList[3] = new JCheckBox("Aragua");
	        checkList[4] = new JCheckBox("Barinas");
	        checkList[5] = new JCheckBox("Bolivar");
	        checkList[6] = new JCheckBox("Carabobo");
	        checkList[7] = new JCheckBox("Cojedes");
	        checkList[8] = new JCheckBox("Delta Amacuro");
	        checkList[9] = new JCheckBox("Distrito Capital");
	        checkList[10] = new JCheckBox("Falcón");
	        checkList[11] = new JCheckBox("Guárico");
	        checkList[12] = new JCheckBox("Lara");
	        checkList[13] = new JCheckBox("Mérida");
	        checkList[14] = new JCheckBox("Miranda");
	        checkList[15] = new JCheckBox("Monagas");
	        checkList[16] = new JCheckBox("Nueva Esparta");
	        checkList[17] = new JCheckBox("Portuguesa");
	        checkList[18] = new JCheckBox("Sucre");
	        checkList[19] = new JCheckBox("Táchira");
	        checkList[20] = new JCheckBox("Trujillo");
	        checkList[21] = new JCheckBox("Vargas");
	        checkList[22] = new JCheckBox("Yaracuy");
	        checkList[23] = new JCheckBox("Zulia");
	        
	        for (int i = 0; i < 24; ++i) {  //CICLO PARA PERSONALIZAR LOS 24 CHECKBOX (TIPO DE LETRA, TAMAÑO...) 
	            							//Y AGREGARLOS AL SEGUNDO PANEL 
	            
	            checkList[i].setFont(new Font("Arial Rounded MT Bold", 2, 14));
	            checkList[i].setForeground(white);
	            checkList[i].setBackground(darkblue);
	            checkList[i].addItemListener(this);
	            pn2.add(checkList[i]);
	        }
	        
	    
		

		panelzonas.add(pn2);
		panelzonas.setVisible(false);

		reglasde.gridx = 0;
		reglasde.gridy = 4;
		reglasde.gridwidth = 3;
		reglasde.gridheight = 1;
		reglasde.fill = GridBagConstraints.BOTH;
		reglasde.anchor = GridBagConstraints.CENTER;
		pde.add(panelzonas, reglasde);
		
		JLabel adv1 = new JLabel("*El código debe tener 4 caracteres");
		adv1.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv1.setForeground(white);
		adv1.setBackground(darkblue);
		adv1.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridy = 5;
		reglasde.gridx = 0;
		reglasde.gridwidth = 3;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		pde.add(adv1, reglasde);

		JLabel adv2 = new JLabel("*El programa no diferenciará entre mayúsculas y minúsculas");
		adv2.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		adv2.setForeground(white);
		adv2.setBackground(darkblue);
		adv2.setHorizontalAlignment(SwingConstants.CENTER);
		reglasde.gridy = 6;
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
		val.ValidarCantidad(tnomzona, 100);
		val.ValidarCantidad(tcodigo, 4);

		// ActionCommand

		lupa.setActionCommand(IZona.BUSCAR);
		aceptar.setActionCommand(IZona.ACEPTAR);
		limpiar.setActionCommand(IZona.LIMPIAR);
		exit.setActionCommand(IZona.EXIT);
		salir.setActionCommand(IZona.SALIR);

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

			tnomzona.setEditable(true);
			tnomzona.setText("");
			tcodigo.setText("");
			elementos.removeAllElements();
			lupa.setVisible(false);
			verif.setVisible(true);

			paneltitulo.setVisible(false);
			panelzonas.setVisible(false);

		}

		if (bt == verif) {
			paneltitulo.setVisible(true);
			panelzonas.setVisible(true);
			pnt1.setVisible(false);
			pnt2.setVisible(true);
			pn1.setVisible(false);
			pn2.setVisible(true);
			
			for (int i = 0; i < 24; ++i) { 
				if(checkList[i].isSelected()) {
	            checkList[i].setSelected(false);;
				}
	        }
			contador=0;
		}

		if (bt == modificar) {
			crear.setVisible(false);
			modificar.setVisible(true);
			borrar.setVisible(false);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			modificar.setEnabled(false);

			tnomzona.setEditable(false);
			tnomzona.setText("");
			tcodigo.setText("");
			elementos.removeAllElements();
			lupa.setVisible(true);
			verif.setVisible(false);

			paneltitulo.setVisible(false);
			panelzonas.setVisible(false);

		}

		if (bt == lupa && modificar.isEnabled() == false) {
			paneltitulo.setVisible(false);
			panelzonas.setVisible(false);
			
			elementos.removeAllElements();

			tnomzona.setEditable(true);
		}

		if (bt == borrar) {
			crear.setVisible(false);
			modificar.setVisible(false);
			borrar.setVisible(true);
			aceptar.setVisible(true);
			limpiar.setVisible(true);
			salir.setVisible(true);
			borrar.setEnabled(false);

			tnomzona.setEditable(false);
			tnomzona.setText("");
			tcodigo.setText("");
			elementos.removeAllElements();
			lupa.setVisible(true);
			verif.setVisible(false);

			paneltitulo.setVisible(false);
			panelzonas.setVisible(false);
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

			tnomzona.setEditable(false);
			tnomzona.setText("");
			tcodigo.setText("");
			elementos.removeAllElements();
			lupa.setVisible(true);
			verif.setVisible(false);

			paneltitulo.setVisible(false);
			panelzonas.setVisible(false);
			
			for (int i = 0; i < 24; ++i) {  //CONDICION PARA DESMARCAR LOS BOTONES QUE ESTEN SELECCIONADOS
				if(checkList[i].isSelected()) {
	            checkList[i].setSelected(false);;
				}
	        }
			contador=0;

		}
	}
	
	@Override
	public void MostrarEstados(){
		
		panelzonas.setVisible(true);
		paneltitulo.setVisible(true);

		pnt1.setVisible(true);
		
		pn1.setVisible(true);
		pnt2.setVisible(false);
		pn2.setVisible(false);
		
	}

	@Override
	public void salir() {  // MENSAJE DE CONFIRMACION AL SALIR DE LA VENTANA
		
		try {
			this.setClosed(true);
			cerrado = true;
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setController(CZona c) {
		
		aceptar.addActionListener(c);
		limpiar.addActionListener(c);
		lupa.addActionListener(c);
		exit.addActionListener(c);
		salir.addActionListener(c);

	}

	@Override
	public void limpiar() { // LIMPIAR LOS JTEXTFIELD
		
		tnomzona.setText("");
		tcodigo.setText("");
		elementos.removeAllElements();
		paneltitulo.setVisible(false);
		panelzonas.setVisible(false);
	}

	@Override
	public int getOperacion() { // AQUI SE HACE UN REGISTRO DE LAS OPERACIONES QUE SE ESTE HACIENDO PARA PODER
								// HACER LA OPERACIONES O EVENTOS EN EL CONTROLADOR
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
	public String getNombre() { // VALIDACION DE NOMBRE
		
		if (tnomzona.getText().toString().equals("")) {
			
			validez = false;
			MensajeError("DEBE INGRESAR UN NOMBRE VALIDO");
			
		} else {
			validez = true;
			
		}
		
		return tnomzona.getText().toUpperCase();
		
	}

	@Override
	public String getCodigo() { // VALIDACION DE CODIGO
		
		if (tcodigo.getText().length() < 4) {
			
			validez = false;
			MensajeError("EL CÓDIGO DEBE TENER CUATRO (4) CARACTERES");
			
		} else {
			
			validez = true;
			
		}
		
		return tcodigo.getText().toUpperCase();
		
	}

	public void MensajeError(String mensaje) { // MENSAJE DE ERROR
		
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public boolean getValidez() {
		// TODO Auto-generated method stub
		return validez;
	}

	@Override
	public void VolverAlMenu() { // HACER VISIBLES O NO AL MOMENTO DE VOLVER A LA PAGINA O PANEL PRINCIPAL
		
		crear.setVisible(true);
		modificar.setVisible(true);
		borrar.setVisible(true);

		aceptar.setVisible(false);
		limpiar.setVisible(false);
		salir.setVisible(false);

		crear.setEnabled(true);
		modificar.setEnabled(true);
		borrar.setEnabled(true);

		tnomzona.setEditable(false);
		tnomzona.setText("");
		tcodigo.setText("");
		lupa.setVisible(true);
		verif.setVisible(false);

		paneltitulo.setVisible(false);
		panelzonas.setVisible(false);

	}

	@Override
	public int Preguntar(String pregunta) {
		
		if (JOptionPane.showConfirmDialog(null, pregunta, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			
			return 1;
			
		} else
			
			return 0;
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		JCheckBox source = (JCheckBox) e.getSource();

        if (source.isSelected()) {
        	contador++;
            if (contador == max)
                for (JCheckBox box: checkList)
                    if (!box.isSelected())
                        box.setEnabled(false);
        }
        else {
        	contador--;
            if (contador < max)
                for (JCheckBox box: checkList)
                    box.setEnabled(true);
        }
        if(contador == 0) {
			estado1 = 0;
			estado2 = 0;
			estado3 = 0;
			
		}else if(contador == 1) {
			estado2 = 0;
			estado3 = 0;
			for (int i = 0; i < 24; ++i) {
	            
	            if(checkList[i].isSelected()) {
	            	estado1 = i;
	            }
	        }
			
		}else if(contador == 2) {
			estado3 = 0;
			
			for (int i = 0; i < 24; ++i) {
	            
	            if(checkList[i].isSelected() && estado1 != i) {
	            	estado2 = i;
	            }
	        }
			
		}else if(contador == 3) {
			for (int i = 0; i < 24; ++i) {
	            
	            if(checkList[i].isSelected() && estado1 != i && estado2 != i) {
	            	estado3 = i;
	            }
	        }
		}
	}
	
	@Override
	public void escribir(String tcodigo, String tnomzona, int estado1, int estado2, int estado3) {
		
		this.tnomzona.setText(tnomzona);
		this.tcodigo.setText(tcodigo);
		
		elementos.removeAllElements();
		
		//ARREGLO QUE CONTIENE TODOS LOS ESTADOS
		
		String[] nomEstados= {"Amazonas","Anzoátegui","Apure","Aragua","Barinas","Bolivar","Carabobo","Cojedes",
				"Delta Amacuro","Distrito Capital","Falcón","Guárico","Lara","Mérida","Miranda","Monagas","Nueva Esparta",
				"Portuguesa","Sucre","Táchira","Trujillo","Vargas","Yaracuy","Zulia"};
		
		//EL ID DEL ESTADO QUE ENTRE POR PARAMETROS SERVIRA PARA QUE EN LOS PROXIMOS CICLO UBIQUE EL NOMBRE
		//DE LOS ESTADOS EN EL ARREGLO Y LO AGREGUE AL JLIST
		
		
		if(estado1 != 0) {
			elementos.addElement(nomEstados[estado1 - 1]);
		}
		if(estado2 != 0) {
			elementos.addElement(nomEstados[estado2 - 1]);
		}
		if(estado3 != 0) {
			elementos.addElement(nomEstados[estado3 - 1]);
		}
	}
	
	@Override
	public int getEstado1() {
		// TODO Auto-generated method stub
		return estado1 + 1;
	}

	@Override
	public int getEstado2() {
		// TODO Auto-generated method stub
		return estado2 + 1;
	}

	@Override
	public int getEstado3() {
		// TODO Auto-generated method stub
		return estado3 + 1;
	}

	@Override
	public int getContador() {
		// TODO Auto-generated method stub
		return contador;
	}

	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}
}
