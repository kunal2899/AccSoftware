import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncatComponent } from './incat.component';

describe('IncatComponent', () => {
  let component: IncatComponent;
  let fixture: ComponentFixture<IncatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
