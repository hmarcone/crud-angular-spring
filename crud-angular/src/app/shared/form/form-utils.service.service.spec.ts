/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { FormUtils.serviceService } from './form-utils.service.service';

describe('Service: FormUtils.service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormUtils.serviceService]
    });
  });

  it('should ...', inject([FormUtils.serviceService], (service: FormUtils.serviceService) => {
    expect(service).toBeTruthy();
  }));
});
