package semillero.pruebasUnitarias;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import junit.framework.Assert;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas para saber si una comic es inactivo o activo 
 * de comics. <b>Caso de Uso:<b> hbt semillero
 * 
 * @author 
 * @version
 */
public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(CreacionComicTest.class);

	/**
	 * Atributo que determina la lista de comics
	 * Atributo para la lista de comics activos
	 * Atributo para la lista de comics inactivos
	 */
	ArrayList<ComicDTO> comics = new ArrayList<ComicDTO>();
	public ArrayList<ComicDTO> comicDTOActivos;
	public ArrayList<ComicDTO> comicDTOInactivos;

	/**
	 * 
	 * Metodo encargado de enviar mensaje de inicio de pruebas <b>Caso de Uso</b>
	 * 
	 * @author 
	 *
	 */
	@BeforeTest
	public void inicializar() {
		if (comics.isEmpty()) {
			llenarListaComics();
		}
		this.comicDTOActivos = comicsActivos();
		this.comicDTOInactivos = comicsInactivos();
		BasicConfigurator.configure();// inicializa el logger con una config basica
		log.info(":::::::::INICIAN PRUEBAS UNITARIAS:::::::::");
	}

	/**
	 * 
	 * Metodo encargado de filtrar los comics activos 
	 * 
	 * @author Maria Paula
	 *
	 */
	private ArrayList<ComicDTO> comicsActivos() {
		ArrayList<ComicDTO> lstTemp = new ArrayList<>();
		for (ComicDTO comicDTO : comics) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) {
				lstTemp.add(comicDTO);
			}
		}
		return lstTemp;
	}

	/**
	 * Metodo encargado de filtrar los comics inactivos<b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 * 
	 * @return
	 */
	private ArrayList<ComicDTO>comicsInactivos() {
		ArrayList<ComicDTO> lstTemp = new ArrayList<>();
		for (ComicDTO comicDTO : comics) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
				lstTemp.add(comicDTO);
			}

		}
		return lstTemp;

	}
	/**
	 * 
	 * Metodo encargado de llenar la lista de comics 
	 * @author Maria Paula
	 *
	 */
	private void llenarListaComics() {
		LocalDate hoy = LocalDate.now();
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

	/**
	 * 
	 * Test encargado de validar los comics activos 
	 * 
	 * @author Maria Paula
	 *
	 */
	@Test
	public void validarActivos() {

		log.info("Inicia ejecucion del metodo validarActivos()");

		Assert.assertNotNull(comicDTOActivos);
		for (ComicDTO comicDTO : comicDTOActivos) {
			Assert.assertEquals(comicDTO.getEstadoEnum(), EstadoEnum.ACTIVO);
			System.out.println(comicDTO.toString());
		}

		log.info("Finaliza la ejecucion del metodo validarActivos()");
	}
	/**
	 * 
	 * Test encargado de validar comics Inactivos
	 * <b>Caso de Uso</b>
	 * @author Maria Paula
	 *
	 */

	@Test
	public void validarInactivos() {

		log.info("Inicia ejecucion del metodo validarInactivos()");
		ArrayList<String> lstTemp = new ArrayList<>();
		for (ComicDTO comicDTO : comicDTOInactivos) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
				lstTemp.add(comicDTO.getNombre());
			}
		}	
		
		try {
			
			throw new Exception("Se ha detectado que de " + comics.size() + " comics se encontraron que "
					+ comicDTOActivos.size() + " se encuentran activos y " + comicDTOInactivos.size()
					+ " inactivos. Los comics inactivos son:" + lstTemp.toString());				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		log.info("Finaliza la ejecucion del metodo validarInactivos()");
	}

	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::FINALIZA PRUEBAS UNITARIAS:::::::::");
	}
}
