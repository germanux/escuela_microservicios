import { TestBed } from '@angular/core/testing';

import { UsuariosRestService } from './usuarios-rest.service';

describe('UsuariosRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsuariosRestService = TestBed.get(UsuariosRestService);
    expect(service).toBeTruthy();
  });
});
