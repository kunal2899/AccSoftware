import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpcatComponent } from './expcat.component';

describe('ExpcatComponent', () => {
  let component: ExpcatComponent;
  let fixture: ComponentFixture<ExpcatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpcatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpcatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
