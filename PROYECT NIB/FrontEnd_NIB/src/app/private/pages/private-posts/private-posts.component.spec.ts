import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivatePostsComponent } from './private-posts.component';

describe('PrivatePostsComponent', () => {
  let component: PrivatePostsComponent;
  let fixture: ComponentFixture<PrivatePostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrivatePostsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrivatePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
