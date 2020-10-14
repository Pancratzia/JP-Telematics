package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.CVenta;
import model.MIva;
import model.ObtenerIVAS;

public class VVenta extends JInternalFrame implements ActionListener, ItemListener,IVenta {
	
	private CVenta controlador;
	private JComboBox<String> cbiva;
	private ComboBoxModel cbm;
	private JSpinner can;
	private JPanel pde, piz, pcli, pven, ppro, pve;
	private Color  darkblue =  new Color(33, 79, 129);
	private Color  white =  new Color(244, 245, 240);
	private Color  grey =  new Color(147, 151, 178);
	private Color  lightblue =  new Color(133, 169, 203);
	private JButton procesar, limpiar, salir, lupa, lupa1, exit; 
	private Font arialgrd = new Font("Arial Rounded MT BOLD", 1,30);
	private Font arialmed = new Font("Arial Round TM BOLD", 1,22); 
	private Font arialpeq = new Font("Arial Round TM BOLD", 1,15);
	private JTextField tRif, tPro,tcnom,tctel,tcdir,tcest,tctipo,tvced,tvtel,tvnom,tvzon,tpnom,tppre, tsub, tiva, tto;
	private JLabel st,i,t,rif,tp,cnom,ctel,dir,es,ced,vtel,vnom,zon,cod,pnom,pre, hora;
	private JTextField ivaoc;
	private Validacion val = new Validacion();
	private boolean cerrado = true, validez = true;
	
	public static String Date() {
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("hh:MM:SS");
		 
		return dateFormat.format(date);
	}
	
	public static String fechaActual() {

		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

		return formatoFecha.format(fecha);
	}
	
	public VVenta() {

		this.setSize(1000,600);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		Container cp = getContentPane();
		cp.setBackground(darkblue);
		
		GridBagLayout gb = new GridBagLayout();
		gb.columnWidths = new int[] {250,750};
		gb.rowHeights = new int[] {600};
		GridBagConstraints rules = new GridBagConstraints();
		
		cp.setLayout(gb);
		
		
		//PANEL IZQUIERDO - BOTONES//
		
		piz = new JPanel();
		piz.setBackground(white);
		GridBagLayout gbiz = new GridBagLayout();
		gbiz.columnWidths = new int [] {25,200,25};
		gbiz.rowHeights = new int[] {175,60,60,60,60,60,60};
		GridBagConstraints reglasiz = new GridBagConstraints();
		piz.setLayout(gbiz);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("recursos/img/logo.png"));
		logo.setBackground(darkblue);
		reglasiz.gridx = 1;
		reglasiz.gridy = 0;
		reglasiz.fill = GridBagConstraints.NONE;
		
		piz.add(logo, reglasiz);
		
		
		procesar = new JButton();
		procesar.setContentAreaFilled(false);
		procesar.setIcon(new ImageIcon("recursos/img/procesarON.png"));
		procesar.setRolloverIcon(new ImageIcon("recursos/img/procesarOFF.png"));
		procesar.setBackground(darkblue);
		procesar.setBorder(null);
		reglasiz.fill = GridBagConstraints.BOTH;
		procesar.addActionListener(this);
	
		reglasiz.insets = new Insets(5,5,5,5);
		reglasiz.gridy = 1;
		reglasiz.gridwidth=1;
		reglasiz.weightx=-1.0;
		piz.add(procesar, reglasiz);
		
		limpiar = new JButton();
		limpiar.setContentAreaFilled(false);
		limpiar.setIcon(new ImageIcon("recursos/img/limpiarONV.png"));
		limpiar.setRolloverIcon(new ImageIcon("recursos/img/limpiarOFFV.png"));
		limpiar.setBackground(darkblue);
		limpiar.setBorder(null);
		reglasiz.fill = GridBagConstraints.BOTH;
		limpiar.addActionListener(this);
		
		reglasiz.insets = new Insets(5,5,5,5);
		reglasiz.gridy++;
		piz.add(limpiar, reglasiz);
		
