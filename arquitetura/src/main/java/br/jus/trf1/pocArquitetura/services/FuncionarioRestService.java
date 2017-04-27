package br.jus.trf1.pocArquitetura.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.jus.trf1.pocArquitetura.dao.FuncionarioDAO;
import br.jus.trf1.pocArquitetura.entidades.Funcionario;

@Path("/")
@Consumes({"application/json"})
@Produces({"application/json"})
public class FuncionarioRestService {
	
	@Inject
	FuncionarioDAO funcionarioDAO;
	
	@POST
	@Path("funcionarios")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response simpleRest(Funcionario funcionario){
		Funcionario func = funcionarioDAO.save(funcionario);
		return Response.status(200).entity(func).build();
	}
	
	 @GET
	 @Path("funcionario/{matricula}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Funcionario getFuncionario(@PathParam("matricula") String matricula){
		 
		 
		 
		 return funcionarioDAO.find(Funcionario.class, matricula);
	 }
}
