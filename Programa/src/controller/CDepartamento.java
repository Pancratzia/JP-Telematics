package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.MDepartamento;
import model.OperarDepartamento;
import view.IDepartamento;

public class CDepartamento implements ActionListener
{
	MDepartamento m;
	IDepartamento v;
	OperarDepartamento op;
	 
	public CDepartamento (MDepartamento m, IDepartamento v, OperarDepartamento op)
	{
		this.m=m;
		this.v=v;
		this.op=op;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	
	{
		String nombre = "", code = "" ;

		if (e.getActionCommand().equals(v.ACEPTAR)) 
		{

			if (v.getOperacion() == 0) 
			{
				// CREAR
				code = v.getCodigo();
				if (v.getValidez()== true)
				{
				nombre = v.getNombre();
				if (v.getValidez() == true)
						{
							m.setNombre(nombre);
							m.setCodigo(code);
							String mensaje = "¿Realmente desea crear el departamento " + code + "-" + nombre;
							if(v.Preguntar(mensaje)==1)
							{
								op.crearDepartamento(m);
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}
						}
				}
			}
			
			if (v.getOperacion() == 1) 
			{
				// MODIFICAR

				code = v.getCodigo();
				if (v.getValidez() == true) 
					nombre = v.getNombre();
				{
					
						if (v.getValidez() == true) 
						{
							m.setNombre(nombre);
							m.setCodigo(code);
							String mensaje = "¿Realmente desea modificar el departamento " + code + "-" + nombre + "-";
							if(v.Preguntar(mensaje)==1)
							{
								op.modificar(m);
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}
							
						}
				}
				
			
			}
			
			if (v.getOperacion() == 2) {
				// BORRAR
				code = v.getCodigo();
				if (v.getValidez() == true) {
					nombre = v.getNombre();
						if (v.getValidez() == true) {
							m.setNombre(nombre);
							m.setCodigo(code);
							String mensaje = "¿Realmente desea eliminar el producto " + code + "-" + nombre ;
							if(v.Preguntar(mensaje)==1)
							{
								op.borrar(m);
								v.limpiar();
								v.VolverAlMenu();
								m.setId(0);
							}
						}
					
				}
			}
			
			
		}
		if (e.getActionCommand().equals(IDepartamento.BUSCAR))
		{ // Para CONSULTAR en la lupita
			m = op.buscar(v.getCodigo());
			if (m != null) 
			{
				v.escribir(m.getCodigo(), m.getNombre());
				m.setId(m.getId());
			}

		}
		if (e.getActionCommand().equals(IDepartamento.EXIT))
		{
			v.salir();
		}
		if (e.getActionCommand().equals(IDepartamento.LIMPIAR))
		{
			v.limpiar();
		}
			
		}
		
	
}

