package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
 
public class MZonaCB {
	private int id;
	private String nombre;
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
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
 
	public Vector <MZonaCB> mostrarZonas() {
		
		BDConex bd = new BDConex();
		ResultSet rs = null;
		
		Vector <MZonaCB>vmz = new Vector<MZonaCB>();
		MZonaCB m = null;
		rs = bd.consultar("SELECT * FROM zonas WHERE 1 and borrado = false");
		
		m = new MZonaCB();
		
		m.setId(0);
		m.setNombre("Seleccione una Zona");
		
		vmz.add(m);
		
		try {
			if(rs.first()) {
				rs.beforeFirst();
				while (rs.next()) {
					m = new MZonaCB();
					
					m.setId(rs.getInt("id_zona"));
					m.setNombre(rs.getString("nombre_zona"));
					vmz.add(m);
				}
				bd.desconectar();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vmz;
	}
}