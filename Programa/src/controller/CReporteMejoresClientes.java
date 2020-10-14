package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BDConex;
import view.IReporteMejoresClientes;

public class CReporteMejoresClientes implements ActionListener{
	private BDConex modelo;
	private IReporteMejoresClientes vista;
	
	public CReporteMejoresClientes(BDConex modelo, IReporteMejoresClientes vista){
		this.modelo = modelo;
		this.vista = vista;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(IReporteMejoresClientes.IMPRIMIR)) {
			modelo=new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta()));
			modelo.desconectar();
	}}
}

