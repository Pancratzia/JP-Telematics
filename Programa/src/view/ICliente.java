package view;

import javax.swing.DefaultComboBoxModel;

import controller.CCliente;

public interface ICliente {
	final static String CREAR="crear";
	final static String COMBO="activar combobox";
	final static String COMBOITEM="activar item combobox";
	final static String COMBO2="activar combobox";
	final static String COMBOITEM2="activar item combobox";
	final static String COMBO3="activar combobox";
	final static String COMBOITEM3="activar item combobox";
	public static final String EXIT = "exit";
	
	
	final static String LIMPIAR="limpiar";
	final static String BUSCAR="buscar";
	final static String MODIFICAR="modificar";
	final static String BORRAR="borrar";
	
	public void setCombo(DefaultComboBoxModel<?> dcbm);
    public void setCombo2(DefaultComboBoxModel<?>dcbm2);
    public void setCombo3(DefaultComboBoxModel<?>dcbm3);

	public void run();
	public void regresaalmenu();
	
	public void desplegar();
	public void desplegar2();
	public void desplegar3();
	
	public String getRif();
	public String getNombre();
	public String getTelefono();
	public String getDireccion();
	public int getIdTipo();
	public int getIdEstado();
	public int getIdvendedor();
	public int getId();
	public boolean getBorrado();
	public int getBorradoVendedor();
	
	
	
	public void setControlador(CCliente c);
	public void setEscribir(String id,String rif,String nombre,String direccion,String telefono,String idvendedor,String idtipo,String idestado,String ntipo, String nestado, String nvendedor,String borrado);
	public void setCombo(int com,int com2,int com3);
	public void setIdTipo(String idtipos);
    public void setIdEstado(String idestaos);
    public void setIdVendedor(String idvendedor);
    public void setBorradoVendedor(String borrado2);
    
    public Object getComboItem();
	public Object getComboItem2();
	public Object getComboItem3();

  
	public void salir();
	
	public boolean getValRif();
	public boolean getValDirecc();
	public boolean getValTele();
	public boolean getValNomb();
	public boolean getValTp();
	public boolean getValEst();
	public boolean getValVen();
	
	public boolean getCerrado();
	
}
