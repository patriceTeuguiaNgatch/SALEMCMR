import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalitesUtilisationComponent } from './modalites-utilisation.component';

describe('ModalitesUtilisationComponent', () => {
  let component: ModalitesUtilisationComponent;
  let fixture: ComponentFixture<ModalitesUtilisationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalitesUtilisationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalitesUtilisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
