import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/catch'; 
import 'rxjs/add/operator/map';

import { Globals } from '../../globals';
import { Page } from "../../common/page";


@Injectable()
export class ControllerWorkPackageService {

  constructor(private http: HttpClient, private global: Globals) { }

  private servicePath = '/controllerWorkPackages/';


  getControllerTargetByProcessed(page: Page, processed: boolean): Observable<any> {

    let pageParam = "&page=" + page.number  + "&size=" + page.size;;
    let projectionParam = "&projection=ControllerWorkPackageListing";
    let sortParm = "&sort=createTime,desc";

    let url = this.global.apiUrl + this.servicePath + "search/findByProcessed?processed=" + processed + pageParam + sortParm + projectionParam;

    console.log(url);
    
    return this.http.get(url)
      .map((res: Response) => res)
      .catch(e => {
        return Observable.throw(Observable.of({error: e}));
      });

  }

  create(obj): Observable<any> {
    console.log('create controllerTargetsAvailable ', obj);
    return this.http
      .post(this.global.apiUrl +this.servicePath, obj)
      .map(function (response) {
        return response;
      })
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  
  delete(obj: Object): Observable<any> {
    console.log(obj);

    const url = obj['_links']['self']['href'];
    console.log('Calling delete for URL:' + url);
    return this.http
      .delete(url)
      .map(() => null)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }



}
