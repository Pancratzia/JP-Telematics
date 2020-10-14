package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.BDConex;
import view.IAuditoria;


public class CAuditoria implements ActionListener {
	
	private IAuditoria vista;
	private BDConex modelo;
	
	public CAuditoria (IAuditoria vista, BDConex modelo) {
		
		this.modelo = modelo;
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(IAuditoria.Buscar)) {
			modelo = new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta()));
			vista.desplegar();
			modelo.desconectar();
		}
		if (e.getActionCommand().equals(IAuditoria.BuscarC)) {
			modelo = new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta1()));
			vista.desplegar();
			modelo.desconectar();
		}
		if (e.getActionCommand().equals(IAuditoria.LIMPIAR)) {
			vista.limpiar();
		}
		if (e.getActionCommand().equals(IAuditoria.SALIR)) {
			vista.salir();
		}

	}
}

