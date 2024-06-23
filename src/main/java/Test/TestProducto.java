package Test;

import java.util.List;

import Dao.ClassProducto;
import Modelos.TblProductocl2;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TblProductocl2 prod = new TblProductocl2();
		ClassProducto crud = new ClassProducto();
	
		List<TblProductocl2> listadoproductos = crud.ListadoProducto();
		
		for(TblProductocl2 listar:listadoproductos) {
	
		System.out.println(
				"codigo :"+listar.getIdproductocl2()+"\n"+
				"nombre :"+listar.getNombrecl2()+"\n"+
				"precioVenta :"+listar.getPrecioventacl2()+"\n"+
				"precioCompra :"+listar.getPreciocompcl2()+"\n"+
				"Estado :"+listar.getEstadocl2() +"\n"+
				"Descripcion :"+listar.getDescripcl2()+"\n"+
				"--------------------------------------------"+
				"\n"
				);
		}
	}

}
