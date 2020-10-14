package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.CAuditoria;


public class VAuditoria extends JInternalFrame implements IAuditoria, ActionListener {
	
	private JRadioButton usuario,todo;
	private JButton buscar,exit,lupa,limpiar;
	private boolean cerrado = true;
	private JLabel ltodo,lusuario,lnusuario;
	private JTextField tnombre;
	private JTable tabla;
	private DefaultTableModel dtm;
	private JScrollPane sp;
	private ResultSet rs = null;
	private Color  darkblue =  new Color(33, 79, 129);
	private Color  white =  new Color(244, 245, 240);
	private Color  grey =  new Color(147, 151, 178);
	private Color  lightblue =  new Color(133, 169, 203);
	private CAuditoria controlador;
	private String sql = "SELECT A.hora_y_fecha, U.nombre_usuario, P.codigo, A.Operacion  FROM auditorias A, usuarios U, productos P WHERE U.id_usuario = A.id_usuario AND P.id_producto = A.id_producto";

	
	public VAuditoria (){
		
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		Container cp= getContentPane();
		
		GridBagLayout gbl=new GridBagLayout();
		gbl.columnWidths = new int[] {250,750};
		gbl.rowHeights = new int[] {600};
		GridBagConstraints rules = new GridBagConstraints();
		
		cp.setLayout(gbl);
		cp.setBackground(darkblue);
		
		// Panel Izquierdo
		
		JPanel pi=new JPanel();
		pi.setBackground(white);
		GridBagLayout gbi = new GridBagLayout();
		gbi.rowHeights = new int[] {175,70,30,70,30,80,80};
		gbi.columnWidths=new int[] {250};
		GridBagConstraints reglasi = new GridBagConstraints();
		pi.setLayout(gbi);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("recursos/img/logo.png"));
		logo.setBackground(darkblue);
		reglasi.gridx = 0;
		reglasi.gridy = 0;
		reglasi.fill = GridBagConstraints.NONE;
		pi.add(logo, reglasi);
		
		limpiar = new JButton();
		limpiar.setContentAreaFilled(false);
		limpiar.setIcon(new ImageIcon("recursos/img/limpiarON.png"));
		limpiar.setRolloverIcon(new ImageIcon("recursos/img/limpiarOFF.png"));
		limpiar.setBackground(darkblue);
		limpiar.setBorder(null);
		limpiar.setVisible(true);

		reglasi.gridy=4;
		
		pi.add(limpiar, reglasi);
		limpiar.setActionCommand(IAuditoria.LIMPIAR);
		
		// Panel Derecho
		
		JPanel pd=new JPanel();
		pd.setBackground(darkblue);
		GridBagLayout gbd = new GridBagLayout();
		gbd.columnWidths = new int[] {100, 550, 50};
		gbd.rowHeights = new int [] {100, 50, 50, 50, 95, 185, 100};
		GridBagConstraints reglasd=new GridBagConstraints();
		pd.setLayout(gbd);
		
