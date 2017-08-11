package com.apirest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apirest.dao.OperadoraDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/operadora")
public class OperadoraResource {

	public OperadoraResource() {
		System.out.println("Contruindo o objeto operadora resource");
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String get() throws JsonProcessingException {
		OperadoraDAO operadoraDAO = new OperadoraDAO();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(operadoraDAO.listAll());
	}
}
