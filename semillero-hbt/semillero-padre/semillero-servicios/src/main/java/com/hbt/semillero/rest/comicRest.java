package com.hbt.semillero.rest;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

public class comicRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate hoy = LocalDate.now();
		ArrayList<ComicDTO> comics = new ArrayList<ComicDTO>();
		ComicDTO comic1= new ComicDTO("1", "batman", "Kindom", TematicaEnum.CIENCIA_FICCION, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.ACTIVO, 20L);
		comics.add(comic1);
		ComicDTO comic2= new ComicDTO("2", "Superman", "Kindom", TematicaEnum.AVENTURAS, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic2);
		ComicDTO comic3= new ComicDTO("3", "InuYasha", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.ACTIVO, 20L);
		comics.add(comic3);
		ComicDTO comic4= new ComicDTO("4", "Maus", "Kindom", TematicaEnum.AVENTURAS, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic4);
		ComicDTO comic5= new ComicDTO("5", "El tesoro del Cisne Negro", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.ACTIVO, 20L);
		comics.add(comic5);
		ComicDTO comic6= new ComicDTO("6", "Super Games World", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic6);
		ComicDTO comic7= new ComicDTO("7", "THE UMBRELLA ACADEMY 3. HOTEL OBLIVION", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic7);
		ComicDTO comic8= new ComicDTO("8", "Arkham Asylum: A Serious House on Serious Earth. HOTEL OBLIVION", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.ACTIVO, 20L);
		comics.add(comic8);
		ComicDTO comic9= new ComicDTO("9", "The Terrifics", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic9);
		ComicDTO comic10= new ComicDTO("10", "lOBO", "Kindom", TematicaEnum.FANTASTICO, "1", 5, new BigDecimal(250000), "Dennis O'Neil ", false,  hoy , EstadoEnum.INACTIVO, 20L);
		comics.add(comic10);

	}

}
