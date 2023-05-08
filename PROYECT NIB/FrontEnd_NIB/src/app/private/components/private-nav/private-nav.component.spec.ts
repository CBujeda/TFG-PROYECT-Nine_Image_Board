import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivateNavComponent } from './private-nav.component';

describe('PrivateNavComponent', () => {
  let component: PrivateNavComponent;
  let fixture: ComponentFixture<PrivateNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrivateNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrivateNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
