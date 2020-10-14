package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperarMDI {
	public MMDI mejorVendedor() {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MMDI mdi = new MMDI();
		rs = bd.consultar("SELECT vendedores.nombre_vendedor, COUNT(vendedores.nombre_vendedor) contador FROM vendedores \r\n" + 
				"INNER JOIN clientes ON clientes.id_vendedor = vendedores.id_vendedor \r\n" + 
				"INNER JOIN ventas ON ventas.id_cliente = clientes.id_cliente \r\n" + 
				"WHERE vendedores.borrado=false\r\n" + 
				"GROUP BY vendedores.nombre_vendedor \r\n" + 
				"ORDER BY contador desc limit 1");
			
		try {
			if (rs.first()) {

				rs.beforeFirst();
				rs.next();
				mdi.setnVendedor(rs.getString("nombre_vendedor"));
				mdi.setnVentas(Integer.parseInt(rs.getString("contador")));
				
			} else {
				mdi = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		
		
		return mdi;
	}
	
	public MMDI totalVendido() {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MMDI mdi = new MMDI();
		
		rs = bd.consultar("SELECT SUM(total) sumatoria \r\n" + 
				"FROM ventas");
		
		try {
			if (rs.first()) {

				rs.beforeFirst();
				rs.next();
				mdi.setTotalVendido(rs.getString("sumatoria"));
				
			} else {
				mdi = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		
		
		
		return mdi;
	}
	public MMDI productoMasVendido() {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MMDI mdi = new MMDI();
		rs=bd.consultar("SELECT productos.nombre_producto, COUNT(productos.nombre_producto) contador FROM productos \r\n" + 
				"INNER JOIN ventas ON ventas.id_producto = productos.id_producto \r\n" + 
				"GROUP BY productos.nombre_producto \r\n" + 
				"ORDER BY contador desc limit 1");
		
		try {
			if (rs.first()) {

				rs.beforeFirst();
				rs.next();
				mdi.setnProducto(rs.getString("nombre_producto"));
				mdi.setnVentasProducto(Integer.parseInt(rs.getString("contador")));
				
			} else {
				mdi = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
	
		
		
		return mdi;
}
	
	
	public MMDI numeroClientes() {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MMDI mdi = new MMDI();
		rs = bd.consultar("SELECT COUNT(clientes.id_cliente) cantidadclientes \r\n" + 
				"FROM clientes WHERE borrado = false");
		
		try {
			if (rs.first()) {

				rs.beforeFirst();
				rs.next();
				mdi.setTotalClientes(Integer.parseInt(rs.getString("cantidadclientes")));
				
			} else {
				mdi = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
	
		
		
		return mdi;
	}
}
