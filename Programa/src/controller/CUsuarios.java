package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MUsuarios;
import model.OperarUsuarios;
import view.IUsuarios;

public class CUsuarios implements ActionListener {

	MUsuarios m;
	IUsuarios v;
	OperarUsuarios op;

	public CUsuarios(MUsuarios m, IUsuarios v, OperarUsuarios op) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.v = v;
		this.op = op;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int administrador = 0, pregunta = 0;
		String usuario = "", clave = "", nombre = "", respuesta = "", departamento = "";
		String cod = "";

		if (e.getActionCommand().equals(v.BUSCAR)) {
			m = null;

			cod = v.getCod();

			m = op.buscarDepa(cod);

			if (m != null) {
				v.escribir1(m.getNombreDepartamento());
				m.setIddepartamento(m.getIddepartamento());
			}
			else {
				v.limpiar();
			}
		}

		if (e.getActionCommand().equals(v.ACEPTAR)) {

			if (v.getOperacion() == 0) {
				// CREAR
				usuario = v.getUsuario();
				if (v.getValidez() == true) {
					nombre = v.getNombre();
					if (v.getValidez() == true) {
						clave = v.getClave();
						if (v.getValidez() == true) {

							administrador = v.getAdmin();
							respuesta = v.getRespuesta();
							pregunta = v.getIdPregunta();

							m.setNombre(nombre);
							m.setClave(clave);
							m.setNombreusuario(usuario);
							m.setAdministrador(administrador);
							m.setIdpregunta(pregunta);
							m.setRespuesta(respuesta);

							String mensaje = "¿Realmente desea crear el Usuario " + usuario + " ?";
							if (v.Preguntar(mensaje) == 1) {
								if (op.crear(m) == true) {
									v.limpiar();
									v.VolverAlMenu();
								} else {
									v.limpiar();
								}
							}

						}
					}

				}
			}

			if (v.getOperacion() == 1) {// MODIFICAR

				
			}

			if (v.getOperacion() == 2) {

				usuario = v.getUsuario();
				if (v.getValidez()) {

					m.setUsuario(v.getUsuario());

					if (v.Preguntar("¿Realmente desea borrar al usuario " + v.getUsuario() + "?") == 1) {
						op.borrar(m);
						v.limpiar();
						v.VolverAlMenu();
					}
					else {
						v.limpiar();
					}
				}

			}
		}

		if (e.getActionCommand().equals(v.EXIT)) {
			v.salir();
		}

		if (e.getActionCommand().equals(v.LIMPIAR)) {
			v.limpiar();
		}

		if (e.getActionCommand().equals(v.BUSCAR1)) {

			usuario = v.getUsuario();

			m = null;
			if (v.getValidez()) {
				m = op.buscarUser(usuario);
				if (m != null) {
					v.escribir(m.getNombre(), m.getPregunta(), m.getNombreDepartamento(), m.getCodDepartamento(),
							m.getAdministrador());
					m.setId(m.getId());
				} else {
					v.limpiar();
				}
			}

		}

	}

}
