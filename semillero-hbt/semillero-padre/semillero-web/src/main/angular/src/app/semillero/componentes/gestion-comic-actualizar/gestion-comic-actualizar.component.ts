import { Component, OnInit } from '@angular/core';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'gestion-comic-actualizar',
  templateUrl: './gestion-comic-actualizar.component.html',
  styleUrls: ['./gestion-comic-actualizar.component.css']
})
export class GestionComicActualizarComponent implements OnInit {
  
  public gestionarComicForm : FormGroup;
  public submitted : boolean;
  public comicDTO : ComicDTO;
  public id : number;
  constructor(private fb : FormBuilder, private router : Router, private gestionComicsService : GestionarComicService,private rutaActiva: ActivatedRoute) { 
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
    })
  }

  ngOnInit() {
    console.log(this.rutaActiva.snapshot.params);
    let comic : any = this.rutaActiva.snapshot.params;
    this.comicDTO = comic;
    this.gestionarComicForm.controls.nombre.setValue(this.rutaActiva.snapshot.params.nombre);
    this.gestionarComicForm.controls.autores.setValue(this.rutaActiva.snapshot.params.autores);
    this.gestionarComicForm.controls.coleccion.setValue(this.rutaActiva.snapshot.params.coleccion);
    this.gestionarComicForm.controls.editorial.setValue(this.rutaActiva.snapshot.params.editorial);
    this.gestionarComicForm.controls.color.setValue(this.rutaActiva.snapshot.params.color);
    this.gestionarComicForm.controls.numeroPaginas.setValue(this.rutaActiva.snapshot.params.numeroPaginas);
    this.gestionarComicForm.controls.tematica.setValue(this.rutaActiva.snapshot.params.tematicaEnum);
    this.gestionarComicForm.controls.precio.setValue(this.rutaActiva.snapshot.params.precio);
    this.gestionarComicForm.controls.cantidad.setValue(this.rutaActiva.snapshot.params.cantidad);
   ;
  }

  public actualizar():void{
    
    if (this.gestionarComicForm.invalid) {
      return;
    }
    console.log(this.gestionarComicForm);
    this.comicDTO = new ComicDTO();
    this.comicDTO.id = this.rutaActiva.snapshot.params.id;
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
    console.log(this.comicDTO)
    this.gestionComicsService.actualizarComic(this.comicDTO).subscribe(data =>{
      console.log(data)
      if(data.exitoso){
        this.router.navigate(['gestionar-comic']);
      }
    })
  }
}
