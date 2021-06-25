package br.com.project.model.classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import br.com.jpa.jpautil.JpaUtil;

public class DaoGeneric<E>   {

	  private EntityManager getEntityManager() {
	EntityManagerFactory factory = null;
	 EntityManager entityManager = null;
	 try {
		factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		
	  entityManager = factory.createEntityManager();
	 }
	 finally {
		 factory.close();
	 }
	return entityManager;
	  }
	
	
	
	
	public void salvar(E entidade) {
		
		EntityManager entityManager = getEntityManager();
	    EntityTransaction entityTransaction =  entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entidade);
		entityTransaction.commit();
		entityManager.close();
		
	}
	
	

}
