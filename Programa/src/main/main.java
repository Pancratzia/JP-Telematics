package main;

import controller.CReporteVendedores;
import controller.CReporteVentasporVendedor;
import controller.CReporteVentasporZonas;
import controller.CTipoPersona;
import controller.CUsuarios;
import controller.CVendedores;
import controller.CVenta;
import controller.CZona;

import java.text.DecimalFormat;

import controller.CAuditoria;
import controller.CCliente;
import controller.CDepartamento;
import controller.CLogin;
import controller.CProducto;
import controller.CReporteClientes;
import controller.CReporteMejoresClientes;
import controller.CReporteProductos;
import model.BDConex;
import model.DatosCliente;
import model.MCliente;
import model.MDepartamento;
import model.MIva;
import model.MLogin;
import model.MMDI;
import model.MOperarLogin;
import model.MProductos;
import model.MTipoPersona;
import model.MUsuarios;
import model.MVendedores;
import model.MVenta;
import model.MZona;
import model.MZonaCB;
import model.OperarMDI;
import model.OperarProducto;
import model.OperarTipoPersona;
import model.OperarUsuarios;
import model.OperarVendedor;
import model.OperarVenta;
import model.OperarZona;
import model.OperarCliente;
import model.OperarDepartamento;
import view.IAuditoria;
import view.ICliente;
import view.IDepartamento;
import view.ILogin;
import view.IProducto;
import view.IReporteClientes;
import view.IReporteMejoresClientes;
import view.IReporteProductos;
import view.MDI;
import view.VAuditoria;
import view.VCliente;
import view.VDepartamento;
import view.VLogin;
import view.VProducto;
import view.VReporteClientes;
import view.VReporteMejoresClientes;
import view.VReporteProductos;
import view.IReporteVendedores;
import view.IReporteVentasporVendedor;
import view.IReporteVentasporZonas;
import view.ITipoPersona;
import view.IUsuarios;
import view.IVendedores;
import view.IVenta;
import view.IZona;
import view.VReporteVendedores;
import view.VReporteVentasporVendedor;
import view.VReporteVentasporZonas;
import view.VTipoPersona;
import view.VUsuarios;
import view.VVendedores;
import view.VVenta;
import view.VZona;

public class main {
	private MMDI m;
	private OperarMDI op;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// LOGIN
		ILogin vLogin = new VLogin();
		MLogin mLogin = new MLogin();
		MOperarLogin opLogin = new MOperarLogin();
		CLogin clogin = new CLogin(mLogin, vLogin, opLogin);
		BDConex conexion = new BDConex();
		vLogin.setController(clogin);

		vLogin.run();
		while (clogin.getCerrado() == false) {
			System.out.print("");
		}

