import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCategrouesComponent } from './add-categroues.component';

describe('AddCategrouesComponent', () => {
  let component: AddCategrouesComponent;
  let fixture: ComponentFixture<AddCategrouesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCategrouesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCategrouesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
