import { TestBed } from '@angular/core/testing';

import { IncService } from './inc.service';

describe('IncService', () => {
  let service: IncService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IncService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
