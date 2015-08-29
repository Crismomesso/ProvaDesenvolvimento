package test.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.ex01.EntitiesVO.AdressVO;
import main.java.cdi.JPAUtil;
import main.java.entitie.AdressEntitie;
import main.java.entitie.User;

public class GerarLogins {
	
	
	
	@Test
	public void gerarLogins() {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		User user = new User();
		user.setUser("teste'");
		user.setPassword("123");
		
		manager.persist(user);
		manager.getTransaction().commit();

		manager.close();
	}
}
