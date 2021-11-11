import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionComicActualizarComponent } from './gestion-comic-actualizar.component';

describe('GestionComicActualizarComponent', () => {
  let component: GestionComicActualizarComponent;
  let fixture: ComponentFixture<GestionComicActualizarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionComicActualizarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionComicActualizarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
