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
import { Page } from "../common/page";


@Injectable()
export class OwnerService {


  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  private activitiesePath = '/activities/search/findByDisposition?disposition=DiscoverOwner&projection=activityWithQtree';
  // private activitiesePath = '/activities/27';
  private servicePath = '/userNatives/';
  private validateMigKey='/validate-migration-key/';

  // {{url}}/activities/search/findByDisposition?disposition=NFS-Orphan&projection=activityWithQtree
  // {{url}}
  getAllActivities(page: Page): Observable<any> {
    
    // return this.http.get(this.global.apiUrl + this.activitiesePath + "&page=" + page.number + "&size=" + page.size)
    return this.http.get(this.global.apiUrl +  "/activities?page=" + page.number + "&size=" + page.size)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  getQTreesForOwner(migKey): Observable<any> {
    console.log("getQTreesForOwner:", migKey);
    
    return this.http.get(this.global.apiUrl + this.servicePath)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }


  validateMigKeyExists(migKey: string, userCorpId: number):  Observable<any> {

      return this.http.get(this.global.apiUrl + this.validateMigKey + migKey + '/' + userCorpId)
      .map(res => res)
      .map((res: any) => {
        return res;
      });
    }

}
