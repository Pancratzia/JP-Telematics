package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BDConex;
import model.MLogin;
import model.MOperarLogin;
import view.ILogin;
import view.VLogin;

public class CLogin implements ActionListener {
	private int contador = 0;
	private boolean correcto = false, cerrado = false, admin = false;
	private String user, pass, newPass;
	private int id;
	MLogin m;
	ILogin v;
	MOperarLogin op;

	public CLogin(MLogin m, ILogin v, MOperarLogin op) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.v = v;
		this.op = op;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String respuesta = "", newP = "";

		if (e.getActionCommand().equals(v.INGRESAR)) {
			m = null;
			user = v.getUsuario();
			if (v.getValidez() == true) {
				pass = v.getContraseña();
				if (v.getValidez() == true) {
					m = op.IngresarUsuario(user, pass);
					if (m == null) {
						contador++;
					}
					if (contador == 3 && m == null) {
						v.MensajeError(
								"HA INGRESADO DATOS ERRONEOS MAS DE 3 VECES. SE CERRARA EL PROGRAMA POR SEGURIDAD");
						correcto = false;
						System.exit(0);
					}
					if (m != null) {
						correcto = true;
						JOptionPane.showMessageDialog(null, "BIENVENIDO A JP_TELEMATICS " + m.getNombre() + "!");
						admin = m.getAdmin();
						id = m.getIdUsuario();
						v.cerrar();
						cerrado = true;
					}
				}
			}

		}

		if (e.getActionCommand().equals(v.BUSCAR)) {
			m = null;
			user = v.getUsuario();
			if (v.getValidez() == true) {
				m = op.buscarUsuarioYPregunta(user);
				if (m != null) {
					v.habilitar();
					v.setPregunta(m.getPregunta());
				}

			}

		}

		if (e.getActionCommand().equals(v.ACEPTAR)) {

			if (String.valueOf(v.getRespuesta()).length() > 0) {
				m = op.buscarRespuesta(v.getRespuesta());

				if (m != null) {

					newP = v.getNewPass();
					if (v.getValidez() == true) {

						m.setNewCon(newP);
						respuesta = v.getRespuesta();
						m.setRespuesta(respuesta);
						op.modificar(m);

						v.LimpiarUP();
						v.volver();

					} else
						v.LimpiarR();

				} else
					v.LimpiarR();

			} else
				JOptionPane.showMessageDialog(null, "No dejar campos vacios");

		}

	}

	public boolean getCorrecto() {
		// TODO Auto-generated method stub
		return correcto;
	}
	public boolean getCerrado() {
		// TODO Auto-generated method stub
		return cerrado;
	}
	public boolean getAdmin() {
		// TODO Auto-generated method stub
		return admin;
	}
	public int getUsuario() {
		// TODO Auto-generated method stub
		return id;
	}

}
