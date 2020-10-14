package view;
//
import java.awt.BorderLayout;
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
import javax.swing.JTextField;

import controller.CCliente;

public class VCliente extends JInternalFrame implements ICliente,ItemListener,ActionListener {

	CCliente controlador;
    JComboBox<?> cbTipo;
    JComboBox<?> cbEstados;
    JComboBox<?> cbVendedor;
	ComboBoxModel cbm;
	ComboBoxModel cbm2;
	ComboBoxModel cbm3;
	
   private JTextField tNombre,tRif,tId,tBorrado,tDireccion,tTelefono,idTipo,idEstado,idVendedor,tVendedor,tEstado,tTipo,borradoVendedor;
	private JPanel pde, piz;
	private Color  darkblue =  new Color(33, 79, 129);
	private Color  white =  new Color(244, 245, 240);
	private Color  grey =  new Color(147, 151, 178);
	private Color  lightblue =  new Color(133, 169, 203);
	private JButton BCaceptar, BMaceptar, BBaceptar,  borrar, crear, limpiar, modificar, salir, exit; 
	private JButton bBuscar;
	private JLabel rif, nombre, tipop, direccion, telefono, estado, svendedor;
	private Validacion val;
	private boolean valrif, valnombre, valdireccion, valtelefono, valcbtipo, valcbestado, valcbvendedor;
	private boolean cerrado = true;

