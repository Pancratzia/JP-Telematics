package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperarVendedor {
	
	private MVendedores vend = null;
	
	public boolean crearVendedor(MVendedores ven) {
		this.vend = ven;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false, existe;

		existe = bd.ValidaCi(ven.getCi());

		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Error. La cedula " + ven.getCi() + " ya existe", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		} else {
			op = bd.ejecutar(
					"INSERT INTO `vendedores` (`id_vendedor`, `cedula_vendedor`, `nombre_vendedor`, `telefono`, `id_zona`, `borrado`) VALUES (NULL, '"
							+ ven.getCi() + "', '" + ven.getNombre() + "', '" + ven.getTelefono() + "', '"
							+ ven.getIdzona() + "', '0');");

			if (op > 0) {
				correcto = true;
				JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Error al almacenar registro");
			}

		}
		bd.desconectar();
		return correcto;
	}
	
	public boolean modificar(MVendedores ven){
		this.vend = ven;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE `vendedores` SET `cedula_vendedor` = '" + ven.getCi() + "', `nombre_vendedor` = '" + ven.getNombre() + "', `telefono` = '" + ven.getTelefono() + "', `id_zona` = '" + ven.getIdzona()  + "' WHERE `vendedores`.`id_vendedor` = " + ven.getId() + ";");
		
		if(op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");	
		}else {
			JOptionPane.showMessageDialog(null, "Error al almacenar registro.");
		}
		bd.desconectar();
		return correcto;
	}
	public boolean borrar(MVendedores ven){
		this.vend = ven;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE vendedores SET borrado=1 WHERE id_vendedor=" + ven.getId() + " AND borrado=0");
		
		if(op>0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		}else {
			JOptionPane.showMessageDialog(null, "Error al borrar registro.");
		}
		bd.desconectar();
		return correcto;
	}
	public MVendedores buscar(String ci){
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MVendedores ven = new MVendedores();
		
		rs = bd.consultar("SELECT vendedores.id_vendedor ,vendedores.nombre_vendedor , vendedores.telefono ,vendedores.id_zona ,zonas.nombre_zona, vendedores.borrado FROM vendedores, zonas WHERE vendedores.cedula_vendedor="+ci+" and vendedores.id_zona=zonas.id_zona and vendedores.borrado=false");
		try {
			//JOptionPane.showMessageDialog(null, "Entro");
			if(rs.first()) {
			rs.beforeFirst();
			rs.next();
			ven.setId(Integer.parseInt(rs.getString("id_vendedor")));
			ven.setNombre(rs.getString("nombre_vendedor"));
			ven.setTelefono(rs.getString("telefono"));
			ven.setIdzona(Integer.parseInt(rs.getString("id_zona")));
			ven.setZona(rs.getString("nombre_zona"));
			ven.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));
			
			}else{
				JOptionPane.showMessageDialog(null, "La cedula no existe en la Base de Datos");
				ven = null;
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		bd.desconectar();
		return ven;
	}

}
