import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwCategrouesComponent } from './veiw-categroues.component';

describe('VeiwCategrouesComponent', () => {
  let component: VeiwCategrouesComponent;
  let fixture: ComponentFixture<VeiwCategrouesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VeiwCategrouesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VeiwCategrouesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
