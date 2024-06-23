package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.InterfaceUsusario;
import Modelos.TblUsuariocl2;

public class ClassUsuario implements InterfaceUsusario{

	@Override
	public void RegistrarUsuario(TblUsuariocl2 usuario) {
		//establecer conexion con la unidad de persistencia...
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
	    //permite gestionar entidades
		EntityManager em=fabr.createEntityManager();
		//iniciar transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(usuario);
		//emitimos mensaje por consola
		System.out.println("Usuario registrado en la BD correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();		
		
	}

	@Override
	public List<TblUsuariocl2> ListadoUsuario() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los clientes  de la base de datos
        //***********utilizando jpql
        List<TblUsuariocl2> listadoUsuarios = em.createQuery("select c from TblUsuariocl2 c",TblUsuariocl2.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoUsuarios;
	}

	@Override
	public TblUsuariocl2 validarUsuario(String vLogin, String vClave) {
		 EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
	        EntityManager em = fabr.createEntityManager();
	        TblUsuariocl2 usuario = null;
	        try {
	           
	            String jpql = "select c from TblUsuariocl2 c WHERE c.usuariocl2 =:usuario AND c.passwordcl2 =:contra";
	            TypedQuery<TblUsuariocl2> query = em.createQuery(jpql, TblUsuariocl2.class);
	            query.setParameter("usuario", vLogin);
	            query.setParameter("contra", vClave);
	            
	            usuario = query.getSingleResult();
	        } catch (NoResultException e) {
	            // Usuario no encontrado
	            usuario = null;
	        } finally {
	            em.close();
	        }
	        return usuario;
	}
}
