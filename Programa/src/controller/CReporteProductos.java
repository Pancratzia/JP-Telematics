package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BDConex;
import view.IReporteProductos;

public class CReporteProductos implements ActionListener {
	private BDConex model;
	private IReporteProductos view;
	
	public CReporteProductos(BDConex model, IReporteProductos view){
		this.model=model;
		this.view=view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals(IReporteProductos.IMPRIMIR)) {
			model=new BDConex();
			view.setConsulta(model.consultar(view.getConsulta()));
			model.desconectar();
	}
	}}
