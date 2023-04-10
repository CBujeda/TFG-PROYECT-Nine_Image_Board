import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarStaticPageComponent } from './navbar-static-page.component';

describe('NavbarStaticPageComponent', () => {
  let component: NavbarStaticPageComponent;
  let fixture: ComponentFixture<NavbarStaticPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarStaticPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarStaticPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
