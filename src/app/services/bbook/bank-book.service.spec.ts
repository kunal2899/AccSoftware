import { TestBed } from '@angular/core/testing';

import { BankBookService } from './bank-book.service';

describe('BankBookService', () => {
  let service: BankBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
