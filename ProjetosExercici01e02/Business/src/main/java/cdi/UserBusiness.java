package main.java.cdi;

import br.com.ex01.EntitiesVO.AuthUser;
import main.java.entitie.User;
import main.java.exception.BusinessException;

public interface UserBusiness {
	  Integer findUserId(String user, String password) throws BusinessException;
	  Integer saveUser(AuthUser request);
}
