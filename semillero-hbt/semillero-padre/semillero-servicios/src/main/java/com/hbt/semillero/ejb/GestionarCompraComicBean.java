package com.hbt.semillero.ejb;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class GestionarCompraComicBean implements IGestionarCompraComic{
	@PersistenceContext
	public EntityManager em;
	public IGestionarComicLocal gestionarComic;
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO comprarComic(CompraDTO compra) {
		// TODO Auto-generated method stub
		System.out.println(compra.getId());
		
		ResultadoDTO resultado = new ResultadoDTO();
		try {
			String consulta = "SELECT cm from Comic cm WHERE cm.id = :idComic ";
			Comic comic = new Comic();
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic",compra.getId());
			comic = (Comic) consultaNativa.getSingleResult(); 
			 if(comic.getEstadoEnum().equals(EstadoEnum.INACTIVO) ) {
				 
				 throw new Exception("“El comic seleccionado no cuenta con stock en bodega”");
			 }else {
				 if(compra.getCantidad() <= comic.getCantidad()) {
					//podria actualizar
					 LocalDate hoy = LocalDate.now();
					 comic.setFechaVenta(hoy);
					 if(compra.getCantidad() == comic.getCantidad()) {
						 comic.setEstadoEnum(EstadoEnum.INACTIVO);
					 }
					 comic.setCantidad(comic.getCantidad()-compra.getCantidad());
					 em.merge(comic);
					 resultado.setExitoso(true);
					 resultado.setMensajeEjecucion("“La compra del comic" +comic.getNombre()+ "fue exitosa”");
				 }else {
					 throw new Exception("“La cantidad existente del comic es:"+ comic.getCantidad()+" supera la ingresada”");
				 }
				
			 }
		} catch (Exception e) {
			resultado.setExitoso(true);
			resultado.setMensajeEjecucion(e.getMessage());
			// TODO: handle exception
		}
		 
		return resultado;
	}

}
