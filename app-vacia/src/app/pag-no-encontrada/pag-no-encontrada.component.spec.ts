import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagNoEncontradaComponent } from './pag-no-encontrada.component';

describe('PagNoEncontradaComponent', () => {
  let component: PagNoEncontradaComponent;
  let fixture: ComponentFixture<PagNoEncontradaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagNoEncontradaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagNoEncontradaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
