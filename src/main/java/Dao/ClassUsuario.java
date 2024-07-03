package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.InterfaceUsusario;
import Modelos.TblUsuariocl3;

public class ClassUsuario implements InterfaceUsusario{

	@Override
	public void RegistrarUsuario(TblUsuariocl3 usuario) {
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
	public List<TblUsuariocl3> ListadoUsuario() {
		//establecemos la conexion con la unidad de persistencia..
        EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
        //gestionamos las entidads
        EntityManager em=fabr.createEntityManager();
        //iniciamos la transaccion
        em.getTransaction().begin();
        //recuperamos los clientes  de la base de datos
        //***********utilizando jpql
        List<TblUsuariocl3> listadoUsuarios = em.createQuery("select c from TblUsuariocl3 c",TblUsuariocl3.class).getResultList();
        //confirmamos la transaccion
        em.getTransaction().commit();
        //cerramos
        em.close();
		return listadoUsuarios;
	}

	@Override
	public TblUsuariocl3 validarUsuario(String vLogin, String vClave) {
		 EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_GUTIERREZ_RIVEROS");
	        EntityManager em = fabr.createEntityManager();
	        TblUsuariocl3 usuario = null;
	        try {
	           
	            String jpql = "select c from TblUsuariocl3 c WHERE c.usuariocl3 =:usuario AND c.passwordcl3 =:contra";
	            TypedQuery<TblUsuariocl3> query = em.createQuery(jpql, TblUsuariocl3.class);
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
