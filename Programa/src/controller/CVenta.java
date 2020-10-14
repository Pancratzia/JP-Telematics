package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.MIva;
import model.MVenta;
import model.OperarVenta;
import view.IVenta;

public class CVenta implements ActionListener {

	MVenta m;
	IVenta v;
	OperarVenta op;
	MIva mi;
	int idcli;
	String nombreCliente="";
	String nombreVendedor="";
	DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
	DecimalFormat formatea = new DecimalFormat("####.####",simbolos);
	
	public CVenta(MVenta m, IVenta v,OperarVenta op, MIva mi) {
		this.m=m;
		this.v=v;
		this.op=op;
		this.mi=mi;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(v.LUPA)) {
			
			String rif = v.getRifCliente();
			if(v.getValidez()) {
			m = null;
			m = op.buscarCliente(rif);
			idcli=m.getIdCliente();
			nombreCliente=m.getNombreCliente();
			nombreVendedor=m.getNombreVendedor();
			String nom = m.getNombreVendedor();
				if(m != null) {
					
			v.escribirCliente(m.getNombreCliente(), m.getDireccionCliente(), m.getTipoCliente(), m.getTelefonoCliente(), m.getEstadoCliente());
			v.escribirVendedor(m.getCedulaVendedor(), m.getNombreVendedor(),m.getTelefonoVendedor(), m.getZonaVendedor());
			
				}
			}
		}
		else if(e.getActionCommand().equals(v.LUPA1)) {
			String code = v.getCodigoProducto();
			
			m = op.buscarProducto(code);
			if(m!=null) {
			v.escribirProducto(m.getNombreProducto(), m.getPrecioProducto());
			}
		}
		else if(e.getActionCommand().equals(v.LIMPIAR)) {
			v.limpiar();

		}
		else if(e.getActionCommand().equals(v.EXIT)) {
			v.salir();
			
		}
		else if(e.getActionCommand().equals(v.SALIR)) {
			v.salir();

			}
		
		else if(e.getActionCommand().equals(v.PROCESAR)) {
			String a="";
			String b="";
			String c="";
			a = v.getVerificacion();
			b = v.getVerificacion2();
			c = v.getVerificacion3();
			
			if(a.equals("") || b.equals("")||c.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Campos obligatorios vacios, intente de nuevo",
						" Error", JOptionPane.INFORMATION_MESSAGE);
		}
			else {
				double subtotal,porcIva,iva,total=0;
				int cant=v.getCantidadVenta();
				int id=0;
				int idc=0;
				double precio=m.getPrecioProducto();
				subtotal=m.calcSubtotal(cant,precio);
				porcIva=m.definirIva(v.getIDCombo());
				iva=subtotal*porcIva;
				total=subtotal+iva;
				id = Integer.parseInt(v.getIDCombo());
				idc = m.getIdCliente();
		
			boolean result = false;		
			result = op.crearVenta(m, cant, formatea.format(total), id, formatea.format(subtotal), formatea.format(iva),idcli);
				if(result)
				JOptionPane.showMessageDialog(null,
						"\t\n  ¡Venta realizada con exito! \n\nVendedor: "+nombreVendedor+"\n\nCliente: "+nombreCliente+"\n\nProducto: "+m.getNombreProducto()+"\n\nCantidad: "+cant+
						 "\n\nMonto cancelado: "+total,
						" Comprobante de venta", JOptionPane.INFORMATION_MESSAGE);
				v.limpiar();
			}
			
			
			
		}	
		else if(e.getActionCommand().equals(v.COMBO)) {
			
			double subtotal,porcIva,iva,total=0;
			int cant=v.getCantidadVenta();
			double precio=m.getPrecioProducto();
			subtotal=m.calcSubtotal(cant,precio);
			porcIva=m.definirIva(v.getIDCombo());
			iva=subtotal*porcIva;
			total=subtotal+iva;
			String a="";
			String b="";
			a = v.getVerificacion();
			b = v.getVerificacion2();
			if(a.equals("")&&b.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Campos obligatorios vacios, intente de nuevo",
						" Error", JOptionPane.INFORMATION_MESSAGE);}
			else {
				v.escribirVenta(formatea.format(subtotal),formatea.format(iva),formatea.format(total));}
			}
		
	}
	


	
}
