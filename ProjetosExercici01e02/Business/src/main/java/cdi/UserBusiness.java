package main.java.cdi;

import main.java.exception.BusinessException;

public interface UserBusiness {
	  Integer findUserId(String user, String password) throws BusinessException;
}
