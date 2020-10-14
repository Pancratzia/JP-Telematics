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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CReporteClientes;

public class VReporteClientes extends JInternalFrame implements ActionListener, IReporteClientes {
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton salir;
	private JScrollPane sptabla;
	private JTable tabla;
	private DefaultTableModel dtm;
	private ResultSet resul = null;
	private CReporteClientes controlador;
	private String sql = "SELECT clientes.rif ,clientes.nombre,clientes.direccion, clientes.telefono,"
			+ "tipo_personas.t_nombre, estados.nombre_estado, vendedores.nombre_vendedor, vendedores.borrado FROM clientes, tipo_personas, estados, vendedores WHERE "
			+ "clientes.id_tipo_persona = tipo_personas.id_tipo_persona and clientes.id_estado = estados.id_estado and clientes.id_vendedor=vendedores.id_vendedor";
	private boolean cerrado = true;
	
	public VReporteClientes() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);

		Container cp = getContentPane();

		GridBagLayout gb1 = new GridBagLayout();
		gb1.columnWidths = new int[] { 50, 900, 50 };
		gb1.rowHeights = new int[] { 50, 500, 50 };
		GridBagConstraints reglas = new GridBagConstraints();

		cp.setBackground(darkblue);
		cp.setLayout(gb1);

		JLabel titulo = new JLabel("LISTADO DE CLIENTES"); // Titulo
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 50));
		titulo.setForeground(white);
		titulo.setBackground(darkblue);

		reglas.gridx = 1;
		reglas.gridy = 0;
		cp.add(titulo, reglas);

		salir = new JButton();
		salir.setIcon(new ImageIcon("recursos/img/exitON.png"));
		salir.setRolloverIcon(new ImageIcon("recursos/img/exitOFF.png"));
		salir.setPressedIcon(new ImageIcon("recursos/img/exitOFF.png"));
		salir.setContentAreaFilled(false);
		salir.setBorder(null);
		salir.addActionListener(this);

		reglas.gridx = 2;
		cp.add(salir, reglas);

		String[] titulos = { "RIF", "Nombre", "Dirección", "Teléfono", "Tipo De Persona", "Estado", "Vendedor" }; // Titulos
																													// del
																													// Reporte
		String[][] data = {};
		tabla = new JTable(data, titulos);
		tabla.setBackground(white);
		tabla.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tabla.setForeground(Color.BLACK);
		dtm = new DefaultTableModel();
		tabla.setModel(dtm);
		dtm.addColumn("RIF");
		dtm.addColumn("Nombre");
		dtm.addColumn("Dirección");
		dtm.addColumn("Teléfono");
		dtm.addColumn("Tipo de Persona");
		dtm.addColumn("Estado");
		dtm.addColumn("Vendedor");

		sptabla = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// HORIZONTAL_SCROLLBAR_AS_NEEDED si es necesario el scroll horizontal
		sptabla.setBackground(white);

		reglas.gridx = 1;
		reglas.gridy = 1;
		reglas.gridwidth = 1;
		reglas.fill = GridBagConstraints.BOTH;

		cp.add(sptabla, reglas);

	}

	@Override
	public void setConsulta(ResultSet rs) {
		// TODO Auto-generated method stub
		resul = rs;
	}

	@Override
	public void setControlador(CReporteClientes c) {
		// TODO Auto-generated method stub
		this.controlador = c;
	}

	@Override
	public String getConsulta() {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
	public void desplegar() {
		// TODO Auto-generated method stub
		controlador.actionPerformed(new ActionEvent(this, 1, IReporteClientes.IMPRIMIR));

		try {
			if (resul.first()) {
				resul.beforeFirst();

				while (resul.next()) {
					Object[] filas = new Object[7];
					filas[0] = resul.getString(1);
					filas[1] = resul.getString(2);
					filas[2] = resul.getString(3);
					filas[3] = resul.getString(4);
					filas[4] = resul.getString(5);
					filas[5] = resul.getString(6);

					if (resul.getString(8).equals("1")) {
						filas[6] = "No Asignado";
					}
					else filas[6] = resul.getString(7);
					

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bt = (JButton) e.getSource();

		if (bt == salir) {
			try {
				this.setClosed(true);
				cerrado = true;
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;

	}
	
}
