import { Injectable } from '@angular/core';

import { Headers, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../common/ads-error.service';
import { Globals } from '../globals';

@Injectable()
export class OwnerService {


  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  private servicePath = '/userNatives/';


  getQTreesForOwner(migKey): Observable<any> {
    console.log("getQTreesForOwner:", migKey);
    
    return this.http.get(this.global.apiUrl + this.servicePath)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

}
