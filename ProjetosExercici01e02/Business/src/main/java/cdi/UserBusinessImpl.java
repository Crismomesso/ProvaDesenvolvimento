package main.java.cdi;

import javax.inject.Inject;

import main.java.exception.BusinessException;

public class UserBusinessImpl implements UserBusiness{
	
	@Inject UserDAO userDAO;
	
	@Override
	public Integer findUserId(String user, String password) throws BusinessException {
		return userDAO.findUserId(user, password);
	}

}
