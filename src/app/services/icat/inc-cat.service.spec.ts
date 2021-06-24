import { TestBed } from '@angular/core/testing';

import { IncCatService } from './inc-cat.service';

describe('IncCatService', () => {
  let service: IncCatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IncCatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
