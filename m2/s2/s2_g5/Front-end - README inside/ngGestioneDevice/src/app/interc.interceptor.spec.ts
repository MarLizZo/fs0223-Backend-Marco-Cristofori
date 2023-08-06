import { TestBed } from '@angular/core/testing';

import { IntercInterceptor } from './interc.interceptor';

describe('IntercInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      IntercInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: IntercInterceptor = TestBed.inject(IntercInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
