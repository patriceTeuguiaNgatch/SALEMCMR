import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonFinancialComponent } from './don-financial.component';

describe('DonFinancierComponent', () => {
  let component: DonFinancialComponent;
  let fixture: ComponentFixture<DonFinancialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DonFinancialComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonFinancialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
