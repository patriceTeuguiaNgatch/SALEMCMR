import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonMaterialComponent } from './don-material.component';

describe('DonMaterialComponent', () => {
  let component: DonMaterialComponent;
  let fixture: ComponentFixture<DonMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DonMaterialComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
