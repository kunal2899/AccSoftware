import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankbComponent } from './bankb.component';

describe('BankbComponent', () => {
  let component: BankbComponent;
  let fixture: ComponentFixture<BankbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
