import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DaybComponent } from './dayb.component';

describe('DaybComponent', () => {
  let component: DaybComponent;
  let fixture: ComponentFixture<DaybComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DaybComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DaybComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
