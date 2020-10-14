package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MOperarLogin {

	private MLogin login = null;

	public MLogin IngresarUsuario(String usuario, String clave) {

		this.login = login;
		ResultSet rs = null;

		MLogin login = new MLogin();
		BDConex bd = new BDConex();

		rs = bd.consultar("SELECT * FROM usuarios WHERE nombre_usuario='" + usuario + "' and clave='" + clave
				+ "' and borrado=0");

		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();
				login.setIdUsuario(rs.getInt("id_usuario"));
				login.setNombre(rs.getString("nombre"));
				login.setAdmin(rs.getBoolean("administrador"));

			} else {
				JOptionPane.showMessageDialog(null, "El Usuario o contraseña no existe en la Base de Datos.");
				login = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return login;

	}

	public MLogin buscarUsuarioYPregunta(String usuario) {

		ResultSet rs = null, rs2 = null;
		BDConex bd = new BDConex();
		MLogin login = new MLogin();

		rs = bd.consultar("SELECT id_pregunta FROM usuarios WHERE nombre_usuario='" + usuario + "' and borrado=0;");
		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();

				login.setId_pregunta(rs.getString("id_pregunta"));
				rs2 = bd.consultar("SELECT pregunta from preguntas where " + login.getId_pregunta() + "=id_pregunta");
				try {
					if (rs2.first()) {
						rs2.beforeFirst();
						rs2.next();
						login.setPregunta(rs2.getString("pregunta"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "El Usuario no existe en la base de datos");
				login = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return login;

	}

	public MLogin buscarRespuesta(String respuesta) {

		ResultSet rs = null;
		BDConex bd = new BDConex();
		MLogin login = new MLogin();

		rs = bd.consultar("SELECT respuesta FROM usuarios WHERE respuesta='" + respuesta + "' and borrado=0;");

		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();

			} else {
				JOptionPane.showMessageDialog(null, "La respuesta ingresada no existe en la Base de Datos.");
				login = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bd.desconectar();
		return login;

	}

	public boolean modificar(MLogin login) {

		this.login = login;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

		op = bd.ejecutar("UPDATE usuarios SET clave='" + login.getNewCon() + "' WHERE respuesta= '"
				+ login.getRespuesta() + "'");

		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "Cambio de clave exitoso");
		} else {

			JOptionPane.showMessageDialog(null, "ups.Algo fallo");
		}
		bd.desconectar();
		return correcto;

	}

}
