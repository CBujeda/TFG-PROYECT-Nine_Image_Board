import { TestBed } from '@angular/core/testing';

import { CommonvarsService } from './commonvars.service';

describe('CommonvarsService', () => {
  let service: CommonvarsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommonvarsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
