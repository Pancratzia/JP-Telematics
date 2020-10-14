package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MProductos;
import model.OperarProducto;
import view.IProducto;

public class CProducto implements ActionListener {

	MProductos m;
	IProducto v;
	OperarProducto op;
	int usuario;

	public CProducto(MProductos m, IProducto v, OperarProducto op, int usuario) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.v = v;
		this.op = op;
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int id = 0;
		double precio = 0.0;
		String nombre = "", code = "";

		if (e.getActionCommand().equals(v.ACEPTAR)) {

			if (v.getOperacion() == 0) {
				// CREAR
				code = v.getCodigo();
				if (v.getValidez() == true) {
					nombre = v.getNombre();
					if (v.getValidez() == true) {
						precio = v.getPrecio();
						if (v.getValidez() == true) {
							m.setNombre(nombre);
							m.setCodigo(code);
							m.setPrecio(precio);
							String mensaje = "¿Realmente desea crear el producto " + code + "-" + nombre + "-" + precio
									+ "$?";
							if (v.Preguntar(mensaje) == 1) {
								op.crearProducto(m);
								op.guardarOperacion(m, usuario, "CREADO");
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}

						}
					}
				}
			}

			if (v.getOperacion() == 1) {
				// MODIFICAR

				code = v.getCodigo();
				if (v.getValidez() == true) {
					nombre = v.getNombre();
					if (v.getValidez() == true) {
						precio = v.getPrecio();
						if (v.getValidez() == true) {
							m.setNombre(nombre);
							m.setCodigo(code);
							m.setPrecio(precio);
							String mensaje = "¿Realmente desea modificar el producto " + code + "-" + nombre + "-"
									+ precio + "$?";
							if (v.Preguntar(mensaje) == 1) {
								op.modificar(m);
								op.guardarOperacion(m, usuario, "MODIFICADO");
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}
						}
					}
				}
			}

			if (v.getOperacion() == 2) {
				// BORRAR
				code = v.getCodigo();
				if (v.getValidez() == true) {
					nombre = v.getNombre();
					if (v.getValidez() == true) {
						precio = v.getPrecio();
						if (v.getValidez() == true) {
							m.setNombre(nombre);
							m.setCodigo(code);
							m.setPrecio(precio);
							String mensaje = "¿Realmente desea eliminar el producto " + code + "-" + nombre + "-"
									+ precio + "$?";
							if (v.Preguntar(mensaje) == 1) {
								op.borrar(m);
								op.guardarOperacion(m, usuario, "BORRADO");
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}
						}
					}
				}
			}

		}

		if (e.getActionCommand().equals(v.BUSCAR)) { // Para CONSULTAR en la lupita
			m = null;
			m = op.buscar(v.getCodigo());
			if (m != null) {
				v.escribir(m.getCodigo(), m.getNombre(), String.valueOf(m.getPrecio()));
				id = m.getId();
				m.setId(id);
			}

		}

		if (e.getActionCommand().equals(v.EXIT)) {
			v.salir();
		}
		if (e.getActionCommand().equals(v.LIMPIAR)) {
			v.limpiar();
		}

	}

}
