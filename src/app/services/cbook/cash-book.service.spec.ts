import { TestBed } from '@angular/core/testing';

import { CashBookService } from './cash-book.service';

describe('CashBookService', () => {
  let service: CashBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CashBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
