package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperarUsuarios {

	private MUsuarios usu = null;

	public MUsuarios buscarDepa(String cod) {
		ResultSet rs = null;
		BDConex bd = new BDConex();
		MUsuarios pro = new MUsuarios();

		rs = bd.consultar("SELECT * FROM departamentos WHERE codigo = '" + cod + "' and borrado=false;");

		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();
				pro.setIddepartamento(Integer.parseInt(rs.getString("id_departamento")));
				pro.setNombreDepartamento(rs.getString("departamento"));
				pro.setCodDepartamento(rs.getString("codigo"));

			} else {
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				pro = null;
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return pro;
	}

	public MUsuarios buscarUser(String usuario) {
		ResultSet rs = null, rs2 = null, rs3 = null;
		BDConex bd = new BDConex();
		MUsuarios u = new MUsuarios();

		rs = bd.consultar("SELECT * FROM usuarios WHERE nombre_usuario='" + usuario + "' and borrado=false;");
		try {
			if (rs.first()) {
				rs.beforeFirst();
				rs.next();
				u.setId(Integer.parseInt(rs.getString("id_usuario")));
				u.setNombre(rs.getString("nombre"));
				u.setAdministrador(Integer.parseInt(rs.getString("administrador")));
				rs2 = bd.consultar("SELECT * FROM departamentos WHERE id_departamento='"
						+ rs.getString("id_departamento") + "' and borrado=false;");
				try {
					if (rs2.first()) {
						rs2.beforeFirst();
						rs2.next();
						u.setNombreDepartamento(rs2.getString("departamento"));
						u.setCodDepartamento(rs2.getString("codigo"));

						rs3 = bd.consultar(
								"SELECT * FROM preguntas WHERE id_pregunta='" + rs.getString("id_pregunta") + "'");
						if (rs3.first()) {
							rs3.beforeFirst();
							rs3.next();
							u.setPregunta(rs3.getString("pregunta"));
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"El departamento asociado se encuentra borrado. Dirijase a MODIFICAR y asigne uno nuevo");
						u = null;
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				u = null;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.desconectar();
		return u;

	}

	public boolean crear(MUsuarios usu) {
		this.usu = usu;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false, existe;

		existe = bd.ValidaUsuario(usu.getNombreusuario(), "usuarios");

		if (existe == true) {
			JOptionPane.showMessageDialog(null, "Error. El usuario " + usu.getNombreusuario() + " ya existe", "ERROR",
					JOptionPane.ERROR_MESSAGE);

		} else if (usu.getIddepartamento() != 0) {
			op = bd.ejecutar(
					"INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `clave`, `administrador`, `id_pregunta`, `respuesta`, `nombre`, `id_departamento`, `borrado`) VALUES (NULL, '"
							+ usu.getNombreusuario() + "', '" + usu.getClave() + "', '" + usu.getAdministrador()
							+ "', '" + usu.getIdpregunta() + "', '" + usu.getRespuesta() + "', '" + usu.getNombre()
							+ "', '" + usu.getIddepartamento() + "', 0);");
			if (op > 0) {
				correcto = true;
				JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error. Debe consultar su departamento", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

		bd.desconectar();
		return correcto;
	}

	public boolean borrar(MUsuarios usu) {

		this.usu = usu;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

		op = bd.ejecutar("UPDATE usuarios SET borrado=1 WHERE nombre_usuario='" + usu.getUsuario() + "' AND borrado=0");
		if (op > 0) {
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
		}
		bd.desconectar();
		return correcto;

	}

}
