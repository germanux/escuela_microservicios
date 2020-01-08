import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppRaizComponent } from './app-raiz.component';

describe('AppRaizComponent', () => {
  let component: AppRaizComponent;
  let fixture: ComponentFixture<AppRaizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppRaizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppRaizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
