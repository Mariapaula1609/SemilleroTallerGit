package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.*;

@Stateless

@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	public EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			
			consultaNativa.setParameter("idComic", idComic);
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) consultaNativa.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}

		return consultaNombrePrecioDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO actualizarComic(ComicDTO comicDto) {
	  String consulta = "SELECT cm from Comic cm WHERE cm.id = :idComic ";
	  Comic comic = new Comic();
	  ResultadoDTO resultado = new ResultadoDTO();
	  try {
		  Query consultaNativa = em.createQuery(consulta);
		  consultaNativa.setParameter("idComic", comicDto.getId());
		  comic = (Comic) consultaNativa.getSingleResult();
		  comic.setNombre(comicDto.getNombre());
		  comic.setAutores(comicDto.getAutores());
		  comic.setCantidad(comicDto.getCantidad());
		  comic.setColeccion(comicDto.getColeccion());
		  comic.setColor(comicDto.getColor());
		  comic.setPrecio(comicDto.getPrecio());
		  comic.setEditorial(comicDto.getEditorial());
		  comic.setEstadoEnum(comicDto.getEstadoEnum());
		  comic.setNumeroPaginas(comicDto.getNumeroPaginas());
		  comic.setFechaVenta(comicDto.getFechaVenta());
		  comic.setTematicaEnum(comicDto.getTematicaEnum());
		  em.merge(comic);
		  resultado.setExitoso(true);
		  resultado.setMensajeEjecucion("El comic"+comic.getId() + "fue actualizado");
		  return resultado;
		  
		} catch (Exception e) {
			 resultado.setExitoso(false);
			 resultado.setMensajeEjecucion("El comic"+comic.getId() + " no fue actualizado");
			 return resultado;
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO eliminarComic(Long idComic) {
		ResultadoDTO resultado = new ResultadoDTO();
		Comic comic = new Comic();
		comic = em.find(Comic.class, idComic);
		System.out.println(comic);
		 if (comic != null) {
		      em.remove(comic);
		      resultado.setExitoso(true);
		      return resultado;
		 }
		resultado.setExitoso(false);
		return resultado;	
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		String findAllComic = " SELECT cm FROM Comic cm ";
		List<ComicDTO> comicsDto = new ArrayList<ComicDTO>();
		try {
			Query queryFindAllComic = em.createQuery(findAllComic);
			List<Comic> listaComics = queryFindAllComic.getResultList();
			if(listaComics.isEmpty()) {
				throw new Exception("No hay comics");
			}
			else {
				for (int i = 0; i < listaComics.size(); i++) {
					comicsDto.add(convertirComicToComicDTO(listaComics.get(i)));
					comicsDto.get(i).setExitoso(true);
					comicsDto.get(i).setMensajeEjecucion("consulta exitoso");
				}
				return comicsDto;
			}
			
			
		} catch (Exception e) {
			comicsDto.get(0).setExitoso(false);
			comicsDto.get(0).setMensajeEjecucion("Error en la consulta ");
			
		}
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) {
		String findAllComic = " SELECT c.nombre FROM Comic cm ";
		try {
			Query queryFindAllComic = em.createQuery(findAllComic);
			List<ComicDTO> listaComics = queryFindAllComic.getResultList();
			System.out.println(listaComics);
			} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ComicDTO consultarComic(Long idComic) {
		System.out.println(idComic);
		String consulta = "SELECT cm from Comic cm WHERE cm.id = :idComic ";
		 Comic comic = new Comic();
		 ComicDTO comicDTO = new ComicDTO();
		 try {
			 Query consultaNativa = em.createQuery(consulta);
			 consultaNativa.setParameter("idComic", idComic);
			 comic = (Comic) consultaNativa.getSingleResult();
			 comicDTO= convertirComicToComicDTO(comic);
			 comicDTO.setExitoso(true);
			 comicDTO.setMensajeEjecucion("El comic consultado correctamente");
			 System.out.println(comicDTO);
			 return comicDTO;
		} catch (Exception e) {
			// TODO: handle exception
			 comicDTO.setExitoso(false);
			 comicDTO.setMensajeEjecucion("El comic no se ha consultado correctamente");
		}
		return comicDTO;
	}

	@Override
	public ComicDTO consultarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		String consulta = "SELECT cm from Comic cm WHERE cm.nombre = :nombre ";
		 Comic comic = new Comic();
		 ComicDTO comicDTO = new ComicDTO();
		 try {
			 Query consultaNativa = em.createQuery(consulta);
			 consultaNativa.setParameter("nombre", nombre);
			 comic = (Comic) consultaNativa.getSingleResult();
			 comicDTO= convertirComicToComicDTO(comic);
			 comicDTO.setExitoso(true);
			 comicDTO.setMensajeEjecucion("El comic consultado correctamente");
			 return comicDTO;
		} catch (Exception e) {
			// TODO: handle exception
			 comicDTO.setExitoso(false);
			 comicDTO.setMensajeEjecucion("El comic no se ha consultado correctamente");
		}
		return comicDTO;
	}
	
	
		
	

}
