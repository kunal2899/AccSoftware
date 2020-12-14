import { TestBed } from '@angular/core/testing';

import { ExpCatService } from './exp-cat.service';

describe('ExpCatService', () => {
  let service: ExpCatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExpCatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
