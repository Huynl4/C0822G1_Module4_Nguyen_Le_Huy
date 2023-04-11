import { TestBed } from '@angular/core/testing';

import { SanbongService } from './sanbong.service';

describe('SanbongService', () => {
  let service: SanbongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SanbongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
