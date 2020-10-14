package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import model.MVendedores;
import model.MZona;
import model.MZonaCB;
import model.OperarVendedor;
import view.IVendedores;

public class CVendedores implements ActionListener {
	MVendedores m;
	MZonaCB m2;
	IVendedores v;
	OperarVendedor ov;
	int id = 0;
	String ci;

	public CVendedores(MVendedores m, MZonaCB m2, IVendedores v, OperarVendedor ov) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.m2 = m2;
		this.v = v;
		this.ov = ov;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nombre = "", ci = "", telefono = "";
		boolean bandera = true;
		int id = 0;

		if (e.getActionCommand().equals(v.ACEPTAR)) {

			if (v.getOperacion() == 0) {
				nombre = v.getNombre();
				if (v.getValidez() == true) {
					ci = v.getCi();
					if (v.getValidez() == true) {
						telefono = v.getTelefono();
						if (v.getValidez() == true) {
							m.setCi(ci);
							m.setNombre(nombre);
							m.setTelefono(telefono);
							v.ValCombo();
							v.getIdZona();
							m.setIdzona(v.getIdZona());
							if (v.getIdZona() == 0) {
								m.setCi(ci);
								m.setNombre(nombre);
								m.setTelefono(telefono);
							} else {
								String mensaje = "¿Realmente desea registrar el vendedor " + ci + " / " + nombre + " / "
										+ telefono + "?";
								if (v.Preguntar(mensaje) == 1) {
									ov.crearVendedor(m);
									v.limpiar();
									v.VolverAlMenu();
									id = 0;
								}
							}

						}
					}
				}
			}
			if (v.getOperacion() == 1) {
				nombre = v.getNombre();
				if (v.getValidez() == true) {
					ci = v.getCi();
					if (v.getValidez() == true) {
						telefono = v.getTelefono();
						if (v.getValidez() == true) {
							m.setCi(ci);
							m.setNombre(nombre);
							m.setTelefono(telefono);
							v.ValCombo();
							v.getIdZona();
							m.setIdzona(v.getIdZona());
							if (v.getIdZona() == 0) {
								m.setNombre(nombre);
								m.setTelefono(telefono);
							} else {
								String mensaje = "¿Realmente desea modificar el vendedor " + ci + "/" + nombre + "/"
										+ telefono + " ?";
								if (v.Preguntar(mensaje) == 1) {
									ov.modificar(m);
									v.limpiar();
									v.VolverAlMenu();
									id = 0;
								}
							}
						} else
							JOptionPane.showMessageDialog(null,
									"Debe realizar una consulta del cliente antes de modificar");
					}
				}
			}
			if (v.getOperacion() == 2) {
				nombre = v.getNombre();
				if (v.getValidez() == true) {
					ci = v.getCi();
					if (v.getValidez() == true) {
						telefono = v.getTelefono();
						if (v.getValidez() == true) {
							m.setCi(ci);
							m.setNombre(nombre);
							m.setTelefono(telefono);
							String mensaje = "¿Realmente desea eliminar el vendedor " + ci + "/" + nombre + "/"
									+ telefono + "$?";
							if (v.Preguntar(mensaje) == 1) {
								ov.borrar(m);
								v.limpiar();
								v.VolverAlMenu();
								id = 0;
							}

						}
					} else
						JOptionPane.showMessageDialog(null,
								"Debe realizar una consulta del cliente antes de modificar");
				}
			}
		}
		if (e.getActionCommand().equals(v.BUSCAR)) {

			m = null;
			ci = v.getCi();
			if (v.getValidez() == true) {
				m = ov.buscar(v.getCi());
				id = 0;
				ci = "";
			}

			if (m != null) {
				v.escribir(m.getNombre(), m.getTelefono(), m.getZona());
				id = m.getId();
			}

		}
		if (e.getActionCommand().equals(v.COMBO)) {
			DefaultComboBoxModel<?> df = new DefaultComboBoxModel(m2.mostrarZonas());
			v.setCombo(df);
		}
		if (e.getActionCommand().equals(v.COMBOI)) {
			m2 = (MZonaCB) v.getComboItem();
			v.setIdZona("" + m2.getId());
		}
		if (e.getActionCommand().equals(v.EXIT)) {
			v.salir();
		}
		if (e.getActionCommand().equals(v.LIMPIAR)) {
			v.limpiar();
		}

	}
}
