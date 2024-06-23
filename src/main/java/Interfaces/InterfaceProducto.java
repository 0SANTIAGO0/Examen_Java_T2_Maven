package Interfaces;

import java.util.List;

import Modelos.TblProductocl2;

public interface InterfaceProducto {
	
	public void RegistrarProducto(TblProductocl2 producto);		
	public List<TblProductocl2> ListadoProducto();

}
