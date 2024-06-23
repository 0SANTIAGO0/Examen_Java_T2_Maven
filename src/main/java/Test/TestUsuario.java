package Test;

import Dao.ClassUsuario;
import Modelos.TblUsuariocl2;

public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TblUsuariocl2 usuario = new TblUsuariocl2();
		ClassUsuario crud = new ClassUsuario();
		
		usuario = crud.validarUsuario("EDDY", "1234");
		
		if (usuario != null) {
            System.out.print("Si existe el usuario");
        } else {
            
        	System.out.print("No existe el usuario");
        }
	}

}
