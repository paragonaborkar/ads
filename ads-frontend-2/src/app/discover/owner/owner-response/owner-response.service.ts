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

  saveOwnerResponse(obj): Observable<any> {
    console.log('create saveOwnerResponse:', obj);
    return this.http

      .patch(this.global.apiUrl + "/saveQtreeOwner/", obj)
      // .patch(this.global.apiUrl  +this.servicePath + activityId, obj)
      .map((res: Response) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  getCorpUserInfo(corpUserId): Observable<any> {

    return this.http
      .get(this.global.apiUrl + "/userCorporates/" + corpUserId)
      .map((res: Response) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );

  }

  getPotentialOwners(search): Observable<any> {

    let params = "?firstContains=" + search + "&lastContains=" + search + "&projection=UserCorporate";
    console.log("getPotentialOwners params " + params);
    return this.http
      .get(this.global.apiUrl + "/userCorporates/search/findByFirstNameContainingOrLastNameContaining" + params)
      .map((res: Response) => res["_embedded"]["userCorporates"]);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );

  }

}
