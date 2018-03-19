import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../../common/ads-error.service';
import { Globals } from '../../../globals';

@Injectable()
export class OwnerResponseService {
  private servicePath = '/activityResponses/';

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  saveOwnerResponse(obj, activityId): Observable<any> {
    console.log('create saveOwnerResponse:', obj, activityId);
    return this.http
      .patch(this.global.apiUrl  +this.servicePath + activityId, obj)
      .map((res: Response) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }
}
