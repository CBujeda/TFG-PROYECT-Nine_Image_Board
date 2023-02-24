import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NabarPostsComponent } from './nabar-posts.component';

describe('NabarPostsComponent', () => {
  let component: NabarPostsComponent;
  let fixture: ComponentFixture<NabarPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NabarPostsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NabarPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
