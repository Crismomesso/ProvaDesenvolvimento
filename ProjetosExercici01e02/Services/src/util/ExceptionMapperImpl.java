package util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.ex01.EntitiesVO.ErroVO;

@Provider
public class ExceptionMapperImpl implements ExceptionMapper<Exception> {

	public ExceptionMapperImpl() {
	}

	@Override
	public Response toResponse(Exception erro) {
		ErroVO erroDTO = null;

	    erroDTO = new ErroVO(erro.getMessage());
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(erroDTO).build();
	}

}