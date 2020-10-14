package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.IZona;
import view.VZona;

public class OperarZona {

	private MZona m = null;
	private IZona v = null;
	private boolean existe;

	public OperarZona() {
		// TODO Auto-generated constructor stub
	}

	public boolean crear(MZona m, IZona v) {
		this.m = m;
		this.v = v;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

		existe = bd.ValidaCodigo(m.getCodigo(), "zonas");

		if (existe == true) {
			
			JOptionPane.showMessageDialog(null, "Error. El código " + m.getCodigo() + " ya existe", "ERROR",
					JOptionPane.ERROR_MESSAGE);

		} else {

			op = bd.ejecutar("INSERT INTO `zonas` (`id_zona`, `codigo`, `nombre_zona`, `borrado`) VALUES (NULL, '"
					+ m.getCodigo() + "', '" + m.getNombre() + "', '0');");

			ZonaEstado(m, v);

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

	public void ZonaEstado(MZona m, IZona v) {
		this.m = m;
		ResultSet ultimoID = null;
		BDConex bd = new BDConex();
		int op2 = 0;

		ultimoID = bd.consultar("SELECT MAX(id_zona) AS id_zona FROM zonas");
		
		try {
			if (ultimoID.first()) {
				
				ultimoID.beforeFirst();
				ultimoID.next();
				m.setId(Integer.parseInt(ultimoID.getString("id_zona")));

			} else {
				
				JOptionPane.showMessageDialog(null, "Error al consultar el ultimo registro");
				m = null;
				
			}

			if (v.getContador() == 1) {

				op2 = bd.ejecutar("INSERT INTO `zona_estados` (`id_zona`, `id_estado`, `id_zona_estado`) VALUES ('"
						+ m.getId() + "', '" + v.getEstado1() + "', NULL);");
				
			} else if (v.getContador() == 2) {
				
				op2 = bd.ejecutar("INSERT INTO `zona_estados` (`id_zona`, `id_estado`, `id_zona_estado`) VALUES ('"
						+ m.getId() + "', '" + v.getEstado1() + "', NULL), ('" + m.getId() + "', '" + v.getEstado2()
						+ "', NULL);");
				
			} else if (v.getContador() == 3) {
				
				op2 = bd.ejecutar("INSERT INTO `zona_estados` (`id_zona`, `id_estado`, `id_zona_estado`) VALUES ('"
						+ m.getId() + "', '" + v.getEstado1() + "', NULL), ('" + m.getId() + "', '" + v.getEstado2()
						+ "', NULL), ('" + m.getId() + "', '" + v.getEstado3() + "', NULL);");
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean modificar(MZona m) {
		this.m = m;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

			op = bd.ejecutar("UPDATE `zonas` SET `codigo` = '" + m.getCodigo() + "', `nombre_zona` = '" + m.getNombre()
					+ "' WHERE `zonas`.`id_zona` = " + m.getId() + " AND borrado=0;");

			if (op > 0) {
				
				correcto = true;
				JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
			
			} else {
				
				JOptionPane.showMessageDialog(null, "Error al almacenar el registro.");
			
			}
		
		
		bd.desconectar();
		return correcto;

	}

	public boolean borrar(MZona m) {
		this.m = m;
		int op = 0;
		BDConex bd = new BDConex();
		boolean correcto = false;

		op = bd.ejecutar("UPDATE `zonas` SET `borrado` = '1' WHERE `zonas`.`id_zona` = " + m.getId() + ";");

		if (op > 0) {
			
			correcto = true;
			JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente.");
		
		} else {
			
			JOptionPane.showMessageDialog(null, "Error al borrar el registro.");
		
		}
		
		bd.desconectar();
		return correcto;

	}

	public MZona buscar(String Codigo) {
		
		int cant;
		ArrayList<String> estados = new ArrayList<>();
		ResultSet rs = null, rs2 = null, rs3 = null;
		DefaultTableModel dtm = null;
		BDConex bd = new BDConex();
		
		MZona m = new MZona();

		rs = bd.consultar("SELECT * FROM zonas WHERE codigo='" + Codigo + "'and borrado = false;");

		try {
			if (rs.first()) {
				
				rs.beforeFirst();
				rs.next();
				m.setId(Integer.parseInt(rs.getString("id_zona")));
				m.setCodigo(rs.getString("codigo"));
				m.setNombre(rs.getString("nombre_zona"));
				m.setBorrado(Boolean.parseBoolean(rs.getString("borrado")));

				rs2 = bd.consultar("SELECT count(id_estado) FROM zona_estados WHERE id_zona=" + m.getId() + "");

				try {
					
					if (rs2.next()) {

						m.setCantEstado(rs2.getInt("count(id_estado)"));
						cant = m.getCantEstado();

						rs3 = bd.consultar("SELECT id_estado FROM `zona_estados` WHERE id_zona = " + m.getId());

						try {

							while (rs3.next()) {
								String row = rs3.getString(1);
								estados.add(row);

							}

							if (cant == 1) {

								m.setEstado1(Integer.parseInt(estados.get(0)));
								m.setEstado2(0);
								m.setEstado3(0);

							} else if (cant == 2) {

								m.setEstado1(Integer.parseInt(estados.get(0)));
								m.setEstado2(Integer.parseInt(estados.get(1)));
								m.setEstado3(0);

							} else if (cant == 3) {

								m.setEstado1(Integer.parseInt(estados.get(0)));
								m.setEstado2(Integer.parseInt(estados.get(1)));
								m.setEstado3(Integer.parseInt(estados.get(2)));

							}

						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}else {
						
						JOptionPane.showMessageDialog(null, "No existen estados en la zona introducida.");
						return m = null;
					}

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				
				JOptionPane.showMessageDialog(null, "El codigo no existe en la Base de Datos.");
				return m = null;
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bd.desconectar();
		return m;
		
	}

}
