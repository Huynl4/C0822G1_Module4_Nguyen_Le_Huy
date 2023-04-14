import { TestBed } from '@angular/core/testing';

import { CoSoService } from './co-so.service';

describe('CoSoService', () => {
  let service: CoSoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoSoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
