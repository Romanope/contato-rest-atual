package com.apirest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apirest.dao.ContatoDAO;
import com.apirest.model.Contato;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/contato")
public class ContatoResource {

	private ContatoDAO contatoDAO = new ContatoDAO();
	private ObjectMapper mapper = new ObjectMapper();
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String get() {
		try {
			return mapper.writeValueAsString(contatoDAO.listAll());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		} finally {
			System.out.println("finalizando consulta dos contatos");
		}
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String post(Contato contato) throws JsonProcessingException {
		contatoDAO.save(contato);
		return mapper.writeValueAsString(contatoDAO.listAll());  
	}
}
