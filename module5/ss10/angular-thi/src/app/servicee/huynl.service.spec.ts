import { TestBed } from '@angular/core/testing';

import { HuynlService } from './huynl.service';

describe('HuynlService', () => {
  let service: HuynlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HuynlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
