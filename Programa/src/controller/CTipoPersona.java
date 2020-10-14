package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MTipoPersona;
import model.OperarTipoPersona;
import view.ITipoPersona;
//
public class CTipoPersona  implements ActionListener{
private MTipoPersona modelot;
private OperarTipoPersona modelo;
private ITipoPersona vista;

public CTipoPersona(MTipoPersona modelot, OperarTipoPersona modelo, ITipoPersona vista) {
	
	this.modelot = modelot;
	this.modelo = modelo;
	this.vista = vista;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if (e.getActionCommand().equals(ITipoPersona.BUSCAR)) {
		MTipoPersona tp;
		tp = modelo.buscar(vista.getIdentificador());
		if (tp != null) {
			vista.escribir(String.valueOf(tp.getId()), tp.getIdentificador(), tp.getNombre(), String.valueOf(tp.isBorrado()));
		}

		
		
	} else if (e.getActionCommand().equals(ITipoPersona.BORRAR)) {
		if (String.valueOf(vista.getId()).length() > 0) {
				modelot.setId(vista.getId());
				modelot.setIdentificador(vista.getIdentificador());
				modelot.setNombre(vista.getNom());
				modelot.setBorrado(vista.getborr());
			if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar este tipo de persona?", "Eliminar", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			modelo.borrar(modelot);
			vista.volveralmenu();
			}
		} else
			JOptionPane.showMessageDialog(null, "Debe realizar un busqueda del producto a borrar");

		
									
		
	} else if (e.getActionCommand().equals(ITipoPersona.CREAR)) {
		
		if (vista.getValIdentificador()== true) {			
			if (vista.getValNombre()== true) {				
				modelot.setIdentificador(vista.getIdentificador());
				modelot.setNombre(vista.getNom());
				modelot.setBorrado(vista.getborr());
		
		if (JOptionPane.showConfirmDialog(null, "¿Desea Registar este tipo de persona?", "Crear", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
		modelo.crear(modelot);
		vista.volveralmenu();
		}
		
			}else JOptionPane.showMessageDialog(null, "EL NOMBRE DEBE TENER AL MENOS CINCO (5) CARACTERES ");
		} else JOptionPane.showMessageDialog(null, "EL IDENTIFICADOR NO PUEDE ESTAR VACIO");

		
									
		
	} else if (e.getActionCommand().equals(ITipoPersona.MODIFICAR)) {
		
		if (String.valueOf(vista.getId()).length() > 0) {
			
			if (vista.getValIdentificador()== true) {			
				if (vista.getValNombre()== true) {				
					modelot.setId(vista.getId());
					modelot.setIdentificador(vista.getIdentificador());
					modelot.setNombre(vista.getNom());
					modelot.setBorrado(vista.getborr());
			
			if (JOptionPane.showConfirmDialog(null, "¿Desea Modificar este tipo de persona?", "Modificar", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			modelo.modificar(modelot);
			vista.volveralmenu();
			}
				}else JOptionPane.showMessageDialog(null, "EL NOMBRE DEBE TENER AL MENOS CINCO (5) CARACTERES ");
			}else JOptionPane.showMessageDialog(null, "EL IDENTIFICADOR NO PUEDE ESTAR VACIO");
		
		} else
			JOptionPane.showMessageDialog(null, "Debe realizar un busqueda del producto a modificar");

	
										
	
	} else if (e.getActionCommand().equals(ITipoPersona.LIMPIAR)) {
		
		vista.escribir(null, null, null, null);
	}
	
									
	
	if ( e.getActionCommand().equals(vista.EXIT)) {
		 vista.salir();
	 }
}
}



