package co.com.techandsolve.creditcard.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ViolationException implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		
		return Response.serverError()
				.header("internalServerError", exception.getMessage())
				.build();
	}
}
