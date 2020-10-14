package controller;
//
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import model.DatosCliente;
import model.MCliente;
import model.OperarCliente;
import view.ICliente;


public class CCliente implements ActionListener{
    private  MCliente modelo2;
	private OperarCliente modelo;
	private DatosCliente modelo3;
    private ICliente vista;
	
	public CCliente(MCliente modelo2,OperarCliente modelo,DatosCliente modelo3,ICliente vista) {
        
		this.modelo2=modelo2;	
		this.modelo=modelo;
	    this.modelo3=modelo3;
		this.vista=vista;
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
							//COMBOBOXTIPO//
		
		 if(e.getActionCommand().equals(vista.COMBO)) {
				DefaultComboBoxModel<?>df=new DefaultComboBoxModel(modelo2.vectorTipo());
				vista.setCombo(df);			
			}
		 else if(e.getActionCommand().equals(vista.COMBOITEM)) {
				modelo2= (MCliente) vista.getComboItem(); 
				vista.setIdTipo(modelo2.getId());
				}
		 					///COMBOBOXESTADO//
		 
		  if(e.getActionCommand().equals(vista.COMBO2)) {
				DefaultComboBoxModel<?>df2=new DefaultComboBoxModel(modelo2.vectorEstado());
				vista.setCombo2(df2);			
			}
		  
		  else if(e.getActionCommand().equals(vista.COMBOITEM2)) {
				modelo2= (MCliente) vista.getComboItem2(); 
				vista.setIdEstado(modelo2.getId());
				}
		  
		  						//COMBOBOXVENDEDOR//  
		  
		  if(e.getActionCommand().equals(vista.COMBO3)) {
				DefaultComboBoxModel<?>df2=new DefaultComboBoxModel(modelo2.vectorVendedor());
				vista.setCombo3(df2);				
		  }
		  else if(e.getActionCommand().equals(vista.COMBOITEM3)) {
				modelo2= (MCliente) vista.getComboItem3(); 
				vista.setIdVendedor(modelo2.getId());
				} 
		  
		  
		  else  if (e.getActionCommand().equals(ICliente.CREAR)) {
			 	  
			  if (vista.getValRif()== true) {
				 if  (vista.getValNomb()==true) {
					 if (vista.getValDirecc()== true) {
						if (vista.getValTele()== true) {			    
							if (vista.getValTp()==true) {
								if (vista.getValEst()== true) {
									if (vista.getValVen()== true) {
							 modelo3.setTelefono(vista.getTelefono());
							 modelo3.setRif(vista.getRif());
							 modelo3.setDireccion(vista.getDireccion());
							 modelo3.setNombrec(vista.getNombre());
							 modelo3.setIdVendedor(vista.getIdvendedor());
						     modelo3.setIdTipo(vista.getIdTipo());
						     modelo3.setIdEstado(vista.getIdEstado());
							 modelo3.setBorrado(vista.getBorrado());
							
							if (JOptionPane.showConfirmDialog(null, "¿Desea Registar este cliente?", "Crear Cliente", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							modelo.crear(modelo3);
							vista.regresaalmenu();
							}
							
										} else JOptionPane.showMessageDialog(null, "DEBE SELLECIONAR UN VENDEDOR");
									} else JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ESTADO");
								} else JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN TIPO DE PERSONA");
							}  else JOptionPane.showMessageDialog(null, "EL TELEFONO DEBE TENER ONCE (11) DIGITOS"); 
					 	}  else JOptionPane.showMessageDialog(null, "LA DIRECCION DEBE TENER AL MENOS DOCE (12) DIGITOS"); 
					 }else JOptionPane.showMessageDialog(null, "EL NOMBRE DEBE TENER AL MENOS SIETE (7) DIGITOS"); 
				  } else JOptionPane.showMessageDialog(null, "EL R.I.F DEBE TENER NUEVE (9) DIGITOS");	  
			}
		  
		  else if (e.getActionCommand().equals(ICliente.MODIFICAR)) {			
			 if (String.valueOf(vista.getId()).length() > 0) {
							
				 if (vista.getValRif()== true) {
					 if  (vista.getValNomb()==true) { 
						 if (vista.getValDirecc()== true) {		 
							 if (vista.getValTele()== true) {	
								 if (vista.getValTp()==true) {
										if (vista.getValEst()== true) {
											if (vista.getValVen()== true) {
								 
							modelo3.setIdc(vista.getId());
							modelo3.setNombrec(vista.getNombre());
							modelo3.setRif(vista.getRif());
							modelo3.setDireccion(vista.getDireccion());
							modelo3.setTelefono(vista.getTelefono());	
							modelo3.setIdVendedor(vista.getIdvendedor());
							modelo3.setIdTipo(vista.getIdTipo());
							modelo3.setIdEstado(vista.getIdEstado());
							modelo3.setBorrado(vista.getBorrado());
					
					if (JOptionPane.showConfirmDialog(null, "¿Desea Registar este cliente?", "Crear Cliente", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					modelo.modificar(modelo3);
					vista.regresaalmenu();
					}
											} else JOptionPane.showMessageDialog(null, "DEBE SELLECIONAR UN VENDEDOR");
										} else JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ESTADO");
									} else JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN TIPO DE PERSONA");
								 }  else JOptionPane.showMessageDialog(null, "EL TELEFONO DEBE TENER ONCE (11) DIGITOS"); 
							  } else JOptionPane.showMessageDialog(null, "LA DIRECCION DEBE TENER AL MENOS DOCE (12) DIGITOS");
							}else JOptionPane.showMessageDialog(null, "EL NOMBRE DEBE TENER AL MENOS SIETE (7) DIGITOS"); 
						} else JOptionPane.showMessageDialog(null, "EL R.I.F DEBE TENER NUEVE (9) DIGITOS");
				} 
			  else
					JOptionPane.showMessageDialog(null, "Debe realizar un busqueda del producto a modificar");
					 }

		  							//BORRAR//
		  
		  else	if (e.getActionCommand().equals(ICliente.BORRAR)) {
				 try {
			
						 if (String.valueOf(vista.getId()).length() > 0) {
					modelo3.setIdc(vista.getId());
					modelo3.setRif(vista.getRif());
					modelo3.setNombrec(vista.getNombre());
					modelo3.setDireccion(vista.getDireccion());
				    modelo3.setTelefono(vista.getTelefono());
				    modelo3.setIdVendedor(vista.getIdvendedor());
				    modelo3.setIdTipo(vista.getIdTipo());
				    modelo3.setIdEstado(vista.getIdEstado());
					modelo3.setBorrado(vista.getBorrado());
					
					if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar este cliente?", "Eliminar", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION) {
					modelo.borrar(modelo3);
					vista.regresaalmenu();
						 }
						 } } catch (Exception e2) {
						// TODO: handle exception
					}
			}
		  
										//BUSCAR//
		  else	if (e.getActionCommand().equals(ICliente.BUSCAR)) {
				 DatosCliente t; 
					 
						t= modelo.buscar(vista.getRif());
						if (t != null) {
							
						
							vista.setBorradoVendedor(String.valueOf(t.getBorradoVendedor()));
							int condicion=vista.getBorradoVendedor();
						
							if(condicion==1) {
								JOptionPane.showMessageDialog(null, "El vendedor seleccionado esta inactivo");
								vista.setEscribir(String.valueOf(t.getIdc()),t.getRif(),t.getNombrec(),t.getDireccion(),t.getTelefono(),String.valueOf(t.getIdVendedor()),String.valueOf(t.getIdTipo()),String.valueOf(t.getIdEstado()),t.getnTipo(),t.getnEstado(),"Por favor seleccione otro vendedor distinto de "+t.getnVendedor(),String.valueOf(t.isBorrado()));
							    vista.setCombo(t.getIdEstado(), t.getIdTipo(), 0);  
							}
							
							else {				
							vista.setEscribir(String.valueOf(t.getIdc()),t.getRif(),t.getNombrec(),t.getDireccion(),t.getTelefono(),String.valueOf(t.getIdVendedor()),String.valueOf(t.getIdTipo()),String.valueOf(t.getIdEstado()),t.getnTipo(),t.getnEstado(),t.getnVendedor(),String.valueOf(t.isBorrado()));
						    vista.setCombo(t.getIdEstado(), t.getIdTipo(), t.getIdVendedor());  
							} 
							}
		         }	
										//LIMPIAR//			
		  else  if (e.getActionCommand().equals(ICliente.LIMPIAR)) {
		
		vista.setEscribir(null, null, null, null, null, null, null, null, null,null,null,null);
	    vista.setCombo(0,0,0);  

	}
           								//SALIR//	

		  else	if ( e.getActionCommand().equals(vista.EXIT)) {
		 vista.salir();
	 }
}
}