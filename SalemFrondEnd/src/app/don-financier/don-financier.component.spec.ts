import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonFinancierComponent } from './don-financier.component';

describe('DonFinancierComponent', () => {
  let component: DonFinancierComponent;
  let fixture: ComponentFixture<DonFinancierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonFinancierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonFinancierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
