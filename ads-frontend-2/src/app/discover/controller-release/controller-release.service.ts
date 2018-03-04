import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

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
    return this.http.get(this.global.apiUrl + this.servicePath + "search/findByProcessed?processed=" + processed +  "&page=" + page.number + "&size=" + page.size + "&projection=ControllerReleaseListing")
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }
}