		salir = new JButton();
		salir.setContentAreaFilled(false);
		salir.setIcon(new ImageIcon("recursos/img/salirONV.png"));
		salir.setRolloverIcon(new ImageIcon("recursos/img/salirOFFV.png"));
		salir.setBackground(darkblue);
		salir.setBorder(null);
		reglasiz.gridy++;
		salir.addActionListener(this);
		
		reglasiz.insets = new Insets(5,5,5,5);
		reglasiz.fill = GridBagConstraints.BOTH;
		salir.addActionListener(this);
		
		piz.add(salir, reglasiz);
		
		
		//PANEL DERECHO//
		pde = new JPanel();
		pde.setBackground(darkblue);
		
		GridBagLayout gbde = new GridBagLayout();
		gbde.columnWidths = new int[] {200, 100, 100, 100, 200};
		gbde.rowHeights = new int [] {50, 30, 100, 100, 100, 100}; //Aqui colocas las filas que necesite tu panel
		GridBagConstraints reglasde = new GridBagConstraints();
		pde.setLayout(gbde);
		
		JLabel titulo = new JLabel("VENTAS");
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 30));
		titulo.setForeground(Color.white);
		titulo.setBackground(darkblue);
		reglasde.gridy = 0;
		reglasde.gridx = 1;
		reglasde.gridwidth = 3;
		reglasde.anchor=GridBagConstraints.NORTH;
		
		pde.add(titulo,reglasde);
		//pde.add(titulo, reglasde);
		
		exit = new JButton();
		exit.setContentAreaFilled(false);
		exit.setIcon(new ImageIcon("recursos/img/exitON.png"));
		exit.setRolloverIcon(new ImageIcon("recursos/img/exitOFF.png"));
		exit.setBackground(darkblue);
		exit.setBorder(null);
		exit.addActionListener(this);
		reglasde.gridx = 4;
		reglasde.gridwidth = 1;
		reglasde.fill = GridBagConstraints.NONE;
		reglasde.anchor = GridBagConstraints.NORTHEAST;
		reglasde.insets = new Insets (0,0,0,0);
		pde.add(exit, reglasde);
		
		JLabel fecha = new JLabel("");
		fecha.setText("Fecha: " + fechaActual());
		fecha.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,20));
		fecha.setForeground(white);
		fecha.setBackground(darkblue);
		reglasde.fill = GridBagConstraints.NONE;
		reglasde.anchor = GridBagConstraints.CENTER;
		reglasde.insets = new Insets (0,0,0,0);
		reglasde.gridy = 1;
		reglasde.gridx = 0;
		
		pde.add(fecha, reglasde);
		
		hora = new JLabel("");
		hora.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,20));
		hora.setForeground(white);
		hora.setBackground(darkblue);
		
		LocalDateTime locaDate = LocalDateTime.now();
		int hours  = locaDate.getHour();
		int minutes = locaDate.getMinute();
		int seconds = locaDate.getSecond();
		
		hora.setText("Hora: " + hours  + ":"+ minutes +":"+seconds);
		
		reglasde.gridx = 4;
		
		pde.add(hora, reglasde);
		/*panel 
		 * 
		 * cliente
		 */
		
		pcli = new JPanel();
		pcli.setLayout(new GridBagLayout());
		pcli.setBackground(darkblue);
		pcli.setBorder(new TitledBorder(new LineBorder(white), "CLIENTE", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, arialpeq, white));
		
		GridBagConstraints reglascl = new GridBagConstraints();
		
		JLabel rifCliente = new JLabel("RIF Cliente: ");
		rifCliente.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		rifCliente.setForeground(white);
		rifCliente.setBackground(darkblue);
		reglascl.gridy = 0;
		reglascl.gridx = 1;
		reglascl.weightx=0.4;
		reglascl.gridwidth=1;
		reglascl.gridheight=1;
		reglascl.anchor=GridBagConstraints.EAST;
		reglascl.insets=new Insets(5, 10, 5, 0);
		pcli.add(rifCliente, reglascl);
		
		tRif = new JTextField();
		tRif.setFont(new Font("Arial Round TM Bold",1,15));

		reglascl.gridx = 2;
		reglascl.gridy= 0;
		reglascl.gridwidth = 2;
		reglascl.weightx=0.0;
		//reglascl.insets=new Insets(10, 20, 10, 0);
		reglascl.fill = GridBagConstraints.HORIZONTAL;
		reglascl.anchor=GridBagConstraints.WEST;
		pcli.add(tRif, reglascl);
		
		
		lupa = new JButton();
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.addActionListener(this);
		reglascl.gridx = 4;
		reglascl.gridy = 0;
		reglascl.fill = GridBagConstraints.NONE;
		reglascl.anchor = GridBagConstraints.WEST;
		reglascl.insets = new Insets (5,10,5,0);
		
		pcli.add(lupa, reglascl);
		
		cnom = new JLabel("Nombre: ");
		cnom.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		cnom.setForeground(white);
		reglascl.gridy = 1;
		reglascl.gridx = 0;
		reglascl.gridwidth=1;
		reglascl.weightx=-1.0;
		reglascl.insets=new Insets(5, 5, 5, 5);
		reglascl.fill = GridBagConstraints.NONE;
		reglascl.anchor=GridBagConstraints.CENTER;
		pcli.add(cnom, reglascl);
		

		tcnom = new JTextField("");
		tcnom.setEditable(false);
		tcnom.setBackground(Color.white);
		tcnom.setOpaque(true);
		tcnom.setFont(arialpeq);
		reglascl.gridx=1;
		reglascl.gridy=1;
		reglascl.gridwidth=2;
		reglascl.weightx=0.0;
		reglascl.fill=GridBagConstraints.HORIZONTAL;
		pcli.add(tcnom,reglascl);
		
		
		ctel = new JLabel("Telefono: ");  
		ctel.setForeground(white);
		ctel.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglascl.gridx = 3;
		reglascl.gridy = 1;
		reglascl.gridwidth=1;
		reglascl.weightx= -1.0;
		reglascl.fill=GridBagConstraints.NONE;
		reglascl.anchor=GridBagConstraints.EAST;
		pcli.add(ctel, reglascl);
	
		
		tctel = new JTextField();
		tctel.setFont(arialpeq);
		tctel.setBackground(Color.white);
		tctel.setEditable(false);
		tctel.setOpaque(true);
		reglascl.gridx=4;
		reglascl.gridy=1;
		reglascl.gridwidth=2;
		reglascl.weightx=-0.5;
		reglascl.fill=GridBagConstraints.HORIZONTAL;
		pcli.add(tctel,reglascl);
		
		
		dir = new JLabel("Direccion: ");
		dir.setForeground(white);
		dir.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglascl.gridx = 0;
		reglascl.gridy = 2;
		reglascl.gridwidth=1;
		reglascl.fill=GridBagConstraints.NONE;
		reglascl.anchor=GridBagConstraints.CENTER;
		pcli.add(dir, reglascl);
		
		
		tcdir = new JTextField();
		tcdir.setFont(arialpeq);
		tcdir.setEditable(false);
		tcdir.setBackground(Color.white);
		tcdir.setOpaque(true);
		reglascl.gridx=1;
		reglascl.gridy=2;
		reglascl.gridwidth=2;
		reglascl.fill=GridBagConstraints.HORIZONTAL;
		
		pcli.add(tcdir,reglascl);
		
		
		es = new JLabel("Estado: ");
		es.setForeground(white);
		es.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglascl.gridx = 3;
		reglascl.gridy=2;
		reglascl.weightx=0.2;
		reglascl.gridwidth=1;
		reglascl.fill=GridBagConstraints.NONE;
		reglascl.anchor=GridBagConstraints.EAST;
		pcli.add(es, reglascl);
	
		
		tcest = new JTextField();
		tcest.setFont(arialpeq);
		tcest.setEditable(false);
		tcest.setBackground(Color.white);
		tcest.setOpaque(true);
		reglascl.gridx=4;
		reglascl.gridy=2;
		reglascl.gridwidth=2;
		reglascl.weightx=0.7;
		reglascl.fill=GridBagConstraints.HORIZONTAL;
		pcli.add(tcest,reglascl);
		reglascl.weightx=0.0;
		
		
		tp = new JLabel("Tipo de Persona: ");
		tp.setForeground(white);
		tp.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglascl.gridx = 0;
		reglascl.gridy = 3;
		reglascl.gridwidth=1;
		reglascl.fill=GridBagConstraints.NONE;
		pcli.add(tp, reglascl);
		
		
		tctipo = new JTextField();
		tctipo.setFont(arialpeq);
		tctipo.setEditable(false);
		tctipo.setBackground(Color.white);
		tctipo.setOpaque(true);
		reglascl.gridx=1;
		reglascl.gridy=3;
		reglascl.gridwidth=2;
		reglascl.fill=GridBagConstraints.HORIZONTAL;
		pcli.add(tctipo,reglascl);
		
		
		reglasde.gridy = 2;
		reglasde.gridx = 0;
		reglasde.gridwidth = 5;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		reglasde.anchor=GridBagConstraints.NORTH;
		
		pde.add(pcli, reglasde);
		
		
		pven = new JPanel();
		pven.setLayout(new GridBagLayout());
		GridBagConstraints reglasve=new GridBagConstraints(); 
		pven.setBackground(darkblue);
		pven.setForeground(white);
		pven.setBorder(new TitledBorder(new LineBorder(white), "VENDEDOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, arialpeq, white));
		
		ced = new JLabel("Cedula: ");
		ced.setForeground(white);
		ced.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglasve.gridx = 0;
		reglasve.gridy = 0;
		reglasve.gridwidth=1;
		reglasve.weightx=0.37;
		reglasve.weighty=0.0;
		reglasve.anchor=GridBagConstraints.CENTER;
		reglasve.fill=GridBagConstraints.NONE;
		reglasve.insets=new Insets(0,0,0,0);
		pven.add(ced,reglasve);
		
		tvced = new JTextField();
		tvced.setFont(arialpeq);
		tvced.setEditable(false);
		tvced.setBackground(Color.white);
		tvced.setOpaque(true);
		reglasve.gridx = 1;
		reglasve.gridy = 0;
		reglasve.gridwidth=1;
		reglasve.weightx=0.91;
		reglasve.anchor=GridBagConstraints.WEST;
		reglasve.fill=GridBagConstraints.HORIZONTAL;
		reglasve.insets=new Insets(0,0,0,0);
		pven.add(tvced,reglasve);
		
		vtel = new JLabel("Telefono: "); 
		vtel.setForeground(white);
		vtel.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglasve.gridx = 2;
		reglasve.gridy = 0;
		reglasve.gridwidth=1;
		reglasve.weightx=0.42;
		reglasve.fill=GridBagConstraints.NONE;
		reglasve.anchor=GridBagConstraints.EAST;
		reglasve.insets=new Insets(0,0,0,0);
		pven.add(vtel,reglasve);
		
		tvtel = new JTextField();
		tvtel.setFont(arialpeq);
		tvtel.setEditable(false);
		tvtel.setBackground(Color.white);
		tvtel.setOpaque(true);
		reglasve.gridx = 3;
		reglasve.gridy = 0;
		reglasve.gridwidth=1;
		reglasve.weightx=-2.0;
		reglasve.insets=new Insets(5,5,5,5);
		reglasve.fill=GridBagConstraints.HORIZONTAL;
		pven.add(tvtel,reglasve);
		
		
		vnom = new JLabel("Nombre: "); 
		vnom.setForeground(white);
		vnom.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglasve.gridx = 0;
		reglasve.gridy = 1;
		reglasve.gridwidth=1;
		reglasve.fill=GridBagConstraints.NONE;
		reglasve.anchor=GridBagConstraints.CENTER;
		reglasve.insets=new Insets(5, 0, 5, 0);
		pven.add(vnom,reglasve);
		
		tvnom = new JTextField();
		tvnom.setFont(arialpeq);
		tvnom.setEditable(false);
		tvnom.setBackground(Color.white);
		tvnom.setOpaque(true);
		reglasve.gridx = 1;
		reglasve.gridy = 1;
		reglasve.gridwidth=1;
		reglasve.insets=new Insets(5,0,5,0);
		reglasve.fill=GridBagConstraints.HORIZONTAL;
		reglasve.anchor=GridBagConstraints.WEST;
		pven.add(tvnom,reglasve);
	
		
		zon = new JLabel("Zona: "); 
		zon.setForeground(white);
		zon.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglasve.gridx = 2;
		reglasve.gridy = 1;
		reglasve.gridwidth=1;
		reglasve.weightx=-2.0;
		reglasve.fill=GridBagConstraints.NONE;
		reglasve.anchor=GridBagConstraints.EAST;
		reglasve.insets=new Insets(5,5,5,5);
		pven.add(zon,reglasve);
		
		tvzon = new JTextField();
		tvzon.setFont(arialpeq);
		tvzon.setEditable(false);
		tvzon.setBackground(Color.white);
		tvzon.setOpaque(true);
		reglasve.gridx = 3;
		reglasve.gridy = 1;
		reglasve.gridwidth=1;
		reglasve.weightx=1.0;
		reglasve.insets=new Insets(5,5,5,5);
		reglasve.fill=GridBagConstraints.HORIZONTAL;
		pven.add(tvzon,reglasve);
		
		
		reglasde.gridy = 3;
		reglasde.gridwidth = 5;
		reglasde.anchor=GridBagConstraints.NORTH;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		
		pde.add(pven, reglasde);
	
		
		/*panel
		 * 
		 * producto
		 */
		
		ppro = new JPanel();
		ppro.setLayout(new GridBagLayout());
		ppro.setBackground(darkblue);
		ppro.setBorder(new TitledBorder(new LineBorder(white), "PRODUCTO", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, arialpeq, white));
		
		GridBagConstraints reglaspro = new GridBagConstraints();
		
		JLabel pro = new JLabel("Codigo de producto: ");
		pro.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		pro.setForeground(white);
		pro.setBackground(darkblue);
		reglaspro.gridy = 0;
		reglaspro.gridx = 1;
		reglaspro.gridwidth=1;
		reglaspro.weightx=-2.0;
		reglaspro.insets=new Insets(5, 10, 5, 0);
		reglaspro.anchor=GridBagConstraints.EAST;
		reglaspro.fill=GridBagConstraints.NONE;
		ppro.add(pro, reglaspro);
		
		tPro = new JTextField();
		tPro.setFont(new Font("Arial Round TM Bold",1,15));
		reglaspro.gridx = 2;
		reglaspro.weightx = 0.42;
		reglaspro.weighty = 0.0;
		reglaspro.gridwidth = 1;
		reglaspro.fill = GridBagConstraints.HORIZONTAL;
		
		ppro.add(tPro, reglaspro);
		
		lupa1 = new JButton();
		lupa1.setContentAreaFilled(false);
		lupa1.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa1.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa1.setBackground(darkblue);
		lupa1.setBorder(null);
		lupa1.addActionListener(this);
		reglaspro.gridx = 4;
		reglaspro.weighty = 0.0;
		reglaspro.fill = GridBagConstraints.NONE;
		reglaspro.anchor = GridBagConstraints.WEST;
		reglaspro.insets=new Insets(5, 10, 5, 0);
		
		ppro.add(lupa1, reglaspro);
		
		pnom = new JLabel("Nombre:");    
		pnom.setForeground(white);
		pnom.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglaspro.gridy = 1;
		reglaspro.gridx = 0;
		reglaspro.gridwidth=1;
		reglaspro.weightx=0.175;
		reglascl.insets=new Insets(5, 5, 5, 5);
		reglaspro.anchor = GridBagConstraints.CENTER;
		reglaspro.fill=GridBagConstraints.NONE;
		ppro.add(pnom, reglaspro);
		
		tpnom = new JTextField("");
		tpnom.setEditable(false);
		tpnom.setBackground(Color.white);
		tpnom.setOpaque(true);
		tpnom.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglaspro.gridx=1;
		reglaspro.gridy=1;
		reglaspro.gridwidth=1;
		reglaspro.weightx=0.21;
		reglaspro.fill=GridBagConstraints.HORIZONTAL;
		reglaspro.anchor = GridBagConstraints.WEST;
		ppro.add(tpnom,reglaspro);
		
		pre = new JLabel("Precio: ");  
		pre.setForeground(white);
		pre.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglaspro.gridx = 2;
		reglaspro.gridwidth=1;
		reglaspro.weightx=-2.0;
		reglaspro.fill=GridBagConstraints.NONE;
		reglaspro.anchor=GridBagConstraints.EAST;
		ppro.add(pre, reglaspro);
		
		tppre = new JTextField();
		tppre.setFont(arialpeq);
		tppre.setEditable(false);
		tppre.setBackground(Color.white);
		tppre.setOpaque(true);
		reglaspro.gridx=4;
		reglaspro.gridy=1;
		reglaspro.gridwidth=1;
		reglaspro.weightx=0.88;
		reglaspro.fill=GridBagConstraints.HORIZONTAL;
		reglaspro.insets = new Insets(0, 5, 0, 5);
		ppro.add(tppre,reglaspro);
		
		reglasde.gridy = 4;
		reglasde.gridx = 0;
		reglasde.gridwidth = 5;
		reglasde.anchor=GridBagConstraints.NORTH;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		
		pde.add(ppro, reglasde);
		
	
		/*panel 
		 * 
		 * venta
		 */
		
		
		pve = new JPanel();
		pve.setLayout(new GridBagLayout());
		pve.setBackground(darkblue);
		pve.setBorder(new TitledBorder(new LineBorder(white), "VENTA", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, arialpeq, white));
		
		GridBagConstraints reglasven = new GridBagConstraints();
		
		JLabel Lcant = new JLabel("Cantidad: ");
		Lcant.setForeground(white);
		Lcant.setBackground(darkblue);
		Lcant.setOpaque(true);
		Lcant.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		reglasven.gridx=1;
		reglasven.gridy=0;
		reglasven.gridwidth=1;
		reglasven.insets = new Insets(15,15,15,0);
		reglasven.fill = GridBagConstraints.NONE;
		reglasven.anchor=GridBagConstraints.EAST;
		pve.add(Lcant,reglasven);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, null, 1);
		can = new JSpinner(model1);
		can.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,14));
		final JTextField jtf = ((JSpinner.DefaultEditor) can.getEditor()).getTextField();
		jtf.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				cbiva.setSelectedIndex(0);
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
		reglasven.gridx = 2;
		reglasven.gridy = 0;
		reglasven.gridwidth = 1;
		reglasven.anchor = GridBagConstraints.WEST;
		
		pve.add(can, reglasven);
		
		cbiva = new JComboBox<>();
		cbiva.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,14));
		cbiva.addItemListener(this);
			
	
		reglasven.gridx = 3;
		reglasven.gridwidth = 2;
		reglasven.anchor = GridBagConstraints.EAST;
		reglasven.fill = GridBagConstraints.HORIZONTAL;
		
		pve.add(cbiva, reglasven);
		
		ivaoc = new JTextField(1);
		ivaoc.setVisible(false);
		
		pve.add(ivaoc, reglasven);
		
		st = new JLabel("Subtotal: ");
		st.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		st.setForeground(white);

		reglasven.gridy = 1;
		reglasven.gridx = 0;
		reglasven.gridwidth = 1;
		reglasven.insets = new Insets(0, 0, 0, 0);
		reglasven.fill = GridBagConstraints.NONE;
		reglasven.anchor = GridBagConstraints.EAST;
		
		pve.add(st, reglasven);
		
		i = new JLabel("IVA: ");
		i.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		i.setForeground(white);
		reglasven.gridx = 2;
		reglasven.fill = GridBagConstraints.HORIZONTAL;
		reglasven.anchor = GridBagConstraints.EAST;
		reglasven.insets = new Insets(0, 10, 0, 0);
		pve.add(i, reglasven);
		
		t = new JLabel("Total: ");
		t.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,15));
		t.setForeground(white);
		
		reglasven.gridx = 4;
		reglasven.fill = GridBagConstraints.NONE;
		reglasven.anchor = GridBagConstraints.EAST;
		pve.add(t, reglasven);
		
		tsub = new JTextField();
		tsub.setText("");
		tsub.setFont(arialpeq);
		tsub.setEditable(false);
		tsub.setBackground(Color.white);
		tsub.setOpaque(true);
		reglasven.gridx = 1;
		reglasven.gridwidth = 1;
		reglasven.weightx=0.6;
		reglasven.insets=new Insets(10,10,10,10);
		reglasven.fill=GridBagConstraints.HORIZONTAL;
		
		pve.add(tsub, reglasven);
		
		tiva = new JTextField();
		tiva.setText("");
		tiva.setFont(arialpeq);
		tiva.setEditable(false);
		tiva.setBackground(Color.white);
		tiva.setOpaque(true);
		reglasven.gridx = 3;
		reglasven.gridwidth=1;
		reglasven.weightx=0.86;
		reglasven.fill=GridBagConstraints.HORIZONTAL;
		pve.add(tiva, reglasven);
		
		tto = new JTextField();
		tto.setText("");
		tto.setFont(arialpeq);
		tto.setEditable(false);
		tto.setBackground(Color.white);
		tto.setOpaque(true);
		reglasven.gridx = 5;
		reglasven.gridwidth=1;
		reglasven.weightx=1.1;
		reglasven.fill=GridBagConstraints.HORIZONTAL;
		pve.add(tto, reglasven);
		
		reglasde.gridy = 5;
		reglasde.gridx = 0;
		reglasde.gridwidth = 5;
		reglasde.anchor=GridBagConstraints.NORTH;
		reglasde.fill = GridBagConstraints.HORIZONTAL;
		
		pde.add(pve, reglasde);
		
		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(piz, rules);
		
		rules.gridx = 1;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pde, rules);
	
		
		procesar.setActionCommand(IVenta.PROCESAR);
		limpiar.setActionCommand(IVenta.LIMPIAR);
		salir.setActionCommand(IVenta.SALIR);
		lupa.setActionCommand(IVenta.LUPA);
		lupa1.setActionCommand(IVenta.LUPA1);
		exit.setActionCommand(IVenta.EXIT);
	//	cbiva.setActionCommand(IVenta.COMBO);
		
		val.ValidarCantidad(tPro, 4);
		val.ValidarCantidad(tRif, 9);
	}
	
	

	@Override
	public void run() {
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
	public void setControlador(CVenta c) {
		this.controlador=c;
		procesar.addActionListener(c);
		limpiar.addActionListener(c);
		salir.addActionListener(c);
		lupa.addActionListener(c);
		lupa1.addActionListener(c);
		exit.addActionListener(c);
		cbiva.addActionListener(c);

	}

	@Override
	public void runHora() {
		// TODO Auto-generated method stub
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						hora.setText(formateador.format(LocalDateTime.now()));
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				// TODO Auto-generated method stub
				
			}
		};
		Thread hilo = new Thread(runnable);
		hilo.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int seleccion = 0;
		seleccion = cbiva.getSelectedIndex();
		ivaoc.setText(seleccion+"");
		
		if(e.getStateChange()== ItemEvent.SELECTED) {
			if(cbiva.getSelectedIndex()==0) {
				tsub.setText("");
				tiva.setText("");
				tto.setText("");
			}
		    else if(cbiva.getSelectedIndex()==1) {
			controlador.actionPerformed(new ActionEvent(this, 1, IVenta.COMBO));
			}
			else if(cbiva.getSelectedIndex()==2) {
				controlador.actionPerformed(new ActionEvent(this, 2, IVenta.COMBO));
			}
			else if(cbiva.getSelectedIndex()==3) {
				controlador.actionPerformed(new ActionEvent(this, 3, IVenta.COMBO));
			}
			
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
	public void limpiar() {
		// TODO Auto-generated method stub
		tRif.setText("");
		tPro.setText("");
		tcnom.setText("");
		tcdir.setText("");
		tctipo.setText("");
		tctel.setText("");
		tcest.setText("");
		tvced.setText("");
		tvnom.setText("");
		tvtel.setText("");
		tvzon.setText("");
		tpnom.setText("");
		tppre.setText("");
		tsub.setText("");
		tiva.setText("");
		tto.setText("");
		can.setValue(1);
		cargarCB();
		
	}

	@Override
	public void cargarCB() {
		// TODO Auto-generated method stub
		cbiva.removeAllItems();
		  ObtenerIVAS ivas = new ObtenerIVAS();
		  ArrayList < MIva > listaIvas = ivas.consultarListaIVAS();

		  cbiva.addItem("Seleccione una Opción");
		  ivaoc.setText("0");
		  for (int i = 0; i < listaIvas.size(); i++) {
		   cbiva.addItem(listaIvas.get(i).getIva()+"%");
		   ivaoc.setText(listaIvas.get(i).getId()+"");
		  }
		 
		}

	@Override
	public String getIDCombo() {
		// TODO Auto-generated method stub
		return ivaoc.getText();
	}

	@Override
	public int getCantidadVenta() {
		// TODO Auto-generated method stub
		return (Integer) can.getValue();
	}

	@Override
	public String getRifCliente() {
		// TODO Auto-generated method stub
		String rif = "";
		try {
			Long.parseLong(tRif.getText());
			rif = tRif.getText();
			validez= true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El RIF debe estar compuesto de nueve numeros");
			validez = false;
		}
		
		return rif;
	}

	@Override
	public String getCodigoProducto() {
		// TODO Auto-generated method stub
		return tPro.getText();
	}

	@Override
	public void escribirCliente(String tcnom, String tcdir, String tctipo, String tctel, String tcest) {
		// TODO Auto-generated method stub
		this.tcnom.setText(tcnom);
		this.tcdir.setText(tcdir);
		this.tctipo.setText(tctipo);
		this.tctel.setText(tctel);
		this.tcest.setText(tcest);
	
	}

	@Override
	public void escribirVendedor(String ced, String nom, String tel, String zon) {
		// TODO Auto-generated method stub
		tvced.setText(ced);
		tvnom.setText(nom);
		tvtel.setText(tel);
		tvzon.setText(zon);
	}

	@Override
	public void escribirProducto(String tpnom, double tppre) {
		// TODO Auto-generated method stub
		this.tpnom.setText(tpnom);
		this.tppre.setText(tppre+"");
	}

	@Override
	public void escribirVenta(String tsub, String tiva, String ttot) {
		// TODO Auto-generated method stub
		this.tsub.setText(tsub+"");
		this.tiva.setText(tiva+"");
		this.tto.setText(ttot+"");
	}

	@Override
	public void setCombo(JComboBox cbi) {
		this.cbiva=cbi;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getVerificacion() {
		// TODO Auto-generated method stub
		return tcnom.getText();
	}

	@Override
	public String getVerificacion2() {
		// TODO Auto-generated method stub
		return tpnom.getText();
	}

	@Override
	public String getVerificacion3() {
		// TODO Auto-generated method stub
		return tto.getText();
	}

	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}

	@Override
	public boolean getValidez() {
		// TODO Auto-generated method stub
		return validez;
	}
	


	
	
	

}
