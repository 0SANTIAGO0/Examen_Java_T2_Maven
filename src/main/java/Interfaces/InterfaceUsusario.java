package Interfaces;

import java.util.List;

import Modelos.TblUsuariocl3;

public interface InterfaceUsusario {

	public void RegistrarUsuario(TblUsuariocl3 usuario);	
	public List<TblUsuariocl3> ListadoUsuario();
	public TblUsuariocl3 validarUsuario(String vLogin, String vClave);
}
