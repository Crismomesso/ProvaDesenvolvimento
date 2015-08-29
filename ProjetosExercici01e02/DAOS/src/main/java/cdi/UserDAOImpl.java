package main.java.cdi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.entitie.AdressEntitie;
import main.java.entitie.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public Integer findUserId(String user, String password) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Query query = manager.createQuery("select m from User m where m.user like :pUser and m.password like :pPassword");

		query.setParameter("pUser", user);
		query.setParameter("pPassword", password);

		User  login = (User) query.getSingleResult();

		manager.getTransaction().commit();

		manager.close();
		return login.getId();
	}
	
	@Override
	public Integer addUser(User user) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		
        manager.persist(user);

		manager.getTransaction().commit();

		manager.close();
		return user.getId();
	}

}
