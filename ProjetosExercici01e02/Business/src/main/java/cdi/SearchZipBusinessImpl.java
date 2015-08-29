package main.java.cdi;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.ex01.EntitiesVO.RequestFindZipCode;
import br.com.ex01.EntitiesVO.AdressVO;
import br.com.ex01.EntitiesVO.RespostaWebService;
import main.java.entitie.AdressEntitie;
import main.java.exception.BusinessException;

/**
 * @author Cristiano Momesso
 */
public class SearchZipBusinessImpl implements SearchZipBusiness {

	@Inject UtilBusiness utilBusiness;
	
	@Inject AdressDAO adressDAO;
	
	
	/* 
	 * Metodo que valida o Cep.
	 */
	@Override
	public void validZipCode(String cep) throws BusinessException {
		 if (cep.length() != 8) {
             throw new BusinessException("CEP invalido - deve conter 8 digitos: " + cep);
         }
		 if(utilBusiness.hasLetter(cep)){
			 throw new BusinessException("CEP invalido - deve conter apenas numeros.");
		 }
		 
	}

	@Override
	public RespostaWebService findZipCode(ObjectMapper objectMapper, String cep) throws BusinessException,Exception {
		RespostaWebService result = new RespostaWebService();
		// Ao Inves de mockar , preferi já usar um webService pronto para buscar
		// dados reais
		final URL url = new URL("http://viacep.com.br/ws/" + cep + "/json/unicode");
		final HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(30000);
		
		if (con.getResponseCode() == 400) {
			result.setErro("true");
			return result;
		}
		
		if (con.getResponseCode() != 200) {
			throw new BusinessException("HTTP error code : " + con.getResponseCode());
		}
		final String res = this.utilBusiness.convertInputStreamToString(con.getInputStream());

		result = objectMapper.readValue(res, RespostaWebService.class);
		
		if(result.hasErro()==null){
			result.setErro("false");
		}
		
		return result;
	}

	@Override
	public RespostaWebService tryToFindZipCode(String cep,ObjectMapper objectMapper) throws BusinessException, Exception {
		StringBuilder bCep = new StringBuilder(cep);
		for (int i = bCep.length()-1 ; i >= 0; i--) {
			RespostaWebService findZipCode = this.findZipCode(objectMapper, bCep.toString());
			bCep.setCharAt(i, '0');
			if(findZipCode.hasErro().equals("false")){
				return findZipCode;
			}
		}
        throw new BusinessException("Nao existe nenhum Cep Valido");
	}

	@Override
	public int save(AdressVO entitie) {
		return adressDAO.save(entitie);
	}

	@Override
	public List<AdressVO> getById(Integer id) throws BusinessException{
		try {
			List<AdressEntitie> obj = adressDAO.getById(id);
			List<AdressVO> list = new ArrayList<AdressVO>();
			
			for (AdressEntitie adressEntitie : obj) {
				list.add(this.convertToVO(adressEntitie));
			}
			return list;			
		} catch (Exception e) {
			   throw new BusinessException("Erro ao buscar dados");
		}
	}
	
	private AdressVO convertToVO(AdressEntitie entitie) {
		AdressVO obj = new AdressVO();
		obj.setId(entitie.getId().toString());
		obj.setBairro(entitie.getBairro());
		obj.setCity(entitie.getCity());
		obj.setComplemento(entitie.getComplemento());
		obj.setLogradouro(entitie.getLogradouro());
		obj.setNumerStreet(entitie.getNumerStreet());
		obj.setState(entitie.getState());
		obj.setZip(entitie.getZip());
		obj.setUserId(entitie.getUser().getId());
		return obj;
	}

	@Override
	public void delById(Integer integer) throws BusinessException {
		try {
			adressDAO.delById(integer);
		} catch (Exception e) {
			throw new BusinessException("Erro ao deletar endereco");
		}
		
	}

}
