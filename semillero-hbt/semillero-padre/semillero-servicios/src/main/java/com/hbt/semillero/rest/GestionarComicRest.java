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
	@Path("/actualizarNombreComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO actualizarNombreComic(@QueryParam("idComic") Long idComic,
										  @QueryParam("nombreNuevo") String nombreComic) {
		ResultadoDTO comicDTOResult = new ResultadoDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.actualizarComic(idComic,nombreComic);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	
	@POST
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic) {
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
	
}
