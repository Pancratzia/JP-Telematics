package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class OperarProducto {

	private MProductos produ = null;
	
	//CREAR PRODUCTO
	public boolean crearProducto(MProductos pro) {
		this.produ = pro;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false, existe;

		existe = bd.ValidaCodigo(pro.getCodigo(), "productos");

		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Error. El código "+pro.getCodigo()+" ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {
			op = bd.ejecutar("INSERT INTO productos (codigo, nombre_producto, costo, borrado) " + "VALUES ('"
					+ pro.getCodigo() + "','" + pro.getNombre() + "','" + pro.getPrecio() + "','0');");
			if (op > 0) {
				correcto = true;
				JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
			}
		}

		bd.desconectar();
		return correcto;
	}
	
	public boolean modificar(MProductos pro)
	{
		this.produ = pro;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE productos SET codigo='" + pro.getCodigo() + "',nombre_producto='" + pro.getNombre() + "',costo=" + pro.getPrecio() + " WHERE id_producto=" + pro.getId() +" AND borrado=0" );
		
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}
		bd.desconectar();
		return correcto;
		
	}
	
	public boolean borrar(MProductos pro)
	{
		
		this.produ = pro;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE productos SET borrado=1 WHERE id_producto=" + pro.getId() + " AND borrado=0");
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
		}
		bd.desconectar();
		return correcto;
		
	}
	
	
	public MProductos buscar(String cod)
	{
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MProductos pro = new MProductos();
		
		rs = bd.consultar("SELECT * FROM productos WHERE codigo='" + cod + "' and borrado=false;");
		try{
			if(rs.first())
			{rs.beforeFirst();
			 rs.next();
			 pro.setId(Integer.parseInt(rs.getString("id_producto")));
			 pro.setCodigo(rs.getString("codigo"));
			 pro.setNombre((rs.getString("nombre_producto")));
			 pro.setPrecio(Double.parseDouble(rs.getString("costo")));
			 pro.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));
			 
			}else{
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				pro = null;
			}
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return pro;
		
		
		
	}
	
	public boolean guardarOperacion(MProductos pro, int idUser, String operacion) {
		this.produ = pro;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false, existe;
		ResultSet rs = null;

		rs = bd.consultar("SELECT * FROM productos WHERE codigo='" + pro.getCodigo() + "';");
		try{
			if(rs.first())
			{rs.beforeFirst();
			 rs.next();
			 
			 op = bd.ejecutar("INSERT INTO auditorias ( id_producto, id_usuario, Operacion, hora_y_fecha) " + "VALUES ('"
						+ Integer.parseInt(rs.getString("id_producto")) + "','" + idUser + "','" + operacion+"',NOW());");
			 
			}else{
				pro = null;
			}
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		bd.desconectar();
		return correcto;
	}
	
	
	
	
	
	
	
	
	
	
}