		if (clogin.getCerrado() == true) {

			if (clogin.getCorrecto() == true) {

				IProducto vPro = new VProducto();
				MProductos mPro = new MProductos();
				OperarProducto oPro = new OperarProducto();
				CProducto cpro = new CProducto(mPro, vPro, oPro, clogin.getUsuario());
				vPro.setController(cpro);

				IReporteClientes vRClie = new VReporteClientes();
				CReporteClientes cRClie = new CReporteClientes(conexion, vRClie);
				vRClie.setControlador(cRClie);
				
				IReporteVendedores vRVen = new VReporteVendedores();
				CReporteVendedores cRVen = new CReporteVendedores(conexion, vRVen);
				vRVen.setControlador(cRVen);

				IZona vZona = new VZona();
				MZona mZona = new MZona();
				OperarZona oz = new OperarZona();
				CZona c = new CZona(mZona, vZona, oz);
				vZona.setController(c);

				IReporteProductos vRepoPro = new VReporteProductos();
				CReporteProductos controller = new CReporteProductos(conexion, vRepoPro);
				vRepoPro.setController(controller);

				IVendedores vVendedores = new VVendedores();
				MVendedores mVendedores = new MVendedores();
				MZonaCB m2Vendedores = new MZonaCB();
				OperarVendedor ov = new OperarVendedor();
				CVendedores cVendedores = new CVendedores(mVendedores, m2Vendedores, vVendedores, ov);
				vVendedores.setController(cVendedores);

				IReporteVentasporVendedor vVXV = new VReporteVentasporVendedor();
				CReporteVentasporVendedor controlador = new CReporteVentasporVendedor(conexion, vVXV);
				vVXV.setControlador(controlador);

				IReporteVentasporZonas vVXZ = new VReporteVentasporZonas();
				CReporteVentasporZonas cVXZ = new CReporteVentasporZonas(conexion, vVXZ);
				vVXZ.setControlador(cVXZ);
				
				IReporteMejoresClientes vRMClie = new VReporteMejoresClientes();
				CReporteMejoresClientes cRMClie = new CReporteMejoresClientes(conexion, vRMClie);
				vRMClie.setControlador(cRMClie);
				
				IAuditoria vAuditoria = new VAuditoria();
				CAuditoria cAuditoria = new CAuditoria(vAuditoria, conexion);
				vAuditoria.setControlador(cAuditoria);
				
				IVenta vVenta = new VVenta();
				OperarVenta opVenta = new OperarVenta();
				MVenta mVenta = new MVenta();
				MIva miVenta = new MIva();
				CVenta cvVenta = new CVenta(mVenta, vVenta, opVenta, miVenta);
				vVenta.setControlador(cvVenta);
				
				ICliente vCliente=new VCliente();
				MCliente mCliente2=new MCliente();
				OperarCliente mCliente=new OperarCliente();
				DatosCliente mCliente3=new DatosCliente();
				CCliente cCliente=new CCliente(mCliente2,mCliente,mCliente3,vCliente);
				vCliente.setControlador(cCliente);
				
				ITipoPersona vTipo = new VTipoPersona();
				MTipoPersona mTipot= new MTipoPersona();
				OperarTipoPersona mTipo= new OperarTipoPersona();
				CTipoPersona cTipo= new CTipoPersona(mTipot, mTipo, vTipo);
				vTipo.setControlador(cTipo);
				
				IDepartamento vDepa = new VDepartamento();
				MDepartamento mDepa= new MDepartamento();
				OperarDepartamento opDepa = new OperarDepartamento();
				CDepartamento cDepa = new CDepartamento(mDepa,vDepa,opDepa);
				vDepa.setcontroller(cDepa);
				
				IUsuarios vUsuarios = new VUsuarios();
				MUsuarios mUsuarios = new MUsuarios();
				OperarUsuarios opUsuarios = new OperarUsuarios();
				CUsuarios con = new CUsuarios(mUsuarios, vUsuarios, opUsuarios);
				vUsuarios.setController(con);

				MDI mdi = new MDI(clogin.getAdmin(), vPro, vRClie, vRVen, vZona, vRepoPro, vVendedores, vVXV, vVXZ, vRMClie, vVenta, vCliente, vTipo, vDepa, vAuditoria, vUsuarios);
				OperarMDI op = new OperarMDI();
				MMDI m,m2,m3,m4 = new MMDI();
				m = null;
				m2=null;
				m3=null;
				m4=null;
				m = op.mejorVendedor();
				m2 = op.totalVendido();
				m3 = op.productoMasVendido();
				m4 = op.numeroClientes();
				
				String a = "";
				String b="";
				String e="";
				String d="";
				
				if(m!=null) {
					a = "Mejor Vendedor: "+m.getnVendedor()+" ("+m.getnVentas()+" Ventas)";
				}
				else {
					a = "Mejor Vendedor: ---";
				}
				if(m2!=null) {
					double n;
					n = Double.parseDouble(m2.getTotalVendido());
					DecimalFormat df = new DecimalFormat("0.00##");
					b = "Monto Total Vendido: "+df.format(n)+"$";
				}
				else {
					b = "Monto Total Vendido: --- $";
				}
				if(m3!=null) {
					e = "Producto Mas Vendido: "+m3.getnProducto();
				}
				else {
					e = "Producto Mas Vendido: ---";
				}
				if(m4!=null) {
					d = "Clientes Totales: "+m4.getTotalClientes();
				}
				else {

					d = "Clientes Totales: ";
				}
			
				mdi.escribirDashboard(a,b,e,d);
				mdi.setVisible(true);

			}
		}
	}

}
