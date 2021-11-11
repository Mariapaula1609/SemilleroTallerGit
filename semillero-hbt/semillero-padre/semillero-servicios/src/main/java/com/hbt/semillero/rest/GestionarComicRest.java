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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

@Path("/gestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;

	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}
	
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	
	@POST
	@Path("/actualizarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO actualizarComic(ComicDTO comicDTO) {
		 
		return this.gestionarComicLocal.actualizarComic(comicDTO);
		
	} 
	
	@POST
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(Long idComic) {
		ResultadoDTO resultado = new ResultadoDTO();
		try {
			this.gestionarComicLocal.eliminarComic(idComic);
			resultado.setExitoso(true);
			resultado.setMensajeEjecucion("Se pudo eliminar exitosamente el comic");
		}catch (Exception e) {
			resultado.setExitoso(false);
			resultado.setMensajeEjecucion("no se pudo eliminar exitosamente el comic");
		}
		
		return  resultado;
	}
	@GET
	@Path("/consultarTodosLosComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComics() {
		return this.gestionarComicLocal.consultarComics();
	}
	
	
	
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
		return this.gestionarComicLocal.consultarComicTamanioNombre(lengthComic);
	}
	
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarComic(idComic);
	}
	
	@GET
	@Path("/consultarComicNombre")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComicNombre(@QueryParam("nombre") String nombre) {
		return this.gestionarComicLocal.consultarPorNombre(nombre);
	}
}
