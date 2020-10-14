package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BDConex;
import view.IReporteVendedores;

public class CReporteVendedores implements ActionListener{
	private BDConex modelo;
	private IReporteVendedores vista;
	
	public CReporteVendedores(BDConex modelo, IReporteVendedores vista){
		this.modelo = modelo;
		this.vista = vista;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(IReporteVendedores.IMPRIMIR)) {
			modelo=new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta()));
			modelo.desconectar();
	}}
}

