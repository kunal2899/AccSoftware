import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BsheetComponent } from './bsheet.component';

describe('BsheetComponent', () => {
  let component: BsheetComponent;
  let fixture: ComponentFixture<BsheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BsheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BsheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
