package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.InterfaceProducto;
import Modelos.TblProductocl3;

public class ClassProducto implements InterfaceProducto {

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		//establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.println("Producto registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();		
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los clientes  de la base de datos
        //***********utilizando jpql
        List<TblProductocl3> listadoProductos = em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoProductos;
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
		
		EntityManager emanager = em.createEntityManager();
	
		emanager.getTransaction().begin();
		
		emanager.merge(producto);
		
		System.out.print("Producto actualizado en la BD");
		
		emanager.getTransaction().commit();
		
		emanager.close();
		
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");

		EntityManager emanager = em.createEntityManager();

		emanager.getTransaction().begin();

		TblProductocl3 elim = emanager.merge(producto);

		emanager.remove(elim);

		System.out.print("Producto eliminado de la BD");

		emanager.getTransaction().commit();

		emanager.close();
		
	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {

		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
		
		EntityManager emanager = em.createEntityManager();
		
		emanager.getTransaction().begin();
		
		TblProductocl3 buscarProducto = emanager.find(TblProductocl3.class, producto.getIdproductocl3());
		
		emanager.getTransaction().commit();
	
		emanager.close();
	
		return buscarProducto;
		
	}


}