	public VCliente() {
		// TODO Auto-generated constructor stub
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
					
					piz.add(BCaceptar,reglasiz);
					
					BMaceptar = new JButton();
					BMaceptar.setContentAreaFilled(false);
					BMaceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
					BMaceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
					BMaceptar.setBackground(darkblue);
					BMaceptar.setBorder(null);
					BMaceptar.setVisible(false);
					reglasiz.gridy=4;
					
					
					piz.add(BMaceptar,reglasiz);
					
					BBaceptar = new JButton();
					BBaceptar.setContentAreaFilled(false);
					BBaceptar.setIcon(new ImageIcon("recursos/img/aceptarON.png"));
					BBaceptar.setRolloverIcon(new ImageIcon("recursos/img/aceptarOFF.png"));
					BBaceptar.setBackground(darkblue);
					BBaceptar.setBorder(null);
					BBaceptar.setVisible(false);
					reglasiz.gridy=4;
					
					
					piz.add(BBaceptar,reglasiz);
					

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
					
						// panel derecho//
					
					pde = new JPanel();
					pde.setBackground(darkblue);
					
					GridBagLayout gbde = new GridBagLayout();
					gbde.columnWidths = new int[] { 100, 550, 50 };
					gbde.rowHeights = new int[] { 150, 60, 60, 60, 60, 60, 60, 60,60, 50 }; 
					GridBagConstraints reglasde = new GridBagConstraints();
					pde.setLayout(gbde);
					
					JLabel titulo = new JLabel("CLIENTES");
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
					
					
					rif = new JLabel("R.I.F: ");
					rif.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					rif.setForeground(white);
					rif.setBackground(darkblue);
					reglasde.gridy = 1;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					rif.setVisible(true);
					
					pde.add(rif,reglasde);
					
					tRif = new JTextField(4);
					tRif.setBackground(white);
					tRif.setForeground(Color.BLACK);
					tRif.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 1;
					reglasde.gridx = 1;
					tRif.setVisible(true);

					pde.add(tRif, reglasde);
					
					bBuscar = new JButton(); 
					bBuscar.setContentAreaFilled(false);
					bBuscar.setIcon(new ImageIcon("recursos/img/lupaON.png"));
					bBuscar.setRolloverIcon(new ImageIcon("recursos/img/lupaOFF.png"));
					bBuscar.setBackground(darkblue);
					bBuscar.setBorder(null);
					bBuscar.addActionListener(this);
					bBuscar.setVisible(true);
					reglasde.gridx = 2;

					pde.add(bBuscar, reglasde);
					
					nombre = new JLabel("Nombre: ");
					nombre.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					nombre.setForeground(white);
					nombre.setBackground(darkblue);
					reglasde.gridy = 2;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					nombre.setVisible(true);

					pde.add(nombre, reglasde);
					
					tNombre = new JTextField(4);
					tNombre.setBackground(white);
					tNombre.setForeground(Color.BLACK);
					tNombre.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 2;
					reglasde.gridx = 1;
					tNombre.setEditable(false);
					tNombre.setVisible(true);
					
					pde.add(tNombre, reglasde);
					
					tipop = new JLabel("Tipo Persona: ");
					tipop.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					tipop.setForeground(white);
					tipop.setBackground(darkblue);
					reglasde.gridy = 3;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					tipop.setVisible(true);
					
					pde.add(tipop, reglasde);
					
					 cbTipo=new JComboBox<>();
				     
					reglasde.gridy = 3;
					reglasde.gridx = 1;
				    
					cbTipo.setVisible(false);
					cbTipo.addItemListener(this);
					pde.add(cbTipo, reglasde);
					
					idTipo=new JTextField(8);
					idTipo.setVisible(false);
					reglasde.gridy = 8;
					reglasde.gridx = 1;
					pde.add(idTipo,reglasde);
					
					tTipo=new JTextField(4);
					tTipo.setEditable(false);
					tTipo.setVisible(true);
					tTipo.setBackground(white);
					tTipo.setForeground(Color.BLACK);
					tTipo.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 3;
					reglasde.gridx = 1;
					pde.add(tTipo,reglasde);
					
					
					direccion = new JLabel("Direccion: ");
					direccion.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					direccion.setForeground(white);
					direccion.setBackground(darkblue);
					reglasde.gridy = 4;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					
					direccion.setVisible(true);
					
					pde.add(direccion, reglasde);
					
					tDireccion = new JTextField(4);
					tDireccion.setBackground(white);
					tDireccion.setForeground(Color.BLACK);
					tDireccion.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 4;
					reglasde.gridx = 1;
					tDireccion.setEditable(false);
					tDireccion.setVisible(true);
					
					pde.add(tDireccion, reglasde);
					
					telefono = new JLabel("Telefono: ");
					telefono.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					telefono.setForeground(white);
					telefono.setBackground(darkblue);
					reglasde.gridy = 5;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					telefono.setVisible(true);
					
					pde.add(telefono, reglasde);
					
					tTelefono = new JTextField(4);
					tTelefono.setBackground(white);
					tTelefono.setForeground(Color.BLACK);
					tTelefono.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 5;
					reglasde.gridx = 1;
					tTelefono.setEditable(false);
					tTelefono.setVisible(true);
					
					pde.add(tTelefono, reglasde);

					estado = new JLabel("Estado: ");
					estado.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					estado.setForeground(white);
					estado.setBackground(darkblue);
					reglasde.gridy = 6;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					estado.setVisible(true);
					
					pde.add(estado, reglasde);
					
					 cbEstados=new JComboBox<>();
					cbEstados.addItemListener(this);
					reglasde.gridy = 6;
					reglasde.gridx = 1;
					cbEstados.setVisible(false);
					
					pde.add(cbEstados, reglasde);
					
					idEstado=new JTextField(8);
					idEstado.setVisible(false);
					reglasde.gridy = 6;
					reglasde.gridx = 1;
					idEstado.setVisible(false);
					
			        pde.add(cbEstados,reglasde);	
			        
			        tEstado=new JTextField(4);
			        tEstado.setEditable(false);
			        tEstado.setVisible(true);
			        tEstado.setBackground(white);
					tEstado.setForeground(Color.BLACK);
					tEstado.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
			        reglasde.gridy = 6;
					reglasde.gridx = 1;
					pde.add(tEstado,reglasde);
			        
			        
					svendedor = new JLabel("Vendedor: "); 
					svendedor.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 20));
					svendedor.setForeground(white);
					svendedor.setBackground(darkblue);
					reglasde.gridy = 7;
					reglasde.gridx = 0;
					reglasde.fill = GridBagConstraints.HORIZONTAL;
					svendedor.setVisible(true);
					
					pde.add(svendedor, reglasde);
					
					
					cbVendedor=new JComboBox<>();
					cbVendedor.addItemListener(this);
					reglasde.gridy = 7;
					reglasde.gridx = 1;
					cbVendedor.setVisible(false);
					
					pde.add(cbVendedor, reglasde);
					
					idVendedor=new JTextField(8);
					idVendedor.setVisible(false);
					reglasde.gridy = 8;
					reglasde.gridx = 1;
					pde.add(idVendedor,reglasde);
					
					tVendedor=new JTextField(4);
					tVendedor.setVisible(true);
					tVendedor.setEditable(false);
					tVendedor.setBackground(white);
					tVendedor.setForeground(Color.BLACK);
					tVendedor.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
					reglasde.gridy = 7;
					reglasde.gridx = 1;
					pde.add(tVendedor,reglasde);
					
					tId=new JTextField(8);
					tId.setVisible(false);
					reglasde.gridy = 7;
					reglasde.gridx = 1;
					tId.setVisible(false);
					pde.add(tId,reglasde);
					
					borradoVendedor=new JTextField(8);
					reglasde.gridy = 8;
					reglasde.gridx = 1;
					borradoVendedor.setVisible(false);
					pde.add(borradoVendedor,reglasde);
					
					
					
					tBorrado=new JTextField(8);
					tBorrado.setVisible(false);
					reglasde.gridy = 7;
					reglasde.gridx = 1;
					tBorrado.setVisible(false);
					pde.add(tBorrado,reglasde);
					
					rules.gridx = 0;
					rules.gridy = 0;
					rules.fill = GridBagConstraints.BOTH;
					cp.add(piz, rules);
					
					rules.gridx = 1;
					rules.gridy = 0;
					rules.fill = GridBagConstraints.BOTH;
					cp.add(pde, rules);
					cp.add(pde);
					
	
						bBuscar.setActionCommand(ICliente.BUSCAR);
						BCaceptar.setActionCommand(ICliente.CREAR);
						BMaceptar.setActionCommand(ICliente.MODIFICAR);
						BBaceptar.setActionCommand(ICliente.BORRAR);
						limpiar.setActionCommand(ICliente.LIMPIAR);
						exit.setActionCommand(ICliente.EXIT);
						
								// VALIDACION MAXIMOS CARACTERES//
						
						val = new Validacion();
						val.ValidarCantidad(tRif,9 );
						val.ValidarCantidad(tNombre, 100);
						val.ValidarCantidad(tTelefono, 11);
						val.ValidarCantidad(tDireccion, 100);
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()== ItemEvent.SELECTED) {
			controlador.actionPerformed(new ActionEvent(this, 1, ICliente.COMBOITEM));}
		if(e.getStateChange()== ItemEvent.SELECTED) {
			controlador.actionPerformed(new ActionEvent(this, 1, ICliente.COMBOITEM2));}
		if(e.getStateChange()== ItemEvent.SELECTED) {
			controlador.actionPerformed(new ActionEvent(this, 1, ICliente.COMBOITEM3));}
		
		}
							//SET COMBOS//
	
	@Override
	public void setCombo(DefaultComboBoxModel<?> dcbm) {
		// TODO Auto-generated method stub
		this.cbm=dcbm;
	}
	
	@Override
	public void setCombo2(DefaultComboBoxModel<?> dcbm2) {
		// TODO Auto-generated method stub
		   this.cbm2=dcbm2;	
	}

	@Override
	public void setCombo3(DefaultComboBoxModel<?> dcbm3) {
		// TODO Auto-generated method stub
		   this.cbm3=dcbm3;	

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

							//DESPLEGAR//
	@Override
	public void desplegar() {
		// TODO Auto-generated method stub
		controlador.actionPerformed(new ActionEvent(this, 2, ICliente.COMBO));
	    cbTipo.setModel(cbm); 

	}

	@Override
	public void desplegar2() {
		// TODO Auto-generated method stub
		controlador.actionPerformed(new ActionEvent(this, 2, ICliente.COMBO2));
	    cbEstados.setModel(cbm2);
	}
        
   @Override
   public void desplegar3() {
	// TODO Auto-generated method stub
	controlador.actionPerformed(new ActionEvent(this, 2, ICliente.COMBO3));
    cbVendedor.setModel(cbm3);
    }
	
   							//GET COMBO//
	
	@Override
	public Object getComboItem() {
		// TODO Auto-generated method stub
		return cbTipo.getSelectedItem();
	}

	public Object getComboItem2() {
		// TODO Auto-generated method stub
		return cbEstados.getSelectedItem();
	}

	@Override
	public Object getComboItem3() {
		// TODO Auto-generated method stub
		return cbVendedor.getSelectedItem();
	}
	
						//GET//	
@Override
public String getRif() {
	// TODO Auto-generated method stub
	return  tRif.getText().toUpperCase();
}

@Override
public String getNombre() {
	// TODO Auto-generated method stub
		return tNombre.getText().toUpperCase();
}

@Override
public String getTelefono() {
	// TODO Auto-generated method stub
	return tTelefono.getText().toUpperCase();
}

@Override
public String getDireccion() {
	// TODO Auto-generated method stub
	return tDireccion.getText().toUpperCase();
	
} 
@Override
public int getId() {
	// TODO Auto-generated method stub
	return  Integer.parseInt(tId.getText());
}

@Override
public boolean getBorrado() {
	// TODO Auto-generated method stub
	return false;
}
  
@Override
public int getIdTipo() {
	// TODO Auto-generated method stub
	return Integer.parseInt(idTipo.getText());
}

@Override
public int getIdEstado() {
	// TODO Auto-generated method stub
	return Integer.parseInt(idEstado.getText());
}

@Override
public int getIdvendedor() {
	// TODO Auto-generated method stub
	return Integer.parseInt(idVendedor.getText());
}


	@Override
	public void setControlador(CCliente c) {
		// TODO Auto-generated method stub
		controlador=c;
		bBuscar.addActionListener(c);
		exit.addActionListener(c);
		BCaceptar.addActionListener(c);
		BMaceptar.addActionListener(c);
		BBaceptar.addActionListener(c);
		limpiar.addActionListener(c);
		
	}

	@Override
	public void setEscribir(String id, String rif, String nombre, String direccion,String telefono,String idvendedor,String idtipo,String idestado,String ntipo, String nestado , String nvendedor, String borrado) {
		// TODO Auto-generated method stub
		
		this.tId.setText(id);
		this.tRif.setText(rif);
		this.tNombre.setText(nombre);
		this.tDireccion.setText(direccion);
		this.tTelefono.setText(telefono);
		this.idVendedor.setText(idvendedor);
		this.idTipo.setText(idtipo);
		this.idEstado.setText(idestado);
		this.tBorrado.setText(borrado);
		this.tEstado.setText(nestado);
		this.tTipo.setText(ntipo);
		this.tVendedor.setText(nvendedor);	
	}

	@Override
	public void setCombo(int com, int com2, int com3) {
		// TODO Auto-generated method stub
		cbEstados.setSelectedIndex(com);
		cbTipo.setSelectedIndex(com2);
		cbVendedor.setSelectedIndex(com3);
	}

	@Override
	public void setIdTipo(String idtipos) {
		// TODO Auto-generated method stub
		this.idTipo.setText(idtipos);	
	}
	
	@Override
	public void setIdEstado(String idestaos) {
		// TODO Auto-generated method stub
       this.idEstado.setText(idestaos);		
	}

	@Override
	public void setIdVendedor(String idvendedor) {
		// TODO Auto-generated method stub
		this.idVendedor.setText(idvendedor);
	}
	
					//BOTONES PANEL IZQUIERDO//
	
	@Override
	public void actionPerformed(ActionEvent ee) {
		// TODO Auto-generated method stub
		
		JButton bt = (JButton) ee.getSource();

   if (bt == crear) {

	crear.setVisible(true);
	modificar.setVisible(false);
	borrar.setVisible(false);
	BCaceptar.setVisible(true);
	BMaceptar.setVisible(false);
	BBaceptar.setVisible(false);
	limpiar.setVisible(true);
	salir.setVisible(true);
	crear.setEnabled(false);
	modificar.setEnabled(true);
	borrar.setEnabled(true);
	
	tRif.setEditable(true);
	tNombre.setEditable(true);
	tDireccion.setEditable(true);
	tTelefono.setEditable(true);
	
	tRif.setText("");
	tNombre.setText("");
	tDireccion.setText("");
	tTelefono.setText("");
	tEstado.setText("");
	tVendedor.setText("");
	tTipo.setText("");
	bBuscar.setVisible(false);
	
	rif.setVisible(true);
	tRif.setVisible(true);
	nombre.setVisible(true);
	tNombre.setVisible(true);
	tipop.setVisible(true);
	cbTipo.setVisible(true);
	direccion.setVisible(true);
	tDireccion.setVisible(true);
	telefono.setVisible(true);
	tTelefono.setVisible(true);
	estado.setVisible(true);
	cbEstados.setVisible(true);
	svendedor.setVisible(true);
	cbVendedor.setVisible(true);
	
	cbEstados.setSelectedIndex(0);
	cbTipo.setSelectedIndex(0);
	cbVendedor.setSelectedIndex(0);
	tEstado.setVisible(false);
	tVendedor.setVisible(false);
	tTipo.setVisible(false);
	
}

   else if (bt == modificar) {
	crear.setVisible(false);
	modificar.setVisible(true);
	borrar.setVisible(false);
	BCaceptar.setVisible(false);
	BMaceptar.setVisible(true);
	BBaceptar.setVisible(false);
	limpiar.setVisible(true);
	salir.setVisible(true);
	
	rif.setVisible(true);
	tRif.setVisible(true);
	nombre.setVisible(true);
	tNombre.setVisible(true);
	tipop.setVisible(true);
	cbTipo.setVisible(true);
	direccion.setVisible(true);
	tDireccion.setVisible(true);
	telefono.setVisible(true);
	tTelefono.setVisible(true);
	estado.setVisible(true);
	cbEstados.setVisible(true);
	svendedor.setVisible(true);
	cbVendedor.setVisible(true);
	
	tRif.setEditable(true);
	tNombre.setEditable(true);
	tDireccion.setEditable(true);
	tTelefono.setEditable(true);
	bBuscar.setVisible(false); 
	tEstado.setVisible(false);
	tVendedor.setVisible(false);
	tTipo.setVisible(false);
}

   else if (bt == borrar) {
	crear.setVisible(false);
	modificar.setVisible(false);
	borrar.setVisible(true);
	BCaceptar.setVisible(false);
	BMaceptar.setVisible(false);
	BBaceptar.setVisible(true);
	limpiar.setVisible(true);
	salir.setVisible(true);
	
	rif.setVisible(true);
	tRif.setVisible(true);
	nombre.setVisible(true);
	tNombre.setVisible(true);
	tipop.setVisible(true);
	cbTipo.setVisible(false);
	direccion.setVisible(true);
	tDireccion.setVisible(true);
	telefono.setVisible(true);
	tTelefono.setVisible(true);
	estado.setVisible(true);
	cbEstados.setVisible(false);
	svendedor.setVisible(true);
	cbVendedor.setVisible(false);
	
	tRif.setEditable(true);
	tNombre.setEditable(false);
	tDireccion.setEditable(false);
	tTelefono.setEditable(false);
	bBuscar.setVisible(false);

	tEstado.setVisible(true);
	tVendedor.setVisible(true);
	tTipo.setVisible(true);
	
}

   else if (bt == salir) {
	crear.setVisible(true);
	modificar.setVisible(true);
	borrar.setVisible(true);
	BCaceptar.setVisible(false);
	BMaceptar.setVisible(false);
	BBaceptar.setVisible(false);
	limpiar.setVisible(false);
	salir.setVisible(false);
	tRif.setEditable(true);
	tNombre.setEditable(false);
	tDireccion.setEditable(false);
	tTelefono.setEditable(false);
	tRif.setText("");
	tNombre.setText("");
	tDireccion.setText("");
	tTelefono.setText("");
	tVendedor.setText("");
	tEstado.setText("");
	tTipo.setText("");
    bBuscar.setVisible(true);
	
	rif.setVisible(true);
	tRif.setVisible(true);
	nombre.setVisible(true);
	tNombre.setVisible(true);
	tipop.setVisible(true);
	cbTipo.setVisible(false);
	direccion.setVisible(true);
	tDireccion.setVisible(true);
	telefono.setVisible(true);
	tTelefono.setVisible(true);
	estado.setVisible(true);
	cbEstados.setVisible(false);
	svendedor.setVisible(true);
	cbVendedor.setVisible(false);
	
	cbEstados.setSelectedIndex(0);
	cbTipo.setSelectedIndex(0);
	cbVendedor.setSelectedIndex(0);
	
	crear.setEnabled(true);
	tEstado.setVisible(true);
	tVendedor.setVisible(true);
	tTipo.setVisible(true);
	
} 
   else if(bt==bBuscar) {
	   
	rif.setVisible(true);
	tRif.setVisible(true);
	nombre.setVisible(true);
	tNombre.setVisible(true);
	tipop.setVisible(true);
	cbTipo.setVisible(false);
	direccion.setVisible(true);
	tDireccion.setVisible(true);
	telefono.setVisible(true);
	tTelefono.setVisible(true);
	estado.setVisible(true);
	cbEstados.setVisible(false);
	svendedor.setVisible(true);
	cbVendedor.setVisible(false);
	
	tRif.setEditable(true);
	tNombre.setEditable(false);
	tDireccion.setEditable(false);
	tTelefono.setEditable(false);
	bBuscar.setVisible(true);

	tEstado.setVisible(true);
	tVendedor.setVisible(true);
	tTipo.setVisible(true);
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
	public boolean getValRif() {
		// TODO Auto-generated method stub
		
		if (tRif.getText().length() < 9) {
			return valrif= false;
	
		} else {
			return valrif= true;
		}
	}


	@Override
	public boolean getValDirecc() {
		// TODO Auto-generated method stub
		
		if (tDireccion.getText().length() <12) {
			return valdireccion = false;
		} else {
			return valdireccion= true;
		}
	}


	@Override
	public boolean getValTele() {
		// TODO Auto-generated method stub
		if (tTelefono.getText().length() <11) {
			return valtelefono = false;
		} else {
			return valtelefono= true;
		}
	}


	@Override
	public boolean getValNomb() {
		// TODO Auto-generated method stub
		if (tNombre.getText().length() <7) {
			return valnombre = false;
		} else {
			return valnombre= true;
		}
	}


	@Override
	public int getBorradoVendedor() {
		// TODO Auto-generated method stub
		return Integer.parseInt(borradoVendedor.getText());
	}


	@Override
	public void setBorradoVendedor(String borrado2) {
		// TODO Auto-generated method stub
		this.borradoVendedor.setText(borrado2);
	}


	


	@Override
	public boolean getValTp() {
		// TODO Auto-generated method stub
	
		if (idTipo.getText().contentEquals(" ")) {
			return valcbtipo= false;
		} else {
			return valcbtipo= true;
	}
		}
			

	@Override
	public boolean getValEst() {
		// TODO Auto-generated method stub
		if (idEstado.getText().equals(" ")) {
			return valcbestado= false;
		} else {
			return valcbestado= true;
		}
	}


	@Override
	public boolean getValVen() {
		// TODO Auto-generated method stub
		if (idVendedor.getText().equals(" ")) {
			return valcbvendedor= false;
	} else {
		return valcbvendedor= true;
	}
}


	@Override
	public void regresaalmenu() {
		// TODO Auto-generated method stub
		crear.setVisible(true);
		modificar.setVisible(true);
		borrar.setVisible(true);
		BCaceptar.setVisible(false);
		BMaceptar.setVisible(false);
		BBaceptar.setVisible(false);
		limpiar.setVisible(false);
		salir.setVisible(false);
		tRif.setEditable(true);
		tNombre.setEditable(false);
		tDireccion.setEditable(false);
		tTelefono.setEditable(false);
		tRif.setText("");
		tNombre.setText("");
		tDireccion.setText("");
		tTelefono.setText("");
		tVendedor.setText("");
		tEstado.setText("");
		tTipo.setText("");
	    bBuscar.setVisible(true);
		
		rif.setVisible(true);
		tRif.setVisible(true);
		nombre.setVisible(true);
		tNombre.setVisible(true);
		tipop.setVisible(true);
		cbTipo.setVisible(false);
		direccion.setVisible(true);
		tDireccion.setVisible(true);
		telefono.setVisible(true);
		tTelefono.setVisible(true);
		estado.setVisible(true);
		cbEstados.setVisible(false);
		svendedor.setVisible(true);
		cbVendedor.setVisible(false);
		
		cbEstados.setSelectedIndex(0);
		cbTipo.setSelectedIndex(0);
		cbVendedor.setSelectedIndex(0);
		
		crear.setEnabled(true);
		tEstado.setVisible(true);
		tVendedor.setVisible(true);
		tTipo.setVisible(true);
	}


	@Override
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}
}