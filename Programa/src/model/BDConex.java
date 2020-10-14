package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BDConex {

	private static Connection con;
	private static Statement stm;
	private static ResultSet rs;
	private static PreparedStatement pstm;
	private static PreparedStatement ps; 
	final String driver = "com.mysql.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/jp_bd";
	final String usuario = "root";
	final String clave = "";

	public BDConex() {
		con = null;
		try {
			// SE hace la conexion ODBC
			Class.forName(driver).newInstance();

			// Se abre una conexion de nombre con
			con = DriverManager.getConnection(url, usuario, clave);

			if (con != null)
				System.out.println("Conexion exitosa a la BD!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectar con el Driver");
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Se obtiene la conexion de la Base de Datos
	public Connection getConexion() {
		return con;
	}

	// Abre una conexion a la Base de Datos
	public void abrirConexion() {
		try {
			con = DriverManager.getConnection(url, usuario, clave);
			if (con != null)
				System.out.println("Conexion exitosa a la BD!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Se desconecta de la Base de Datos
	public void desconectar() {
		con = null;
		if (con == null)
			System.out.println("BD Desconectada");
	}

	// Ejecuta sentencias SQL Update e Insert
	public int ejecutar(String sentencia) {
		int a = 0;
		try {
			stm = con.createStatement();
			a = stm.executeUpdate(sentencia);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return a;
	}

	// Ejecuta la sentencia SQL Select
	public ResultSet consultar(String sentencia) {
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sentencia);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public boolean ValidaCodigo(String cod, String tabla) {

		boolean r;
		try {
			pstm = getConexion()
					.prepareStatement("SELECT codigo FROM `"+tabla+"` WHERE codigo='" + cod + "' AND borrado=0");
			rs = pstm.executeQuery();
			if (rs.next()) {
				r = true;

			} else
				r = false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			r = false;
		}
		return r;

	}

	public boolean ValidaRespuesta(String resp) {

		boolean r;
		try {
			pstm = getConexion().prepareStatement("SELECT respuesta FROM `usuarios` WHERE respuesta='" + resp + "'");
			rs = pstm.executeQuery();
			if (rs.next()) {
				r = true;

			} else
				r = false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			r = false;
		}
		return r;

	}
	public boolean ValidaCi(String ci) {

		boolean r;
		try {
			ps = getConexion().prepareStatement("SELECT cedula_vendedor FROM `vendedores` WHERE cedula_vendedor='" + ci + "' AND borrado=0");
			rs = ps.executeQuery();
			if (rs.next()) {
				r= true;

			} else
				r= false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			r = false;
		}
		return r;

	}
	
	public boolean ValidaUsuario(String usuario, String tabla) {

		boolean r;
		try {
			pstm = getConexion().prepareStatement("SELECT id_usuario FROM `"+tabla+"` WHERE nombre_usuario='" + usuario + "' AND borrado=0");
			rs = pstm.executeQuery();
			if (rs.next()) {
				r = true;

			} else
				r = false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			r = false;
		}
		return r;

	}

}