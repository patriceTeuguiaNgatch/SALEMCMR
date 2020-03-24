import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonInformationComponent } from './don-information.component';

describe('DonInformationComponent', () => {
  let component: DonInformationComponent;
  let fixture: ComponentFixture<DonInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
