package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BDConex;
import view.IReporteVentasporZonas;

public class CReporteVentasporZonas implements ActionListener{
	private BDConex modelo;
	private IReporteVentasporZonas vista;
	
	public CReporteVentasporZonas(BDConex modelo, IReporteVentasporZonas vista){
		this.modelo = modelo;
		this.vista = vista;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(IReporteVentasporZonas.IMPRIMIR)) {
			modelo=new BDConex();
			vista.setConsulta(modelo.consultar(vista.getConsulta()));
			modelo.desconectar();
}}}
