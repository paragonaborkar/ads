import { Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { SessionHelper } from '../../auth/session.helper';
import { Globals } from '../../globals';


@Injectable()
export class AppPropertiesService{

  private propertiesServiceUrl = '';

	constructor(private http: HttpClient, private globals: Globals) { 

    this.propertiesServiceUrl = globals.apiUrl;

  }
  
  getSysConfigGroups():Observable<any> {    
    return this.http.get(this.propertiesServiceUrl+'/getSysConfigGroups')
      .map((res: Response) => res)
      .catch(this.handleError);
  }

  getSysConfigData(grouping:string):Observable<any> {    
    return this.http.get(this.propertiesServiceUrl+'/getSysConfigGroups/'+grouping)
      .map((res: Response) => res)
      .catch(this.handleError);
  }

  updateItem(infoToSend:any,item:number,grpName:string):Observable<any> {    
    return this.http
          .put('http://localhost:8080/sysConfigs/'+item, JSON.stringify(infoToSend))
      .map((res: Response) => {
        console.log("sys config calledd");
        res.json() as Object})
      .catch(this.handleError);
  }

  private handleError (error: Response | any) {
          // TODO: use a remote logging infrastructure
          let errMsg: string;
          if (error instanceof Response) {
            const body = error.json() || '';
            const err = JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
          } else {
            errMsg = error.message ? error.message : error.toString();
          }
    
          console.error(errMsg);
          return Observable.throw(errMsg);
      }}
