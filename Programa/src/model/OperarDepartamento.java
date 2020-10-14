package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class OperarDepartamento {

	private MDepartamento depato = null;
	
	//CREAR PRODUCTO
	public boolean crearDepartamento(MDepartamento dpto) {
		this.depato = dpto;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false, existe;

		existe = bd.ValidaCodigo(dpto.getCodigo(), "departamentos");

		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Error. El código "+dpto.getCodigo()+" ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {
			op = bd.ejecutar("INSERT INTO departamentos (departamento, codigo , borrado) VALUES ('"
					+ dpto.getNombre() + "','" + dpto.getCodigo() + "','0');");
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
	
	public boolean modificar(MDepartamento dpto)
	{
		this.depato = dpto;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE departamentos SET codigo='" + dpto.getCodigo() + "',departamento='" + dpto.getNombre() + "' WHERE id_departamento=" + dpto.getId() +" AND borrado=0" );
		
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}
		bd.desconectar();
		return correcto;
		
	}
	
	public boolean borrar(MDepartamento dpto)
	{
		
		this.depato = dpto;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		op = bd.ejecutar("UPDATE departamentos SET borrado=1 WHERE id_departamento=" + dpto.getId() + " AND borrado=0");
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
		}
		bd.desconectar();
		return correcto;
		
	}
	
	
	public MDepartamento buscar(String cod)
	{
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MDepartamento dpto = new MDepartamento();
		
		rs = bd.consultar("SELECT * FROM departamentos WHERE codigo='" + cod + "' and borrado=false;");
		try{
			if(rs.first())
			{rs.beforeFirst();
			 rs.next();
			 dpto.setId(Integer.parseInt(rs.getString("id_departamento")));
			 dpto.setCodigo(rs.getString("codigo"));
			 dpto.setNombre((rs.getString("departamento")));
			 dpto.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));
			 
			}else{
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				dpto = null;
			}
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return dpto;
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
}
