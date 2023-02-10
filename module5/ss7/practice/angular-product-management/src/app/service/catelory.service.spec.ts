import { TestBed } from '@angular/core/testing';

import { CateloryService } from './catelory.service';

describe('CateloryService', () => {
  let service: CateloryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CateloryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
