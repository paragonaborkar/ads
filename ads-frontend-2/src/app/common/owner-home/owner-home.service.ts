import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';

@Injectable()
export class OwnerHomeService {

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  getActivitiesResponsesPending(userId): Observable<any> {
    return this.http
      .get(this.global.apiUrl  + "/migrationKeys/search/getActivitiesResponsesPending?corpUserId=" + userId)
      .map((res: Response) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }
}
