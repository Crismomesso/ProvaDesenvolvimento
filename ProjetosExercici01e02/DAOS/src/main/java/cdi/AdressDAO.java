package main.java.cdi;

import java.util.List;

import br.com.ex01.EntitiesVO.AdressVO;
import main.java.entitie.AdressEntitie;

public interface AdressDAO {
	int save(AdressVO entitie);

	List<AdressEntitie> getById(Integer id);

	void delById(Integer integer);
	
}
