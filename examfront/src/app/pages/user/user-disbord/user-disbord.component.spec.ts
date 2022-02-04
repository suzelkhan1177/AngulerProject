import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDisbordComponent } from './user-disbord.component';

describe('UserDisbordComponent', () => {
  let component: UserDisbordComponent;
  let fixture: ComponentFixture<UserDisbordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserDisbordComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDisbordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
