package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class OperarTipoPersona {
	private MTipoPersona tp= null;
 
public OperarTipoPersona () {
	}
 	
public boolean crear (MTipoPersona tp) {
 		this.tp = tp;
		int op = 0;
		ResultSet rs;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		rs = bd.consultar("SELECT * FROM tipo_personas WHERE identificador='" + tp.getIdentificador() + "'and borrado=false;");
		System.out.println("Ya está creado");
		
		try {
			if(rs.first()) {
				JOptionPane.showMessageDialog(null, "Ya existe este Tipo de persona.");
			} else {
			
		op = bd.ejecutar("INSERT INTO tipo_personas (t_nombre, identificador, borrado) VALUES ('" + tp.getNombre()
				+ "','" +  tp.getIdentificador() + "',false);");
 		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}
 		}
	
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();}
		bd.desconectar();
		return correcto;
 		
 	}
 
public boolean modificar(MTipoPersona tp) {
	this.tp = tp;
	int op = 0;
	BDConex bd = new BDConex();
	boolean correcto = false;
	op = bd.ejecutar("UPDATE tipo_personas SET identificador='" + tp.getIdentificador() + "',t_nombre='" + tp.getNombre() 
			  + "' WHERE id_tipo_persona=" + tp.getId());
	if (op > 0) {
		correcto = true;
		JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
	} else {
		JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
	}
	bd.desconectar();
	return correcto;
}


public boolean borrar(MTipoPersona tp) {
	this.tp = tp;
	int op = 0;
	BDConex bd = new BDConex();
	boolean correcto = false;
	op = bd.ejecutar("UPDATE tipo_personas SET borrado= true WHERE id_tipo_persona=" + tp.getId());
	if (op > 0) {
		correcto = true;
		JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
	} else {
		JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
	}
	bd.desconectar();
	return correcto;
}

public MTipoPersona buscar(String cod) {
	ResultSet rs = null;
	BDConex bd = new BDConex();
	MTipoPersona p = new MTipoPersona();

	rs = bd.consultar("SELECT * FROM tipo_personas WHERE identificador='" + cod + "' and borrado=false;");
	try {
		if (rs.first()) {// recorre el resultset al siguiente registro si es
							// que existen
			rs.beforeFirst();// regresa el puntero al primer registro
			rs.next();
			p.setId(Integer.parseInt(rs.getString("id_tipo_persona")));
			p.setIdentificador(rs.getString("identificador"));
			p.setNombre(rs.getString("t_nombre"));
			p.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));
		} else {
			JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
		}

	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	bd.desconectar();
	return p;
}
}