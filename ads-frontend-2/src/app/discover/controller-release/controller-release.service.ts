import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';
import { Page } from "../../common/page";

@Injectable()
export class ControllerReleaseService {

  private servicePath = '/controllerReleases/';

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  getControllerReleasesByProcessed(page: Page, processed: boolean): Observable<any> {
    let search = "search/findByProcessedFalse";
    if (processed)
      search = "search/findByProcessedTrue";

    // return this.http.get(this.global.apiUrl + this.servicePath + search + "?page=" + page.number + "&size=" + page.size)
    return this.http.get(this.global.apiUrl + this.servicePath + "search/findByProcessed?processed=" + processed + "&page=" + page.number + "&size=" + page.size + "&projection=ControllerReleaseListing")
      .map((res: Response) => res)
      .catch(e => {
        return Observable.throw(Observable.of({error: e}));
      })
        ;
      // .catch((error: HttpErrorResponse) => {
      //   console.log("ERROR *********************** ");
      //   console.log(error.status);
      //   if (error.status === 401) {
      //     console.log("GOT 401");
      //   } else {
      //     return Observable.throw(error);
      //   }
      // }
      // );

    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  searchForControllerReleases(page: Page, criteria: String): Observable<any> {

      
    return this.http.get(this.global.apiUrl + this.servicePath + "search/findByProcessed?criteria=" + criteria + "&page=" + page.number + "&size=" + page.size + "&projection=ControllerReleaseListing")
      .map((res: Response) => res);
      

    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  searchForController(criteria: String): Observable<any> {

    return this.http.get(this.global.apiUrl +"/controllers/search/findByControllerNameContaining?controllerNameContains=" + criteria + "&projection=ControllerId")
      .map((res: Response) => res["_embedded"]["controllers"])
      .do(x => console.log(x));
      // There were some posts on need to always return an observable, but didn't see this during development
      // .catch((error:any) => Observable.throw(error || 'Server error'));

    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }
}
