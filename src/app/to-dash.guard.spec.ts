import { TestBed } from '@angular/core/testing';

import { ToDashGuard } from './to-dash.guard';

describe('ToDashGuard', () => {
  let guard: ToDashGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ToDashGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
