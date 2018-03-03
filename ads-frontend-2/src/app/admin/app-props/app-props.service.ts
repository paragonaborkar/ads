import { Injectable } from '@angular/core';



import { Headers, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Page } from "../../common/page";
import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';


@Injectable()
export class AppPropsService {

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  private servicePath = '/sysConfigs';
  private serviceSearchPath = '/sysConfigs/search';

  getSysConfigsByPage(page: Page): Observable<any> {
    return this.http.get(this.global.apiUrl + this.servicePath + "?page=" + page.number + "&size=" + page.size)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }


  getSysConfigGroups(): Observable<any> {
    return this.http.get(this.global.apiUrl + "/getSysConfigGroups")
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  getSysConfigData(page: Page, grouping: string): Observable<any> {
    return this.http.get(this.global.apiUrl + this.serviceSearchPath + '/findByGrouping?grouping=' + grouping + "&page=" + page.number + "&size=" + page.size)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }


  updateSysConfig(user: Object, url): Observable<Object> {

    return this.http
      .patch(url, user)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }



}
