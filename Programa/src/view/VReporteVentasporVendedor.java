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

import controller.CReporteVentasporVendedor;

public class VReporteVentasporVendedor extends JInternalFrame implements ActionListener, IReporteVentasporVendedor {
	private Color darkblue = new Color(33, 79, 129);
	private Color white = new Color(244, 245, 240);
	private Color grey = new Color(147, 151, 178);
	private Color lightblue = new Color(133, 169, 203);
	private JButton salir;
	private JScrollPane sptabla;
	private JTable tabla;
	private DefaultTableModel dtm;
	private ResultSet resul = null;
	private boolean cerrado= true;
	private CReporteVentasporVendedor controlador;
	private String sql = "SELECT ventas.hora_y_fecha, ventas.total, "
			+ "vendedores.nombre_vendedor FROM ventas, clientes, vendedores "
			+ "WHERE ventas.id_cliente = clientes.id_cliente AND "
			+ "clientes.id_vendedor = vendedores.id_vendedor";

	public VReporteVentasporVendedor() {
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

		JLabel titulo = new JLabel("LISTADO DE VENTAS POR VENDEDOR"); // Titulo
		titulo.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 45));
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

		String[] titulos = { "Hora y Fecha", "Total de la venta", "Nombre del vendedor" }; // Titulos del Reporte
		String[][] data = {};
		tabla = new JTable(data, titulos);
		tabla.setBackground(white);
		tabla.setFont(new Font("Arial Round TM Bold", Font.BOLD, 16));
		tabla.setForeground(Color.BLACK);
		dtm = new DefaultTableModel();
		tabla.setModel(dtm);
		dtm.addColumn("Fecha y Hora");
		dtm.addColumn("Total de la venta");
		dtm.addColumn("Nombre del vendedor");

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
	public void setControlador(CReporteVentasporVendedor c) {
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
		controlador.actionPerformed(new ActionEvent(this, 1, IReporteVentasporVendedor.IMPRIMIR));

		try {
			if (resul.first()) {
				resul.beforeFirst();

				while (resul.next()) {
					Object[] filas = new Object[3];
					filas[0] = resul.getString(1);
					filas[1] = resul.getString(2);
					filas[2] = resul.getString(3);

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
