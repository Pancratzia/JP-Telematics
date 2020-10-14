package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BDConex;
import view.IReporteClientes;

public class CReporteClientes implements ActionListener{
	private BDConex modelo;
	private IReporteClientes vista;
	
	public CReporteClientes(BDConex modelo, IReporteClientes vista){
		this.modelo = modelo;
		this.vista = vista;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(IReporteClientes.IMPRIMIR)) {
			modelo=new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta()));
			modelo.desconectar();
	}}
}

