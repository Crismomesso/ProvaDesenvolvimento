package main.java.cdi;

import javax.inject.Inject;

import br.com.ex01.EntitiesVO.AuthUser;
import main.java.entitie.User;
import main.java.exception.BusinessException;

public class UserBusinessImpl implements UserBusiness{
	
	@Inject UserDAO userDAO;
	
	@Override
	public Integer findUserId(String user, String password) throws BusinessException {
		return userDAO.findUserId(user, password);
	}

	@Override
	public Integer saveUser(AuthUser user) {
		User userEntitie = new User();
		userEntitie.setUser(user.getUser());
		userEntitie.setPassword(user.getPassword());
		return userDAO.addUser(userEntitie);
	}

}
