package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MCliente {
	

	private String id,nombre;
   

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre; 
	}

	
				
								//VECTOR TIPO PERSONA//	
	
	public Vector <MCliente> vectorTipo(){
		Vector <MCliente> vm=new Vector<MCliente>();
		BDConex bd= new BDConex();
		ResultSet rs=null;
		MCliente tip=null;
		rs=bd.consultar("SELECT * FROM `tipo_personas` WHERE 1 " );
		tip= new MCliente();
		tip.setId(" ");
		tip.setNombre("Seleccione un tipo");
		vm.add(tip);
		try {
			if(rs.first()) {
				rs.beforeFirst();
				while(rs.next()) {
					tip=new MCliente();
					tip.setId(rs.getString("id_tipo_persona"));
					tip.setNombre(rs.getString("t_nombre"));
					vm.add(tip);
					
				}
				bd.desconectar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vm;
	}
								// VECTOR ESTADO//
	
	public Vector <MCliente> vectorEstado(){
		Vector <MCliente> vm=new Vector<MCliente>();
		BDConex bd= new BDConex();
		ResultSet rs=null;
		MCliente tip=null;
		rs=bd.consultar("SELECT * FROM `estados` WHERE 1" );
		tip= new MCliente();
		tip.setId(" ");
		tip.setNombre("Seleccione un estado");
		vm.add(tip);
		try {
			if(rs.first()) {
				rs.beforeFirst();
				while(rs.next()) {
					tip=new MCliente();
					tip.setId(rs.getString("id_estado"));
					tip.setNombre(rs.getString("nombre_estado"));
					vm.add(tip);
					
				}
				bd.desconectar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vm;
	}
	

						//VECTOR VENDEDOR//
	
	public Vector <MCliente> vectorVendedor(){
		Vector <MCliente> vm=new Vector<MCliente>();
		BDConex bd= new BDConex();
		ResultSet rs=null;
		MCliente tip=null;
		rs=bd.consultar("SELECT * FROM `vendedores` WHERE 1" );
		tip= new MCliente();
		tip.setId(" ");
		tip.setNombre("Seleccione un vendedor");
		vm.add(tip);
		try {
			if(rs.first()) {
				rs.beforeFirst();
				while(rs.next()) {
					tip=new MCliente();
					tip.setId(rs.getString("id_vendedor"));
					tip.setNombre(rs.getString("nombre_vendedor"));
					vm.add(tip);
					
				}
				bd.desconectar();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vm;
	}
	
}
