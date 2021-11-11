import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarComicComponent } from './buscar-comic.component';

describe('BuscarComicComponent', () => {
  let component: BuscarComicComponent;
  let fixture: ComponentFixture<BuscarComicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuscarComicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscarComicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
