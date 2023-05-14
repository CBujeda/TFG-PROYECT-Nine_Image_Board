import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainTagsComponent } from './contain-tags.component';

describe('ContainTagsComponent', () => {
  let component: ContainTagsComponent;
  let fixture: ComponentFixture<ContainTagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContainTagsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContainTagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
