import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
import { ActivatedRoute, Params } from '@angular/router';

/**
 * @description Componente encargado de gestionar la logica para crear consultar actualizar y eliminar
 * un comic
 * @author dalvarez
 * @see SEMILLERO 2021
 */
@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent implements OnInit {

  public gestionarComicForm : FormGroup;

  public comicDTO : ComicDTO;

  public comicDTOInfo : ComicDTO;

  public nombre : string;

  public listaComics : Array<ComicDTO>;
  
  public mostrarItem : boolean;

  public submitted : boolean;

  public mensajeEjecucion : string;


  constructor(private fb : FormBuilder, private router : Router, private gestionComicsService : GestionarComicService, private rutaActiva: ActivatedRoute) { 
    this.gestionarComicForm = this.fb.group({
      nombre : [null, Validators.required],
      editorial : [null, Validators.required],
      tematica : [null],
      coleccion : [null, Validators.required],
      numeroPaginas : [null, Validators.required],
      precio : [null, Validators.required],
      autores : [null],
      color : [true],
      cantidad:[null,Validators.required]
    });
  }

  ngOnInit() {
    this.submitted = false;
    this.mostrarItem = false;
    this.comicDTO = new ComicDTO();
    this.listaComics = new Array<ComicDTO>();
    this.mensajeEjecucion = this.rutaActiva.snapshot.params.mensajeEjecucion
    this.consultarComics();
  }

  public consultarComics() {
    this.gestionComicsService.consultarComics().subscribe(data => {
      if (data[0].exitoso) {
        this.listaComics = data;
      } else {
        console.log(data[0].mensajeEjecucion);
      }
    }, error => {
      console.log(error);
    });

  }

  public crearComic() : void {
    this.submitted = true;
    if (this.gestionarComicForm.invalid) {
      return;
    }

    this.comicDTO = new ComicDTO();
    this.comicDTO.nombre = this.gestionarComicForm.controls.nombre.value;
    this.comicDTO.editorial = this.gestionarComicForm.controls.editorial.value;
    this.comicDTO.tematicaEnum = this.gestionarComicForm.controls.tematica.value;
    this.comicDTO.coleccion = this.gestionarComicForm.controls.coleccion.value;
    this.comicDTO.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
    this.comicDTO.precio = this.gestionarComicForm.controls.precio.value;
    this.comicDTO.autores = this.gestionarComicForm.controls.autores.value;
    this.comicDTO.color = this.gestionarComicForm.controls.color.value;
    this.comicDTO.estadoEnum = "ACTIVO";
    this.comicDTO.cantidad = this.gestionarComicForm.controls.cantidad.value;

    this.gestionComicsService.crearComic(this.comicDTO).subscribe(data=> {
      if (data.exitoso) {
        this.mostrarItem = true;
        this.mensajeEjecucion =data.mensajeEjecucion;
        console.log(data.mensajeEjecucion);
        this.consultarComics();
      } else {
        this.mostrarItem = true;
        this.mensajeEjecucion =data.mensajeEjecucion;
      }
      this.limpiarDatosComic();
    }, error => {
      console.log(error);
    });
    
  }

  private limpiarDatosComic() : void {
    this.submitted = false;
    this.gestionarComicForm.controls.nombre.setValue(null);
    this.gestionarComicForm.controls.editorial.setValue(null);
    this.gestionarComicForm.controls.tematica.setValue(null);
    this.gestionarComicForm.controls.coleccion.setValue(null);
    this.gestionarComicForm.controls.numeroPaginas.setValue(null);
    this.gestionarComicForm.controls.precio.setValue(null);
    this.gestionarComicForm.controls.autores.setValue(null);
    this.gestionarComicForm.controls.color.setValue(null);
    this.gestionarComicForm.controls.cantidad.setValue(null);
  }

  public consultarComic(posicion : number) : void {
    let comic = this.listaComics[posicion];
    this.f.nombre.setValue(comic.nombre);
    this.f.editorial.setValue(comic.editorial);
    this.f.tematica.setValue(comic.tematicaEnum);
    this.f.coleccion.setValue(comic.coleccion);
    this.f.numeroPaginas.setValue(comic.numeroPaginas);
    this.f.precio.setValue(comic.precio);
    this.f.autores.setValue(comic.autores);
    this.f.color.setValue(comic.color);


    this.f.nombre.disable();
    this.f.editorial.disable();
    this.f.tematica.disable();
    this.f.coleccion.disable();
    this.f.numeroPaginas.disable();
    this.f.precio.disable();
    this.f.autores.disable();
    this.f.color.disable();
  }

  public activarCampos() : void {
    this.f.nombre.enable();
    this.f.editorial.enable();
    this.f.tematica.enable();
    this.f.coleccion.enable();
    this.f.numeroPaginas.enable();
    this.f.precio.enable();
    this.f.autores.enable();
    this.f.color.enable();
    this.limpiarDatosComic();
  }
  
  public cerrar() : void {
    this.mostrarItem = false;
  }

  public irActualizar(comic : ComicDTO) : void {
    this.cerrar();
    this.router.navigate(['gestion-comic-actualizar', comic]);
  }
  
  public irBuscar() : void {
    this.cerrar();
    this.router.navigate(['buscar-comic']);
  }

  public comprarComic(comic :ComicDTO): void{
    this.cerrar();
    this.router.navigate(['comprar-comic', comic]);
  }

  get f() {
    return this.gestionarComicForm.controls;
  }
  public eliminarComic(comic : ComicDTO , posicion :number): void{
    console.log(comic)
    this.gestionComicsService.eliminarComic(comic.id).subscribe(data =>{
      console.log(data)
      if(data.exitoso){
        this.listaComics.splice(posicion,1);
      }
    })
  }
  

}
