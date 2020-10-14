package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MZona;
import model.OperarZona;
import view.IZona;

public class CZona implements ActionListener {

	MZona m;
	IZona v;
	OperarZona oz;

	public CZona(MZona m, IZona v, OperarZona oz) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.v = v;
		this.oz = oz;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = "", cod = "";
		int estd1, estd2, estd3;

		if (e.getActionCommand().equals(v.ACEPTAR)) {// CREAR

			if (v.getOperacion() == 0) {

				cod = v.getCodigo();
				
				if (v.getValidez() == true) {
				
					nom = v.getNombre();
					
					if (v.getValidez() == true) {
						
						estd1 = v.getEstado1();
						estd2 = v.getEstado2();
						estd3 = v.getEstado3();
						
						if (v.getContador() > 0) {
						
							m.setNombre(nom);
							m.setCodigo(cod);
							m.setEstado1(estd1);
							m.setEstado2(estd2);
							m.setEstado3(estd3);
							String mensaje = "¿Realmente desea crear la zona como " + nom + " - " + cod
									+ ", con los estados seleccionados anteriormente ?";
							
							if (v.Preguntar(mensaje) == 1) {
								
								oz.crear(m, v);
								v.limpiar();
								v.VolverAlMenu();
							
							}
						} else if (v.getContador() < 1) {
							
							JOptionPane.showMessageDialog(null, "LA ZONA DEBE CONTENER AL MENOS UN (1) ESTADO.",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						
						}
					}
				}
			}

			if (v.getOperacion() == 1) {// MODIFICAR
				
				cod = v.getCodigo();
				
				if (v.getValidez() == true) {
					
					nom = v.getNombre();
					
					if (v.getValidez() == true) {
						
						m.setNombre(nom);
						m.setCodigo(cod);
						String mensaje = "¿Realmente desea modificar la zona como " + nom + " - " + cod + "?";
						
						if (v.Preguntar(mensaje) == 1) {
							
							oz.modificar(m);
							v.limpiar();
							v.VolverAlMenu();
							
						}
					} else
						
						JOptionPane.showMessageDialog(null, "Debe realizar una busqueda de la zona a modificar");
				
				}
			}

			if (v.getOperacion() == 2) { // BORRAR
				
				cod = v.getCodigo();
				
				if (v.getValidez() == true) {
					
					nom = v.getNombre();
					
					if (v.getValidez() == true) {
						
						estd1 = v.getEstado1();
						estd2 = v.getEstado2();
						estd3 = v.getEstado3();
						m.setNombre(nom);
						m.setCodigo(cod);
						m.setEstado1(estd1);
						m.setEstado1(estd2);
						String mensaje = "¿Realmente desea eliminar " + nom + " - " + cod + "?";
						
						if (v.Preguntar(mensaje) == 1) {
							
							oz.borrar(m);
							v.limpiar();
							v.VolverAlMenu();
						
						}
					}
				} else
					
					JOptionPane.showMessageDialog(null, "Debe realizar un busqueda de la zona a borrar");
			
			}
		}

		if (e.getActionCommand().equals(v.BUSCAR)) { // LUPA

			m = null;
			
			cod = v.getCodigo();
			
			if (v.getValidez() == true) {

				m = oz.buscar(cod);
				
				if (m != null) {
					v.escribir(m.getCodigo(), m.getNombre(), m.getEstado1(), m.getEstado2(), m.getEstado3());
					v.MostrarEstados();
				}else {
					v.limpiar();
				}
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