		JLabel titulo = new JLabel("AUDITORIA");
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD+Font.ITALIC,30));
		titulo.setForeground(white);
		titulo.setBackground(darkblue);
		reglasd.gridy = 0;
		reglasd.gridx = 1;
		reglasd.anchor=GridBagConstraints.CENTER;
		pd.add(titulo,reglasd);
		
		exit = new JButton();
		exit.setContentAreaFilled(false);
		exit.setIcon(new ImageIcon("recursos/img/exitON.png"));
		exit.setRolloverIcon(new ImageIcon("recursos/img/exitOFF.png"));
		exit.setBackground(darkblue);
		exit.setBorder(null);
		reglasd.gridx=2;
		reglasd.gridy=0;
		reglasd.anchor=GridBagConstraints.EAST;
		pd.add(exit, reglasd);
		
		exit.setActionCommand(VAuditoria.SALIR);

		
		JPanel pOpciones=new JPanel();
		JLabel lopciones=new JLabel("Seleccione: ");
		lopciones.setForeground(white);
		lopciones.setFont(new Font("Arial", Font.BOLD, 15));
		pOpciones.add(lopciones);
		JPanel pSeleccion=new JPanel();
		pSeleccion.setLayout(new GridLayout(1,2));
		usuario=new JRadioButton("Usuario",false);
		usuario.setBackground(darkblue);
		usuario.setForeground(white);
		usuario.addActionListener(this);
		todo=new JRadioButton("Todo",true);
		todo.setBackground(darkblue);
		todo.addActionListener(this);
		todo.setForeground(white);
		ButtonGroup bg=new ButtonGroup();
		bg.add(usuario);
		bg.add(todo);
		pSeleccion.add(usuario);
		pSeleccion.add(todo);	
		pSeleccion.setBackground(darkblue);
		pOpciones.add(pSeleccion);
		pOpciones.setBackground(darkblue);
		reglasd.gridx=1;
		reglasd.gridy=1;
		reglasd.anchor=GridBagConstraints.CENTER;
		reglasd.fill=GridBagConstraints.HORIZONTAL;
		pd.add(pOpciones,reglasd);
		
		JPanel pnb=new JPanel();
		lnusuario=new JLabel("N. Usuario: ");
		lnusuario.setForeground(white);
		lnusuario.setFont(new Font("Arial", Font.BOLD, 15));
		pnb.add(lnusuario);
		
		JPanel pnb2=new JPanel();
		GridBagLayout gbl2=new GridBagLayout();
		gbl2.columnWidths = new int[] { 100, 50};
		gbl2.rowHeights = new int [] {50};
		pnb2.setLayout(gbl2);
		GridBagConstraints rgbl=new GridBagConstraints();
		tnombre=new JTextField(20);
		tnombre.setVisible(true);
		rgbl.gridx=0;
		rgbl.gridy=0;
		rgbl.fill=GridBagConstraints.HORIZONTAL;
		pnb2.add(tnombre,rgbl);
		
		lupa=new JButton();
		lupa.setActionCommand(IAuditoria.Buscar);
		lupa.setContentAreaFilled(false);
		lupa.setIcon(new ImageIcon("recursos/img/lupaON.png"));
		lupa.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
		lupa.setBackground(darkblue);
		lupa.setBorder(null);
		lupa.setVisible(true);
		
		
		lupa.setActionCommand(IAuditoria.BuscarC);
		
		rgbl.gridx=1;
		rgbl.gridy=0;
		rgbl.anchor=GridBagConstraints.CENTER;
		pnb2.add(lupa,rgbl);
		pnb2.setBackground(darkblue);
		
		
		buscar=new JButton();
		buscar.setActionCommand(IAuditoria.BuscarC);
		buscar.setContentAreaFilled(false);
		buscar.setIcon(new ImageIcon("recursos/img/buscarON.png"));
		buscar.setRolloverIcon(new ImageIcon("recursos/img/buscarOFF.png"));
		buscar.setBackground(darkblue);
		buscar.setBorder(null);
		buscar.setVisible(true);
		buscar.setActionCommand(IAuditoria.Buscar);
		
		pnb.setBackground(darkblue);
		pnb.add(pnb2);
		pnb.add(buscar);
		reglasd.gridx=1;
		reglasd.gridy=2;
		reglasd.anchor=GridBagConstraints.CENTER;
		reglasd.fill=GridBagConstraints.HORIZONTAL;
		pd.add(pnb,reglasd);
		
		
		
		ltodo=new JLabel("Todo");
		ltodo.setForeground(white);
		ltodo.setFont(new Font("Arial", Font.BOLD, 15));
		ltodo.setVisible(false);
		lusuario=new JLabel("Usuario");
		lusuario.setForeground(white);
		lusuario.setFont(new Font("Arial", Font.BOLD, 15));
		reglasd.gridx = 0;
		reglasd.gridy = 3;
		reglasd.anchor=GridBagConstraints.WEST;
		pd.add(ltodo,reglasd);
		pd.add(lusuario,reglasd);
		
		
		tabla = new JTable();
		dtm = new DefaultTableModel();
		tabla.setModel(dtm);
 
		dtm.addColumn("Fecha y Hora");
		dtm.addColumn("Usuario");
		dtm.addColumn("Producto");
		dtm.addColumn("Operación");
		
		
		sp =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		reglasd.gridx=0;
		reglasd.gridy=4;
		reglasd.gridheight=2;
		reglasd.gridwidth=3;
		reglasd.fill=GridBagConstraints.BOTH;
		pd.add(sp,reglasd);
		
		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pi, rules);
		
		rules.gridx = 1;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.BOTH;
		cp.add(pd, rules);
		usuario.setSelected(false);
		todo.setSelected(true);

		lusuario.setVisible(false);
		lnusuario.setVisible(false);
		ltodo.setVisible(true);
		tnombre.setVisible(false);
		buscar.setVisible(true);
		lupa.setVisible(false);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
			if(todo.isSelected()==true) {
				dtm.setRowCount(0);
				lusuario.setVisible(false);
				lnusuario.setVisible(false);
				ltodo.setVisible(true);
				tnombre.setVisible(false);
				buscar.setVisible(true);
				lupa.setVisible(false);
			}
			if(usuario.isSelected()==true) {
				dtm.setRowCount(0);
				lusuario.setVisible(true);
				lnusuario.setVisible(true);
				ltodo.setVisible(false);
				tnombre.setVisible(true);
				buscar.setVisible(false);
				lupa.setVisible(true);
			}
			
		
			
	}

	@Override
	public void run() {
		
		dtm.setRowCount(0);
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
	public void salir() {
		
		try {
			this.setClosed(true);
			cerrado = true;
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}

	@Override
	public void setConsulta(ResultSet rs) {
		this.rs=rs;
		
	}

	@Override
	public String getConsulta() {
		
		return sql;
	
	}

	@Override
	public void setControlador(CAuditoria ca) {
		this.controlador = ca;
		
		buscar.addActionListener(ca);
		lupa.addActionListener(ca);
		exit.addActionListener(ca);
		limpiar.addActionListener(ca);
		
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		tnombre.setText("");
		dtm.setRowCount(0);
	}

	@Override
	public String getUsuario() {
		// TODO Auto-generated method stub
		return tnombre.getText();
	}

	@Override
	public void setConsulta1(ResultSet rs) {
		// TODO Auto-generated method stub
		this.rs=rs;
	}

	@Override
	public String getConsulta1() {
		// TODO Auto-generated method stub
		return "SELECT A.hora_y_fecha, U.nombre_usuario, P.codigo, A.Operacion  FROM auditorias A, usuarios U, productos P WHERE U.id_usuario = A.id_usuario AND P.id_producto = A.id_producto AND U.nombre_usuario = '"+tnombre.getText()+"';";
	}

	@Override
	public void desplegar() {
		dtm.setRowCount(0);
		try {
			if (rs.first()) {
				rs.beforeFirst();

				while (rs.next()) {
					Object[] filas = new Object[4];
					filas[0] = rs.getString(1);
					filas[1] = rs.getString(2);
					filas[2] = rs.getString(3);
					filas[3] = rs.getString(4);
					
					dtm.addRow(filas);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existen datos para la Consulta.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}

}
