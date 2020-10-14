package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MDI extends JFrame implements ActionListener {

	private JDesktopPane fondo;
	private JMenuBar menuBar;
	private JMenu reporte, modulos, informacion;
	private JMenuItem ReporteClie, ReportePro, ReporteVen, ReporteVXV, ReporteVXZ, ReporteVMClie, AbrirPro, AbrirZona, AbrirVendedor;
	private JMenuItem AbrirVenta, AbrirCliente, AbrirTipo, AbrirDepartamento, AbrirAuditoria, AbrirUsuarios;
	private JMenuItem ayu, pyv, vyz, cyt;
	private JPanel etiquetas;
	private VProducto producto;
	private VReporteClientes reportesclientes;
	private VReporteVendedores reportevendedores;
	private VReporteProductos reporteproductos;
	private VReporteMejoresClientes reportemejorcliente;
	private VZona zona;
	private VVendedores vendedor;
	private VReporteVentasporVendedor vxv;
	private VReporteVentasporZonas vxz;
	private VVenta venta;
	private VCliente cliente;
	private VTipoPersona tipo;
	private VDepartamento departamento;
	private VAuditoria auditoria;
	private VUsuarios usuarios;
	private JLabel mejorvendedor, montototalventas, productomasven, totalclientes;
	private GridBagConstraints rules;

	public MDI(boolean Admin, IProducto producto, IReporteClientes reportesclientes, IReporteVendedores reportevendedores, IZona zona,
			IReporteProductos reporteproductos, IVendedores vendedor, IReporteVentasporVendedor vxv,
			IReporteVentasporZonas vxz, IReporteMejoresClientes reportemejorcliente, IVenta venta, ICliente cliente, ITipoPersona tipo,
			IDepartamento departamento, IAuditoria auditoria, IUsuarios usuarios) {
		super("JPTelematics");

		this.producto = new VProducto();
		this.producto = (VProducto) producto;
		this.reportesclientes = new VReporteClientes();
		this.reportesclientes = (VReporteClientes) reportesclientes;
		this.reportevendedores = new VReporteVendedores();
		this.reportevendedores = (VReporteVendedores) reportevendedores;
		this.zona = new VZona();
		this.zona = (VZona) zona;
		this.reporteproductos = new VReporteProductos();
		this.reporteproductos = (VReporteProductos) reporteproductos;
		this.vendedor = new VVendedores();
		this.vendedor = (VVendedores) vendedor;
		this.vxv = new VReporteVentasporVendedor();
		this.vxv = (VReporteVentasporVendedor) vxv;
		this.vxz = new VReporteVentasporZonas();
		this.vxz = (VReporteVentasporZonas) vxz;
		this.reportemejorcliente = new VReporteMejoresClientes();
		this.reportemejorcliente = (VReporteMejoresClientes) reportemejorcliente;
		this.venta = new VVenta();
		this.venta = (VVenta) venta;
		this.cliente = new VCliente();
		this.cliente = (VCliente) cliente;
		this.tipo = new VTipoPersona();
		this.tipo = (VTipoPersona) tipo;
		this.departamento = new VDepartamento();
		this.departamento = (VDepartamento) departamento;
		this.auditoria = new VAuditoria();
		this.auditoria = (VAuditoria) auditoria;
		this.usuarios = new VUsuarios();
		this.usuarios = (VUsuarios) usuarios;

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salir();
			}
		});
		this.setSize(1100, 750);
		this.setLocationRelativeTo(null);
		fondo = new JDesktopPane();
		fondo.setOpaque(false);
		GridBagLayout gb = new GridBagLayout();
		gb.columnWidths = new int[] {1000};
		gb.rowHeights = new int[] {40,610,40};
		
		fondo.setLayout(gb);
		rules = new GridBagConstraints();
		
		etiquetas = new JPanel(new GridLayout(2,2));

		mejorvendedor = new JLabel("Mejor Vendedor: ");
		mejorvendedor.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		mejorvendedor.setHorizontalAlignment(SwingConstants.CENTER);
		mejorvendedor.setForeground(Color.BLACK);
		etiquetas.add(mejorvendedor);

		montototalventas = new JLabel("Monto Total Vendido: $");
		montototalventas.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		montototalventas.setHorizontalAlignment(SwingConstants.CENTER);
		montototalventas.setForeground(Color.BLACK);
		etiquetas.add(montototalventas);

		productomasven = new JLabel("Producto Más Vendido: ");
		productomasven.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		productomasven.setHorizontalAlignment(SwingConstants.CENTER);
		productomasven.setForeground(Color.BLACK);
		etiquetas.add(productomasven);

		totalclientes = new JLabel("Clientes Totales: ");
		totalclientes.setFont(new Font("Arial Round TM Bold", Font.BOLD + Font.ITALIC, 10));
		totalclientes.setHorizontalAlignment(SwingConstants.CENTER);
		totalclientes.setForeground(Color.BLACK);
		etiquetas.add(totalclientes);
		
		rules.gridx = 0;
		rules.gridy = 0;
		rules.fill = GridBagConstraints.NONE;
		
		etiquetas.setOpaque(false);
		etiquetas.setSize(1100,750);
		etiquetas.setVisible(true);
		fondo.add(etiquetas, rules);
		rules.fill = GridBagConstraints.BOTH;
		
		rules.gridy = 1;
		
		this.setContentPane(fondo);

		ImageIcon uno = new ImageIcon("recursos/img/fondomdi.png");
		JLabel fondo2 = new JLabel();
		fondo2.setIcon(uno);
		getLayeredPane().add(fondo2, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo2.setBounds(0, 24, uno.getIconWidth(), uno.getIconHeight());

		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createBevelBorder(0, new Color(33, 79, 129), new Color(0, 0, 0)));
		menuBar.setBackground(new Color(33,79,129));
		this.setJMenuBar(menuBar);

		reporte = new JMenu("Reportes");
		reporte.setForeground(Color.white);
		
		ReporteClie = new JMenuItem("Listado De Clientes");
		ReporteClie.addActionListener(this);
		reporte.add(ReporteClie);

		ReportePro = new JMenuItem("Listado De Productos");
		ReportePro.addActionListener(this);
		reporte.add(ReportePro);

		ReporteVen = new JMenuItem("Listado de Vendedores");
		ReporteVen.addActionListener(this);
		reporte.add(ReporteVen);
		
		ReporteVXV = new JMenuItem("Listado de Ventas Por Vendedor");
		ReporteVXV.addActionListener(this);
		reporte.add(ReporteVXV);
		
		ReporteVXZ = new JMenuItem("Listado de Ventas Por Zonas");
		ReporteVXZ.addActionListener(this);
		reporte.add(ReporteVXZ);
		
		ReporteVMClie = new JMenuItem("Mejores Clientes");
		ReporteVMClie.addActionListener(this);
		reporte.add(ReporteVMClie);

		modulos = new JMenu("MODULOS");
		modulos.setForeground(Color.white);

		AbrirPro = new JMenuItem("Productos");
		AbrirPro.addActionListener(this);
		modulos.add(AbrirPro);

		AbrirZona = new JMenuItem("Zonas");
		AbrirZona.addActionListener(this);
		modulos.add(AbrirZona);

		AbrirVendedor = new JMenuItem("Vendedores");
		AbrirVendedor.addActionListener(this);
		modulos.add(AbrirVendedor);
		
		AbrirVenta = new JMenuItem("Ventas");
		AbrirVenta .addActionListener(this);
		modulos.add(AbrirVenta);
		
		AbrirCliente = new JMenuItem("Clientes");
		AbrirCliente .addActionListener(this);
		modulos.add(AbrirCliente);
		
		AbrirTipo = new JMenuItem("Tipo de Persona");
		AbrirTipo .addActionListener(this);
		modulos.add(AbrirTipo);
		
		AbrirDepartamento = new JMenuItem("Departamentos");
		AbrirDepartamento.addActionListener(this);
		modulos.add(AbrirDepartamento);
		
		AbrirAuditoria = new JMenuItem("Auditorias");
		AbrirAuditoria.addActionListener(this);
		modulos.add(AbrirAuditoria);
		
		informacion = new JMenu("INFORMACION");
		informacion.setForeground(Color.white);
		
		pyv = new JMenuItem("VENTAS Y PRODUCTOS");
		pyv .addActionListener(this);
		informacion.add(pyv);
		
		vyz = new JMenuItem("ZONAS Y VENDEDORES");
		vyz .addActionListener(this);
		informacion.add(vyz);
		
		cyt = new JMenuItem("CLIENTES Y TIPO DE PERSONA");
		cyt .addActionListener(this);
		informacion.add(cyt);
		
		ayu = new JMenuItem("AUDITORIAS Y USUARIOS");
		ayu .addActionListener(this);
		informacion.add(ayu);

		menuBar.add(modulos);
		menuBar.add(reporte);
		menuBar.add(informacion);
		
		if (Admin == true) {
			AbrirUsuarios = new JMenuItem("Usuarios");
			AbrirUsuarios .addActionListener(this);
			modulos.add(AbrirUsuarios);
		}

	}
	public void escribirDashboard(String a, String b, String e, String d) {
		
		mejorvendedor.setText(a);
		montototalventas.setText(b);
		productomasven.setText(e);
		totalclientes.setText(d);
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == AbrirPro && producto.getCerrado() == true) {
			fondo.add(producto, rules);
			producto.run();
			producto.limpiar();
			producto.setBounds(50, 10, 1000, 600);
		}
		
		if (e.getSource() == ReporteClie && reportesclientes.getCerrado() == true) {

			reportesclientes.setBounds(50, 10, 1000, 600);
			fondo.add(reportesclientes, rules);
			reportesclientes.run();
			reportesclientes.desplegar();
		}

		if (e.getSource() == ReporteVen && reportevendedores.getCerrado() == true) {

			reportevendedores.setBounds(50, 10, 1000, 600);
			fondo.add(reportevendedores, rules);
			reportevendedores.run();
			reportevendedores.desplegar();
		}
		if (e.getSource() == AbrirZona && zona.getCerrado() == true) {
			fondo.add(zona, rules);
			zona.run();
			zona.limpiar();
			zona.setBounds(50, 10, 1000, 600);
		}
		if (e.getSource() == ReportePro && reporteproductos.getCerrado() == true) {

			reporteproductos.setBounds(50, 10, 1000, 600);
			fondo.add(reporteproductos, rules);
			reporteproductos.run();
			reporteproductos.desplegar();
		}
		if (e.getSource() == AbrirVendedor && vendedor.getCerrado() == true) {
			fondo.add(vendedor, rules);
			vendedor.run();
			vendedor.desplegar();
			vendedor.limpiar();
			vendedor.setBounds(50, 10, 1000, 600);
		}
		
		if (e.getSource() == AbrirVenta && venta.getCerrado() == true) {
			fondo.add(venta, rules);
			venta.runHora();
			venta.cargarCB();
			venta.run();
			venta.limpiar();
			venta.setBounds(50, 10, 1000, 635);
		}
		if (e.getSource() == AbrirCliente && cliente.getCerrado() == true) {
			fondo.add(cliente, rules);
			cliente.run();
			cliente.desplegar();
			cliente.desplegar2();
			cliente.desplegar3();
			cliente.setBounds(50, 10, 1000, 635);
		}
		
		if (e.getSource() == AbrirTipo && tipo.getCerrado() == true) {
			fondo.add(tipo, rules);
			tipo.run();
			tipo.setBounds(50, 10, 1000, 635);
		}
		if (e.getSource() == AbrirDepartamento && departamento.getCerrado() == true) {
			fondo.add(departamento, rules);
			departamento.run();
			departamento.limpiar();
			departamento.setBounds(50, 10, 1000, 635);
		}
		
		if (e.getSource() == AbrirAuditoria && auditoria.getCerrado() == true) {

			auditoria.setBounds(50, 10, 1000, 600);
			fondo.add(auditoria, rules);
			auditoria.run();
			auditoria.limpiar();
		}
		
		if (e.getSource() == AbrirUsuarios && usuarios.getCerrado() == true) {

			usuarios.setBounds(50, 10, 1000, 600);
			fondo.add(usuarios, rules);
			usuarios.run();
			usuarios.cargarCB();
			usuarios.limpiar();
		}
		
		if (e.getSource() == ReporteVXV && vxv.getCerrado() == true) {

			vxv.setBounds(50, 10, 1000, 600);
			fondo.add(vxv, rules);
			vxv.run();
			vxv.desplegar();
		}
		
		if (e.getSource() == ReporteVXZ && vxz.getCerrado() == true) {

			vxz.setBounds(50, 10, 1000, 600);
			fondo.add(vxz, rules);
			vxz.run();
			vxz.desplegar();
		}
		
		if (e.getSource() == ReporteVMClie && reportemejorcliente.getCerrado() == true) {

			reportemejorcliente.setBounds(50, 10, 1000, 600);
			fondo.add(reportemejorcliente, rules);
			reportemejorcliente.run();
			reportemejorcliente.desplegar();
		}
		
		if (e.getSource() == ReporteVMClie && reportemejorcliente.getCerrado() == true) {

			reportemejorcliente.setBounds(50, 10, 1000, 600);
			fondo.add(reportemejorcliente, rules);
			reportemejorcliente.run();
			reportemejorcliente.desplegar();
		}
		
		if (e.getSource() == pyv) {

			JOptionPane.showMessageDialog(null, "VENTAS Y PRODUCTOS:\n\nLAURA ORTEGA\nJACOBO BRAVO\nJUAN VILLEGAS\nCARLOS ESCALONA \nDILMAR LINAREZ");
		}
		if (e.getSource() == vyz) {

			JOptionPane.showMessageDialog(null, "ZONAS Y VENDEDORES:\n\nJOSE CARVAJAL\nMARIA CASTILLO\nRAUL GONZALEZ\nROSIBEL CORDERO\nJOSE CRESPO");
		}
		if (e.getSource() == cyt) {

			JOptionPane.showMessageDialog(null, "CLIENTES Y TIPO DE PERSONA:\n\nNICOLAS ESPAÑA\nJUAN TORREALBA\nMOISES TORREALBA\nROSANGEL TORRES\nMIGUEL YEPEZ\nJOSE RAMOS");
		}
		if (e.getSource() == ayu) {

			JOptionPane.showMessageDialog(null, "AUDITORIAS Y USUARIOS:\n\nGABRIELA ECHEVERRIA\nVICTOR MARTEL\nLUIS GUTIERREZ\nVICTOR PEREZ\nEMANUEL URQUIOLA");
		}

	}

	private void salir() {
		Toolkit.getDefaultToolkit().beep();
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "SALIDA DEL SISTEMA",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
