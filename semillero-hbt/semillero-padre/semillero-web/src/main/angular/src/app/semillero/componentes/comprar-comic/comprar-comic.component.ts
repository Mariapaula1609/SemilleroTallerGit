import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic-dto';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { Router } from '@angular/router';
import { CompraDTO } from '../../dto/comprar-dto';

@Component({
  selector: 'comprar-comic',
  templateUrl: './comprar-comic.component.html',
  styleUrls: ['./comprar-comic.component.css']
})
export class ComprarComicComponent implements OnInit {
  public comicDTO : ComicDTO;
  public cantidad : Number;
  public gestionarComicForm : FormGroup;
  public compra : CompraDTO;
  constructor(private fb : FormBuilder, private router : Router, private gestionComicsService : GestionarComicService,private rutaActiva: ActivatedRoute) {
    this.gestionarComicForm = this.fb.group({
      cantidad : [null, Validators.required]
    });
   }

  ngOnInit() {
    let comic : any = this.rutaActiva.snapshot.params;
    this.comicDTO = comic;
    console.log(this.comicDTO);
  }
  public comprarComic() :void{
    let compra = new CompraDTO;
    compra.id = this.comicDTO.id;
    compra.cantidad = this.gestionarComicForm.controls.cantidad.value;
    console.log(compra)
    this.gestionComicsService.comprarComic(compra).subscribe(data =>{
      console.log(data)
      if(data.exitoso){
        this.router.navigate(['gestionar-comic', data.mensajeEjecucion]);
      }
    });
  }
  public cerrar(){
    this.router.navigate(['gestionar-comic']);
  }

}
