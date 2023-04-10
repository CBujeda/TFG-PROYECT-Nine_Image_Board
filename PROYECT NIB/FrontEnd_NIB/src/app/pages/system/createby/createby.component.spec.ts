import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatebyComponent } from './createby.component';

describe('CreatebyComponent', () => {
  let component: CreatebyComponent;
  let fixture: ComponentFixture<CreatebyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatebyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatebyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
