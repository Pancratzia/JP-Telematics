package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import view.VVenta;

public class OperarVenta {
	private MVenta vent = null;

	public boolean crearVenta(MVenta ven, int cant, String total, int idiva, String subtotal, String ivacalc,
			int idcliente) {
		this.vent = ven;

		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

		op = bd.ejecutar(
				"INSERT INTO `ventas`(`id_venta`, `id_cliente`, `id_producto`, `cantidad`, `total`, `id_iva`, `subtotal`, `iva_calculado`, `hora_y_fecha`) VALUES ("
						+ null + "," + idcliente + "," + ven.getIdProducto() + "," + cant + ",'" + total + "'," + idiva
						+ ",'" + subtotal + "','" + ivacalc + "',NOW())");
		if (op > 0) {
			correcto = true;

		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}

		bd.desconectar();
		return correcto;
	}

	public MVenta buscarCliente(String rif) {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MVenta ven = new MVenta();

		rs = bd.consultar(
				"SELECT clientes.id_cliente, nombre, clientes.rif, direccion, clientes.telefono telefonocliente, vendedores.nombre_vendedor, vendedores.cedula_vendedor, vendedores.telefono telefonovendedor, zonas.nombre_zona, tipo_personas.t_nombre, estados.nombre_estado, clientes.borrado borrado, vendedores.borrado borradov FROM clientes INNER JOIN vendedores ON clientes.id_vendedor = vendedores.id_vendedor INNER JOIN tipo_personas ON clientes.id_tipo_persona = tipo_personas.id_tipo_persona INNER JOIN estados ON clientes.id_estado = estados.id_estado INNER JOIN zonas ON vendedores.id_zona = zonas.id_zona WHERE clientes.rif = "
						+ rif + " AND clientes.borrado =0");

		try {
			if (rs.first()) {

				if(Integer.parseInt(rs.getString("borradov")) == 1) {
					JOptionPane.showMessageDialog(null,
							"El vendedor de este cliente ya no trabaja en la empresa. Dirijase al MODULO DE CLIENTES para asignar un nuevo vendedor");
				}
				else {
					rs.beforeFirst();
					rs.next();
					ven.setIdCliente(Integer.parseInt(rs.getString("id_cliente")));
					ven.setNombreCliente(rs.getString("nombre"));
					ven.setRifCliente((rs.getString("rif")));
					ven.setDireccionCliente((rs.getString("direccion")));
					ven.setTelefonoCliente((rs.getString("telefonocliente")));
					ven.setNombreVendedor(rs.getString("nombre_vendedor"));
					ven.setCedulaVendedor(rs.getString("cedula_vendedor"));
					ven.setTelefonoVendedor(rs.getString("telefonovendedor"));
					ven.setZonaVendedor(rs.getString("nombre_zona"));
					ven.setTipoCliente(rs.getString("t_nombre"));
					ven.setEstadoCliente(rs.getString("nombre_estado"));
					ven.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));	
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"El codigo del cliente no existe. Intente de nuevo.");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return ven;

	}

	public MVenta buscarVendedor(String nombre) {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MVenta ven = new MVenta();

		rs = bd.consultar(
				"SELECT vendedores.id_vendedor,vendedores.cedula_vendedor,vendedores.telefono,zonas.nombre_zona FROM vendedores INNER JOIN zonas ON vendedores.id_zona=zonas.id_zona WHERE vendedores.nombre_vendedor='"
						+ nombre + "' and vendedores.borrado=0;");
		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();
				ven.setIdVendedor(Integer.parseInt(rs.getString("id_vendedor")));
				ven.setCedulaVendedor(rs.getString("cedula_vendedor"));
				ven.setTelefonoVendedor(rs.getString("telefono"));
				ven.setZonaVendedor(rs.getString("nombre_zona"));

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "no funciona");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "no funciona");
			e.printStackTrace();
		}
		bd.desconectar();

		return ven;
	}

	public MVenta buscarProducto(String codigo) {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MVenta ven = new MVenta();

		rs = bd.consultar("SELECT * FROM productos WHERE codigo='" + codigo + "' and borrado=false;");
		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();
				ven.setIdProducto(Integer.parseInt(rs.getString("id_producto")));
				ven.setNombreProducto(rs.getString("nombre_producto"));
				ven.setPrecioProducto(Double.parseDouble(rs.getString("costo")));

			} else {
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				ven = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return ven;

	}

}
