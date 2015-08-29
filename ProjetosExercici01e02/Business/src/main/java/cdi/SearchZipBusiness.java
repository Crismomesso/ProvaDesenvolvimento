package main.java.cdi;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.ex01.EntitiesVO.AdressVO;
import br.com.ex01.EntitiesVO.RespostaWebService;
import main.java.exception.BusinessException;

/**
 * @author Cristiano Momesso
 *
 */
public interface SearchZipBusiness {
	void validZipCode(String cep) throws BusinessException;

	/**
	 * Busca Dados do endereço para um determinado Cep
	 * 
	 * @param objectMapper
	 * @param cep
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	RespostaWebService findZipCode(final ObjectMapper objectMapper, final String cep)
			throws BusinessException, Exception;

	/**
	 * Busca cep substituindo o digito da direita até ser achado (Obs: Regra 2
	 * do exercicio 1 )
	 * 
	 * @param cep
	 * @param objectMapper
	 * @return
	 * @throws BusinessException
	 * @throws Exception
	 */
	RespostaWebService tryToFindZipCode(String cep, ObjectMapper objectMapper) throws BusinessException, Exception;
		
	int save(AdressVO entitie);

	List<AdressVO> getById(Integer id) throws BusinessException;

	void delById(Integer integer) throws BusinessException;


}
