package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class ObtenerPreguntas {

	
	public ArrayList consultarListapreguntas() {
		  
		  ArrayList preguntas=new ArrayList<>();
		  int op = 0;
		  BDConex bd = new BDConex();
		  boolean correcto = false;
		  PreparedStatement statement=null;
		  ResultSet result=null;
		  Connection connection;
		  
		  MPreguntas iv;
		  connection = bd.getConexion();
		 
		  
		  String consulta="SELECT * FROM preguntas";
		  
		  try {
		   if (connection!=null) {
		    result=bd.consultar(consulta);
		    
		    while(result.next()==true){
		     iv=new MPreguntas();
		     iv.setId(Integer.parseInt(result.getString("id_pregunta")));
		     iv.setPregunta(result.getString("pregunta"));
		          
		     preguntas.add(iv);
		    }  
		   }
		  } catch (SQLException e) {
		   System.out.println(e);
		  }finally{
		   try {
		    connection.close();
		    bd.desconectar();
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  return preguntas;
		 }

	
}
