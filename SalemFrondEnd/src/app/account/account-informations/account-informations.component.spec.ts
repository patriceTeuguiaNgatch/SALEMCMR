import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountInformationsComponent } from './account-informations.component';

describe('AccountInformationsComponent', () => {
  let component: AccountInformationsComponent;
  let fixture: ComponentFixture<AccountInformationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountInformationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountInformationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
