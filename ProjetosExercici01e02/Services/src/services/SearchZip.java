package services;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.ex01.EntitiesVO.AuthUser;
import br.com.ex01.EntitiesVO.RequestFindZipCode;
import br.com.ex01.EntitiesVO.AdressVO;
import br.com.ex01.EntitiesVO.RespostaWebService;
import exception.ServicesException;
import main.java.cdi.SearchZipBusiness;
import main.java.cdi.Test;
import main.java.exception.BusinessException;
import util.ExceptionMapperImpl;

@Path("zip")
@RequestScoped
public class SearchZip {

    @Inject private SearchZipBusiness searchZipBusiness;
    

    /**
     * Método web para calculo da rota
     * @param json
     * @return json
     * @throws JSONException 
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @POST
    @Path("/searchZipCode")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response  zipFind(String json) throws ServicesException, JSONException, JsonParseException, JsonMappingException, IOException {
        RespostaWebService result = new RespostaWebService();
        Response response = null;
        try {
            final JSONObject jsonObj = new JSONObject(json);
            final ObjectMapper objectMapper = new ObjectMapper();
            final RequestFindZipCode request = objectMapper.readValue(jsonObj.toString(), RequestFindZipCode.class);

            searchZipBusiness.validZipCode(request.getCep());
            
            result = searchZipBusiness.tryToFindZipCode(request.getCep(),objectMapper);
                
            return Response.status(Response.Status.OK).entity(result).build();
        } catch (final BusinessException e) {
        	response = new ExceptionMapperImpl().toResponse(e);
        }catch(Exception e){
        	response = new ExceptionMapperImpl().toResponse(e);
        }
        return response;
    }
    
    /**
     * Método web para calculo da rota
     * @param json
     * @return json
     * @throws JSONException 
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    
    @POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(String json) {
    	 Response response = null;
		try {
			final JSONObject jsonObj = new JSONObject(json);
            final ObjectMapper objectMapper = new ObjectMapper();
            final AdressVO request = objectMapper.readValue(jsonObj.toString(), AdressVO.class);
            int id = searchZipBusiness.save(request);
            return Response.status(Response.Status.OK).entity(id).build();
		} catch (Exception e) {
			return  new ExceptionMapperImpl().toResponse(e);
		}
	}
    
    
    @POST
	@Path("/getAdress")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdress(String json) {
		try {
             List<AdressVO> list = searchZipBusiness.getById(new Integer(json));
            return Response.status(Response.Status.OK).entity(list).build();
		} catch (Exception e) {
			return  new ExceptionMapperImpl().toResponse(e);
		}
	}
    @POST
    @Path("/deletar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delAdress(String json) {
    	try {
    		searchZipBusiness.delById(new Integer(json));
    		return Response.status(Response.Status.OK).entity(1).build();
    	} catch (Exception e) {
    		return  new ExceptionMapperImpl().toResponse(e);
    	}
    }
}
