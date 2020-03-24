import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonMaterielComponent } from './don-materiel.component';

describe('DonMaterielComponent', () => {
  let component: DonMaterielComponent;
  let fixture: ComponentFixture<DonMaterielComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonMaterielComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
