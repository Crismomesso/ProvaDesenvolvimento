package services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

import br.com.ex01.EntitiesVO.AuthUser;
import main.java.cdi.UserBusiness;
import util.ExceptionMapperImpl;



@Path("user")
@RequestScoped
public class UserService {

	@Inject
	UserBusiness userBusiness;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(String json) {
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(json);
			final ObjectMapper objectMapper = new ObjectMapper();
			final AuthUser request = objectMapper.readValue(jsonObj.toString(), AuthUser.class);
			Integer findUserId = userBusiness.findUserId(request.getUser(), request.getPassword());
	        return Response.status(Response.Status.OK).entity(findUserId).build();

		} catch (Exception e) {
			return  new ExceptionMapperImpl().toResponse(e);
		}
	}
	
	
	@POST
	@Path("/saveUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newUser(String json) {
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(json);
			final ObjectMapper objectMapper = new ObjectMapper();
			final AuthUser request = objectMapper.readValue(jsonObj.toString(), AuthUser.class);
			Integer findUserId = userBusiness.saveUser(request);
	        return Response.status(Response.Status.OK).entity(findUserId).build();

		} catch (Exception e) {
			return  new ExceptionMapperImpl().toResponse(e);
		}
	}
	
}
