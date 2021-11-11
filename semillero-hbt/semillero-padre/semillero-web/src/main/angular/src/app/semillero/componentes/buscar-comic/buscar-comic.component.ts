import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic-dto';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
@Component({
  selector: 'buscar-comic',
  templateUrl: './buscar-comic.component.html',
  styleUrls: ['./buscar-comic.component.css']
})
export class BuscarComicComponent implements OnInit {
  public mostrarItem : boolean;
  public comicDTOInfo : ComicDTO;
  public nombreComicBuscar : String;
  constructor(private gestionComicsService : GestionarComicService) { }
  
  ngOnInit() {
    this.mostrarItem = false;
    this.comicDTOInfo = new ComicDTO();
  }
  public buscarComic(){
    this.gestionComicsService.consultarComicNombre(this.nombreComicBuscar).subscribe(data =>{
      console.log(data)
      if(data.exitoso){
         this.comicDTOInfo.nombre= data.nombre
         this.comicDTOInfo.editorial = data.editorial;
         this.comicDTOInfo.coleccion = data.coleccion;
         this.comicDTOInfo.tematicaEnum = data.tematicaEnum
      }
    })
  }

}
