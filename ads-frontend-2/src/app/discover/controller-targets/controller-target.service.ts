import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/catch'; 
import 'rxjs/add/operator/map';

import { Globals } from '../../globals';


@Injectable()
export class ControllerTargetService {

  constructor(private http: HttpClient, private global: Globals) { }

  private servicePath = '/controllerTargetsAvailables';


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

}
