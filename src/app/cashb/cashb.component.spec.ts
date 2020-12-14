import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CashbComponent } from './cashb.component';

describe('CashbComponent', () => {
  let component: CashbComponent;
  let fixture: ComponentFixture<CashbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CashbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CashbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
