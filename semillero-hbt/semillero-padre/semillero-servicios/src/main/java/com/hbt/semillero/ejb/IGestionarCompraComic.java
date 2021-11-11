package com.hbt.semillero.ejb;
import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.dto.ResultadoDTO;

public interface IGestionarCompraComic {
	
	public ResultadoDTO comprarComic(CompraDTO compra);
}
