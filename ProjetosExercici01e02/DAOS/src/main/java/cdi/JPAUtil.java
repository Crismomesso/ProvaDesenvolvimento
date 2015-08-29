package main.java.cdi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("teste");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
