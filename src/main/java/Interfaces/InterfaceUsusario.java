package Interfaces;

import java.util.List;

import Modelos.TblUsuariocl2;

public interface InterfaceUsusario {

	public void RegistrarUsuario(TblUsuariocl2 usuario);	
	public List<TblUsuariocl2> ListadoUsuario();
	public TblUsuariocl2 validarUsuario(String vLogin, String vClave);
}
