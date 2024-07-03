package Test;

import java.util.List;

import Dao.ClassProducto;
import Modelos.TblProductocl3;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TblProductocl3 prod = new TblProductocl3();
		ClassProducto crud = new ClassProducto();
	/*
		List<TblProductocl3> listadoproductos = crud.ListadoProducto();
		
		for(TblProductocl3 listar:listadoproductos) {
	
		System.out.println(
				"codigo :"+listar.getIdproductocl3()+"\n"+
				"nombre :"+listar.getNombrecl3()+"\n"+
				"precioVenta :"+listar.getPrecioventacl3()+"\n"+
				"precioCompra :"+listar.getPreciocompcl3()+"\n"+
				"Estado :"+listar.getEstadocl3() +"\n"+
				"Descripcion :"+listar.getDescripcl3()+"\n"+
				"--------------------------------------------"+
				"\n"
				);}*/
		
		/*//actualizar
		prod.setIdproductocl3(2);
		prod.setNombrecl3("Leche Endulcorada");
		prod.setPrecioventacl3(4.50);
		prod.setPreciocompcl3(5.90);
		prod.setEstadocl3("agotado");
		prod.setDescripcl3("normal");		
		// invocamos s metodo actualizar
		crud.ActualizarProducto(prod);
		*/
		
		//eliminar
		//eliminamos el registro con idclientede numero cuatro
		prod.setIdproductocl3(4);
		//invocamos el metodo eliminar datos de la BD
		crud.EliminarProducto(prod);
		
		
		
		}
	}



