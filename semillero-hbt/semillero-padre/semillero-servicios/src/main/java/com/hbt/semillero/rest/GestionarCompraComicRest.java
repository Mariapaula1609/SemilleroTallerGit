package com.hbt.semillero.rest;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.ejb.IGestionarCompraComic;;

@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComic gestionarCompraComic ;
	
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO compraComic(CompraDTO compra) {
		return this.gestionarCompraComic.comprarComic(compra);
	}
}
