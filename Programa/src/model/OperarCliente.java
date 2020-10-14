package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperarCliente {
  private DatosCliente clie=null;
	public OperarCliente() {
	
	}

					//BUSCAR CLIENTE //
	
	public DatosCliente buscar(String rif) { 
		ResultSet rs = null;
		BDConex bd = new BDConex();
		DatosCliente t = new DatosCliente();
		rs = bd.consultar("SELECT clientes.id_cliente ,clientes.nombre ,clientes.rif ,clientes.direccion ,clientes.telefono ,clientes.id_vendedor ,clientes.id_tipo_persona ,clientes.id_estado ,clientes.borrado ,estados.nombre_estado ,tipo_personas.t_nombre,tipo_personas.borrado,tipo_personas.identificador ,vendedores.nombre_vendedor,vendedores.borrado FROM clientes, estados , tipo_personas, vendedores WHERE clientes.id_vendedor= vendedores.id_vendedor AND clientes.id_estado=estados.id_estado AND clientes.id_tipo_persona=tipo_personas.id_tipo_persona AND rif='" + rif + "' and clientes.borrado=false;");
		try {
			if (rs.first()) {// recorre el resultset al siguiente registro si es
								// que existen
				rs.beforeFirst();// regresa el puntero al primer registro
				rs.next();
				t.setIdc(Integer.parseInt(rs.getString("id_cliente")));
                t.setNombrec(rs.getString("nombre"));
				t.setRif(rs.getString("rif"));
				t.setDireccion(rs.getString("direccion"));
				t.setTelefono(rs.getString("telefono"));
				t.setIdVendedor(Integer.parseInt(rs.getString("id_vendedor")));
				t.setIdTipo(Integer.parseInt(rs.getString("id_tipo_persona")));
				t.setIdEstado(Integer.parseInt(rs.getString("id_estado")));
			    t.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));
			    t.setnEstado(rs.getString("nombre_estado"));
			    t.setnTipo(rs.getString("t_nombre"));
                t.setnVendedor(rs.getString("nombre_vendedor"));
                t.setBorradoVendedor(Integer.parseInt(rs.getString("vendedores.borrado")));
                
			    
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
		return t;
	}
								//BORRADO//
	
	public boolean borrar(DatosCliente clie) {
		this.clie = clie;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		op = bd.ejecutar("UPDATE clientes SET borrado= true WHERE id_cliente=" + clie.getIdc());
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
		}
		bd.desconectar();
		return correcto;
	}
	
								//CREAR CLIENTE//

	public boolean crear(DatosCliente clie) {
		this.clie = clie;
		int op = 0;
		ResultSet rs;
		BDConex bd = new BDConex();
		boolean correcto = false;
		
		rs = bd.consultar("SELECT * FROM clientes WHERE rif='" + clie.getRif() + "'and borrado=false;");
		System.out.println("Ya está creado");
		try {
			if(rs.first()) {
				JOptionPane.showMessageDialog(null, "Ya existe este cliente.");
			} else {
		
		op = bd.ejecutar("INSERT INTO clientes (nombre, rif, direccion, telefono, id_vendedor, id_tipo_persona, id_estado, borrado)  VALUES ('" + clie.getNombrec()
				+ "','" + clie.getRif() + "','" + clie.getDireccion()+"','" +clie.getTelefono()+"',"+clie.getIdVendedor()+","+clie.getIdTipo() +"," +clie.getIdEstado()+ ",false);");
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}
		}
		
	}catch (HeadlessException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
		bd.desconectar();
		return correcto;
	}

	
										//MODIFICAR//
	
	public boolean modificar(DatosCliente clie) {
		this.clie = clie;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;
		op = bd.ejecutar("UPDATE clientes SET rif='" + clie.getRif() + "',nombre='" + clie.getNombrec()+"',direccion='"+clie.getDireccion()+"',telefono='"+clie.getTelefono() + "',id_vendedor="
				+ clie.getIdVendedor() + ",id_tipo_persona=" + clie.getIdTipo()+",id_estado="+clie.getIdEstado() + " WHERE id_cliente=" + clie.getIdc());
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
		}
		bd.desconectar();
		return correcto;
	}
	
	
	
	
	
}
