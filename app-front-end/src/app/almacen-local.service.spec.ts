import { TestBed } from '@angular/core/testing';

import { AlmacenLocalService } from './almacen-local.service';

describe('AlmacenLocalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AlmacenLocalService = TestBed.get(AlmacenLocalService);
    expect(service).toBeTruthy();
  });
});
