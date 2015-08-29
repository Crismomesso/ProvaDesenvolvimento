package main.java.cdi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ex01.EntitiesVO.AdressVO;
import main.java.entitie.AdressEntitie;
import main.java.entitie.User;

public class AdressDAOImpl implements AdressDAO {

	@Override
	public int save(AdressVO entitie) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		AdressEntitie adress = new AdressEntitie();

		
		
		adress.setBairro(entitie.getBairro());
		adress.setCity(entitie.getCity());
		adress.setComplemento(entitie.getComplemento());
		adress.setLogradouro(entitie.getLogradouro());
		adress.setNumerStreet(entitie.getNumerStreet());
		adress.setState(entitie.getState());
		adress.setZip(entitie.getZip());
		User user = new User();
		user.setId(entitie.getUserId());
		adress.setUser(user);
		
		if(entitie.getId()!=null){
			adress.setId(Integer.parseInt(entitie.getId()));
			manager.merge(adress);
		}else{
			manager.persist(adress);
		}
		manager.getTransaction().commit();

		manager.close();

		return adress.getId();
	}

	@Override
	public List<AdressEntitie> getById(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		User us = manager.find(User.class, id);
		

		List<AdressEntitie> adress = us.getAdress();

		manager.getTransaction().commit();

		manager.close();
		return adress;

	}

	@Override
	public void delById(Integer integer) {
		// TODO Auto-generated method stub
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Query query = manager.createQuery("select m from AdressEntitie m where m.id=:pAdress");

		query.setParameter("pAdress", integer);

		AdressEntitie movimentacoes = (AdressEntitie) query.getSingleResult();
		manager.remove(movimentacoes);
		
		manager.getTransaction().commit();

		manager.close();
	}

}
