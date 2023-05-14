import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivateTagsComponent } from './private-tags.component';

describe('PrivateTagsComponent', () => {
  let component: PrivateTagsComponent;
  let fixture: ComponentFixture<PrivateTagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrivateTagsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrivateTagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
