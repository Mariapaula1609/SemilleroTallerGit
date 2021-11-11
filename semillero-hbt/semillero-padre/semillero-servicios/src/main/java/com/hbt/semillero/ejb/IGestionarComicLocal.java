package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ResultadoDTO;

@Local
public interface IGestionarComicLocal {
	
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	public ResultadoDTO actualizarComic(ComicDTO comicDTO);
	
	public ResultadoDTO eliminarComic(Long idComic);
	
	public List<ComicDTO> consultarComics();
	
	public ComicDTO consultarComic(Long idComic);
	
	public ComicDTO consultarPorNombre(String nombre);
	
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic);
}
